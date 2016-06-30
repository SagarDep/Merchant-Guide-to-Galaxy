/**
 * 
 */
package com.thoughtworks.marchant_guide.util;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * handle shared preferences
 *
 */
public class PreferenceHelper {

	private static PreferenceHelper preferenceHelperInstance = new PreferenceHelper();

	public final static String FIRST_TIME = "FirstTime";
	public final static String WHATS_NEW_LAST_SHOWN = "whats_new_last_shown";
	public final static String SUBMIT_LOGS = "CrashLogs";

	private PreferenceHelper() {
	}

	public void init(Context context) {

		if (!getPrefernceHelperInstace().getBoolean(context, FIRST_TIME, false)) {

			// App
			setBoolean(context, FIRST_TIME, true);

			// Support
			setBoolean(context, SUBMIT_LOGS, true);

		}

	}

	public static PreferenceHelper getPrefernceHelperInstace() {

		return preferenceHelperInstance;
	}

	public void setBoolean(Context appContext, String key, Boolean value) {

		PreferenceManager.getDefaultSharedPreferences(appContext).edit()
				.putBoolean(key, value).apply();
	}

	public void setInteger(Context appContext, String key, int value) {

		PreferenceManager.getDefaultSharedPreferences(appContext).edit()
				.putInt(key, value).apply();
	}

	public void setFloat(Context appContext, String key, float value) {

		PreferenceManager.getDefaultSharedPreferences(appContext).edit()
				.putFloat(key, value).apply();
	}

	public void setString(Context appContext, String key, String value) {

		PreferenceManager.getDefaultSharedPreferences(appContext).edit()
				.putString(key, value).apply();
	}

	// To retrieve values from shared preferences:

	public boolean getBoolean(Context appContext, String key,
			Boolean defaultValue) {

		return PreferenceManager.getDefaultSharedPreferences(appContext)
				.getBoolean(key, defaultValue);
	}

	public int getInteger(Context appContext, String key, int defaultValue) {

		return PreferenceManager.getDefaultSharedPreferences(appContext)
				.getInt(key, defaultValue);
	}

	public float getString(Context appContext, String key, float defaultValue) {

		return PreferenceManager.getDefaultSharedPreferences(appContext)
				.getFloat(key, defaultValue);
	}

	public String getString(Context appContext, String key, String defaultValue) {

		return PreferenceManager.getDefaultSharedPreferences(appContext)
				.getString(key, defaultValue);
	}

}
