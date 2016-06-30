package com.thoughtworks.marchant_guide.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import com.thoughtworks.marchant_guide.R;
import com.thoughtworks.marchant_guide.convertor.UniversalConstants;
import com.thoughtworks.marchant_guide.ui.HomeActivity;
import com.thoughtworks.marchant_guide.ui.adapter.GalaxySystemAdapter;

public class SelectGalaxySystemDialogFragment extends DialogFragment {

	private ImageView[] indicators;
	private ImageView zero, one, two;
	private int page = 0; // to track page position

	private DialogCloseListener mListener;

	public SelectGalaxySystemDialogFragment(DialogCloseListener listener) {

		mListener = listener;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.dialog_choose_galaxy, container);

		zero = (ImageView) view.findViewById(R.id.intro_indicator_0);
		one = (ImageView) view.findViewById(R.id.intro_indicator_1);
		two = (ImageView) view.findViewById(R.id.intro_indicator_2);

		indicators = new ImageView[] { zero, one, two };

		ViewPager mViewPager = (ViewPager) view.findViewById(R.id.galaxy_pager);

		GalaxySystemAdapter galaxySystemAdapter = new GalaxySystemAdapter(
				getChildFragmentManager());

		mViewPager.setAdapter(galaxySystemAdapter);

		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		updateIndicators(0);

		mViewPager
				.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
					@Override
					public void onPageScrolled(int position,
							float positionOffset, int positionOffsetPixels) {

					}

					@Override
					public void onPageSelected(int position) {

						page = position;

						updateIndicators(page);

					}

					@Override
					public void onPageScrollStateChanged(int state) {

					}
				});

		view.findViewById(R.id.btn_finish).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						dismiss();

					}
				});

		view.findViewById(R.id.btn_select).setOnClickListener(
				new OnClickListener() {

					@Override
					public void onClick(View v) {

						dismiss();

						mListener.OnCloseDialog(page);

					}
				});

		return view;
	}

	void updateIndicators(int position) {
		for (int i = 0; i < indicators.length; i++) {
			indicators[i]
					.setBackgroundResource(i == position ? R.drawable.indicator_selected
							: R.drawable.indicator_unselected);
		}
	}

}