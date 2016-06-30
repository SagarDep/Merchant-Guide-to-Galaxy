package com.thoughtworks.marchant_guide.util;

import android.content.Context;
import android.os.Vibrator;

public class Utils {

	/*
	 * Vibrate to give feel of hardware key press in virtual keyboard
	 */
	public static void vibrate(Context context) {
		Vibrator vibs = (Vibrator) context
				.getSystemService(Context.VIBRATOR_SERVICE);
		vibs.vibrate(50);
	}

}
