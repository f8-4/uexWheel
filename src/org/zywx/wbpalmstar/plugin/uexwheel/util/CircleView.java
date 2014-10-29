package org.zywx.wbpalmstar.plugin.uexwheel.util;

import org.zywx.wbpalmstar.plugin.uexwheel.EUExWheel;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;

/**
 * 背景阴影view
 * 
 */
public class CircleView extends View {

	public CircleView(Context context) {
		super(context);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		LayoutParams lp = EUExWheel.circleLp;
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.argb(127, 0, 0, 0));
		paint.setAntiAlias(true); // 消除锯齿
		canvas.drawRect(0, 0, lp.width, lp.height, paint);
	}

}
