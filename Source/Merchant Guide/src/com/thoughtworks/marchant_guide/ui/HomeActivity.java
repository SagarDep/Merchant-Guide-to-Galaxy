package com.thoughtworks.marchant_guide.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.thoughtworks.marchant_guide.R;
import com.thoughtworks.marchant_guide.ui.fragment.HomeFragment;
import com.thoughtworks.marchant_guide.util.ActivitySplitAnimationUtil;

/**
 * The Class HomeActivity hold all fragments
 */
public class HomeActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		// Preparing the 2 images to be split
		ActivitySplitAnimationUtil.prepareAnimation(this);

		setContentView(R.layout.activity_home);

		// Single Activity Model
		getSupportFragmentManager().beginTransaction()
				.add(R.id.container, new HomeFragment()).commit();

		// Animating the items to be open, revealing the new activity
		ActivitySplitAnimationUtil.animate(this, 2000);

	}

}
