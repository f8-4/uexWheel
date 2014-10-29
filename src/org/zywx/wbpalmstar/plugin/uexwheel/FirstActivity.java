package org.zywx.wbpalmstar.plugin.uexwheel;

import java.util.ArrayList;
import java.util.List;

import org.zywx.wbpalmstar.engine.universalex.EUExUtil;
import org.zywx.wbpalmstar.plugin.uexwheel.bean.CircleBean;
import org.zywx.wbpalmstar.plugin.uexwheel.util.CircleAnimation;
import org.zywx.wbpalmstar.plugin.uexwheel.util.ImageUtil;
import org.zywx.wbpalmstar.plugin.uexwheel.util.SecondView.OnTurnplateListener;
import org.zywx.wbpalmstar.plugin.uexwheel.util.SecondView.Point;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;

@SuppressLint("InlinedApi")
public class FirstActivity extends Activity implements OnClickListener,
		OnTurnplateListener {

	private LinearLayout rl_bg1;
	private LinearLayout rl_bg2;
	private Boolean flag = true;
	private List<LinearLayout> linears;
	private View secondview;
	private CircleAnimation animation;
	private View translucentView;
	private LayoutParams lp;
	private static CircleBean bean;
	private int mTabCount;
    private Bitmap[] mTabs;
    private final static int BUTTON_HEIGHT = 150;
    private int mCurrentIndex = -1;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(EUExUtil.getResLayoutID("plugin_uexwheel3_main"));
		initView();
		rl_bg2.setVisibility(View.GONE);
		Intent intent = new Intent(this, BackGroundActivity.class);
		// 获取下一个activity的view
		translucentView = EUExWheel.mgr.startActivity(
				BackGroundActivity.TAG, intent).getDecorView();
		translucentView.setVisibility(View.GONE);
	}

	@Override
	protected void onDestroy() {
		flag = true;
		secondview = null;
		super.onDestroy();
	}

	private void initView() {
	    mTabs = bean.getTabs();
	    mTabCount = mTabs.length;
	    linears = new ArrayList<LinearLayout>();
		rl_bg1 = (LinearLayout) findViewById(EUExUtil.getResIdID("rl_bg1"));
		rl_bg1.getLayoutParams().width = BUTTON_HEIGHT;
		rl_bg1.getLayoutParams().height = BUTTON_HEIGHT;
        ImageUtil.setBackgroundBitmap(this, rl_bg1, bean.getButton());
		rl_bg1.setOnClickListener(this);
		rl_bg2 = (LinearLayout) findViewById(EUExUtil.getResIdID("rl_bg2"));
		rl_bg2.getLayoutParams().height = BUTTON_HEIGHT;
		ImageUtil.setBackgroundBitmap(this, rl_bg2, bean.getMenuBg());
		for (int i = 0; i < mTabCount; i++) {
		    final int index = i;
            LinearLayout ll = new LinearLayout(getApplicationContext());
            ll.setGravity(Gravity.CENTER);
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1.0f);
            ll.setLayoutParams(lp);
            ll.setPadding(10, 0, 0, 0);
            rl_bg2.addView(ll);
            ImageView iv = new ImageView(getApplicationContext());
            LinearLayout.LayoutParams ivlp = new LinearLayout.LayoutParams(
                    (int)(BUTTON_HEIGHT*0.6), (int)(BUTTON_HEIGHT*0.6));
            iv.setLayoutParams(ivlp);
            iv.setImageBitmap(mTabs[i]);
            ll.addView(iv);
            ll.setOnClickListener(new OnClickListener() {
                
                @Override
                public void onClick(View v) {
                    updateButtonStatus(index);
                }
            });
            linears.add(ll);
        }
		updateButtonStatus(0);
	}

	protected void updateButtonStatus(int index) {
	    if(mCurrentIndex == index){
	        return;
	    }
	    mCurrentIndex = index;
	    switch (index) {
            case 0:
                ImageUtil.setBackgroundBitmap(this, linears.get(index), bean.getSelectedFirstMenuBg());
                for (int i = 1; i < mTabCount; i++) {
                    ImageUtil.setBackgroundBitmap(this, linears.get(i), null);
                }
                break;
    
            default:
                for (int i = 0; i < mTabCount; i++) {
                    if(index == i){
                        ImageUtil.setBackgroundBitmap(this, linears.get(i), bean.getSelectedMenuBg());
                    }else{
                        ImageUtil.setBackgroundBitmap(this, linears.get(i), null);
                    }
                }
                break;
        }
	    changeViewAnim();
    }

    @SuppressWarnings("deprecation")
	@Override
	public void onClick(View v) {
        secondview = getSecondView(mCurrentIndex);
		animation = new CircleAnimation();
		if (v.getId() == EUExUtil.getResIdID("rl_bg1")) {
			if (flag) {
				rl_bg2.setVisibility(View.VISIBLE);
				animation.startAnimationIN(rl_bg2, 500);
				animation.startAnimationAdd((ViewGroup) secondview, 500, 0);
				if (translucentView.getVisibility() != View.VISIBLE) {
					translucentView.setVisibility(View.VISIBLE);
				}
				RelativeLayout.LayoutParams lparm = getSecondViewlp();
				EUExWheel.circleCallback.addView(translucentView,
						lparm);
				EUExWheel.circleCallback.addView(secondview, lparm);
				flag = false;
			} else {
				animation.startAnimationRemove((ViewGroup) secondview, 200, 0);
				animation.startAnimationOUT(rl_bg2, 500, 0);
				EUExWheel.circleCallback.removeView(secondview);
				EUExWheel.circleCallback.removeView(translucentView);
				if (translucentView.getVisibility() == 1) {
					translucentView.setVisibility(8);
				}
				flag = true;
			}
		}
	}

    private View getSecondView(int index){
        Intent intent = new Intent(this, SecondActivity.class);
        // 获取下一个activity的view
        SecondActivity.setBitmaps(bean.getMenuIcons(index));
        SecondActivity.setIconBg(bean.getSubMenuBg());
        SecondActivity.setOnTouchListener(this);
        View view = EUExWheel.mgr.startActivity(
                EUExWheel.TAG_CIRCLE_CIRCLE, intent).getDecorView();
        EUExWheel.onPointTouchListener(this);
        return view;
    }
    
    private RelativeLayout.LayoutParams getSecondViewlp(){
        lp = EUExWheel.circleLp;
        RelativeLayout.LayoutParams lparm = new RelativeLayout.LayoutParams(
                lp.width, lp.height);
        lparm.leftMargin = lp.leftMargin;
        lparm.topMargin = lp.topMargin;
        return lparm;
    }
    
	// 点击导航的视图切换动画
	public void changeViewAnim() {
	    if(secondview == null){
	        return;
	    }
		startAnimationRemoveThenAdd(200, 0);
	}

    public void startAnimationRemoveThenAdd(final int duration, int startOffSet) {
        Animation animation;
        EUExWheel.mgr.destroyActivity(EUExWheel.TAG_CIRCLE_CIRCLE, true);
        EUExWheel.circleCallback.removeView(secondview);
        secondview = getSecondView(mCurrentIndex);
        EUExWheel.circleCallback.addView(secondview, getSecondViewlp());
        animation = new ScaleAnimation(0, 1.0f, 0, 1.0f,
                Animation.ABSOLUTE, lp.width / 2, Animation.ABSOLUTE,
                lp.height / 2);
        animation.setFillAfter(true);
        animation.setDuration(duration);
        animation.setStartOffset(200);
        secondview.startAnimation(animation);
    }	
	
	
	/**
	 * 移除轮盘菜单
	 */
	public void removeView() {
		CircleAnimation myAnimation = new CircleAnimation();
		myAnimation.startAnimationOUT(rl_bg2, 500, 0);
		myAnimation.startAnimationRemove((ViewGroup) secondview, 200, 0);
		EUExWheel.mgr.destroyActivity(EUExWheel.TAG_CIRCLE_CIRCLE, true);
		EUExWheel.circleCallback.removeView(secondview);
		EUExWheel.circleCallback.removeView(translucentView);
		flag = true;
	}

	@Override
	public void onPointTouch(Point point) {
	    removeView();
	}

    public static void setDataBean(CircleBean mCircleBean) {
        bean = mCircleBean;
    }

}
