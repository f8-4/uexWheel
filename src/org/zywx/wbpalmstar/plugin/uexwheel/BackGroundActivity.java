package org.zywx.wbpalmstar.plugin.uexwheel;

import org.zywx.wbpalmstar.plugin.uexwheel.util.CircleView;

import android.app.Activity;
import android.os.Bundle;

/**
 * 背景activity
 */
public class BackGroundActivity extends Activity {

	public static final String TAG = "BackGroundActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CircleView myView = new CircleView(this);
		setContentView(myView);
	}
}
