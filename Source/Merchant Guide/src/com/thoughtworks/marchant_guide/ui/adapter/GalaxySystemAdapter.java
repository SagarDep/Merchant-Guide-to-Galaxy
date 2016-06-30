package com.thoughtworks.marchant_guide.ui.adapter;

import com.thoughtworks.marchant_guide.ui.fragment.GalxySystemFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Fragment Adapter to display galaxy sytems in View pager of choose galaxy
 * system dialog
 */
public class GalaxySystemAdapter extends FragmentPagerAdapter {

	public GalaxySystemAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		// getItem is called to instantiate the fragment for the given page.
		// Return a PlaceholderFragment (defined as a static inner class
		// below).
		return GalxySystemFragment.newInstance(position);

	}

	@Override
	public int getCount() {
		// Show 3 total pages.
		return 3;
	}

}