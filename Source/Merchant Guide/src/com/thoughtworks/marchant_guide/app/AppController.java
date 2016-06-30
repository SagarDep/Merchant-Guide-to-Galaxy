package com.thoughtworks.marchant_guide.app;

import org.acra.ACRA;
import org.acra.ReportField;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;

import android.app.Application;

import com.thoughtworks.marchant_guide.R;
import com.thoughtworks.marchant_guide.util.PreferenceHelper;

@ReportsCrashes(mailTo = "hiteshkumarsahu1990@gmail.com", customReportContent = {
		ReportField.APP_VERSION_CODE, ReportField.APP_VERSION_NAME,
		ReportField.ANDROID_VERSION, ReportField.PHONE_MODEL,
		ReportField.CUSTOM_DATA, ReportField.STACK_TRACE, ReportField.LOGCAT }, mode = ReportingInteractionMode.TOAST, resToastText = R.string.crash_toast_text)
public class AppController extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		PreferenceHelper.getPrefernceHelperInstace().init(
				getApplicationContext());

		//Set up crash log reporting will ACRA
		if (PreferenceHelper.getPrefernceHelperInstace().getBoolean(
				getApplicationContext(), PreferenceHelper.SUBMIT_LOGS, true)) {
			ACRA.init(this);
		}

	}

}
