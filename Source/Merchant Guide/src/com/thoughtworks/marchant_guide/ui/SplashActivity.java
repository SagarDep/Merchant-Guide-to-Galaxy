package com.thoughtworks.marchant_guide.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.thoughtworks.marchant_guide.R;
import com.thoughtworks.marchant_guide.util.ActivitySplitAnimationUtil;

/**
 * The Class SplashActivity used for splash screen animation.
 */
public class SplashActivity extends FragmentActivity {

	private static final long SPLASH_DISPLAY_LENGTH = 3000;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		setContentView(R.layout.activity_splash_screen);

		// Load Gif with glide
		Glide.with(this)
				.load(R.raw.splash)
				.into(new GlideDrawableImageViewTarget(
						(ImageView) findViewById(R.id.image)));

		// Show fade in animation for app name
		AlphaAnimation alpha = new AlphaAnimation(0.0f, 1.0f);
		alpha.setDuration(2000);
		alpha.setFillAfter(true);
		alpha.start();
		((TextView) findViewById(R.id.shimmer_tv)).startAnimation(alpha);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {

				ActivitySplitAnimationUtil.startActivity(SplashActivity.this,
						new Intent(SplashActivity.this, HomeActivity.class));

				SplashActivity.this.finish();

			}
		}, SPLASH_DISPLAY_LENGTH);

	}
}