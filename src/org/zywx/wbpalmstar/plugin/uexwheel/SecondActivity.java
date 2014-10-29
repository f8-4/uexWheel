package org.zywx.wbpalmstar.plugin.uexwheel;

import org.zywx.wbpalmstar.plugin.uexwheel.util.SecondView;
import org.zywx.wbpalmstar.plugin.uexwheel.util.SecondView.OnTurnplateListener;
import org.zywx.wbpalmstar.plugin.uexwheel.util.SecondView.Point;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout.LayoutParams;

/**
 * 主Activity
 */
public class SecondActivity extends Activity implements OnTurnplateListener {

	private static Bitmap[] mData;
	private static Bitmap iconBg;
	private static OnTurnplateListener mListener;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LayoutParams lp = EUExWheel.circleLp;
		// 创建View
		SecondView myView = new SecondView(this, lp.width / 2, lp.height / 2,
				lp.width, mData, iconBg);
		// 设置监听
		myView.setOnTurnplateListener(this);
		// 填充View
		setContentView(myView);
	}

	@Override
	public void onPointTouch(Point point) {
		EUExWheel.circleCallback.getTag(point.flag + "");
		Log.i("onPointTouch:tag", point.flag + "");
		mListener.onPointTouch(point);
	}

    public static void setBitmaps(Bitmap[] menuIcons) {
        mData = menuIcons;
    }

    public static void setIconBg(Bitmap subMenuBg) {
        iconBg = subMenuBg;
    }

    public static void setOnTouchListener(OnTurnplateListener listener) {
        mListener = listener;
    }  
}
