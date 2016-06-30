package com.thoughtworks.marchant_guide.ui.fragment;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.thoughtworks.marchant_guide.R;
import com.thoughtworks.marchant_guide.data.DataSource;
import com.thoughtworks.marchant_guide.data.TestDataSourceResourceArray;

/**
 * A placeholder fragment containing a information about galaxy conversion units
 */
public class GalxySystemFragment extends Fragment {

	private static final String GALAXY_NUMBER = "galaxy_number";

	public GalxySystemFragment() {
	}

	public static GalxySystemFragment newInstance(int sectionNumber) {
		GalxySystemFragment fragment = new GalxySystemFragment();
		Bundle args = new Bundle();
		args.putInt(GALAXY_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.frag_galaxy_system,
				container, false);

		// List of TextViews for conversion system display
		ArrayList<TextView> data = new ArrayList<TextView>();
		data.add((TextView) rootView.findViewById(R.id.one));
		data.add((TextView) rootView.findViewById(R.id.five));
		data.add((TextView) rootView.findViewById(R.id.ten));
		data.add((TextView) rootView.findViewById(R.id.fifty));
		data.add((TextView) rootView.findViewById(R.id.hundred));
		data.add((TextView) rootView.findViewById(R.id.five_hundred));
		data.add((TextView) rootView.findViewById(R.id.thousand));

		ArrayList<String> galaxyConversionUnits;

		DataSource dataSource = new TestDataSourceResourceArray();

		switch (getArguments().getInt(GALAXY_NUMBER)) {

		case TestDataSourceResourceArray.MILKEY_WAY_GALAXY:

			((TextView) rootView.findViewById(R.id.heading))
					.setText(getString(R.string.milkyway));

			Glide.with(this)
					.load("")
					.placeholder(R.drawable.milky_way)
					.fitCenter()
					.into(new GlideDrawableImageViewTarget((ImageView) rootView
							.findViewById(R.id.image)));

			// Get conversion unit for Milky way
			galaxyConversionUnits = dataSource.getGalaxyUnits(getActivity(),
					DataSource.MILKEY_WAY_GALAXY);

			for (int i = 0; i < data.size(); i++) {

				data.get(i).setText(galaxyConversionUnits.get(i));

			}

			break;

		case TestDataSourceResourceArray.ANDROMEDA_GALAXY:

			((TextView) rootView.findViewById(R.id.heading))
					.setText(getString(R.string.andromeda));

			Glide.with(this)
					.load("")
					.placeholder(R.drawable.andromeda)
					.fitCenter()
					.into(new GlideDrawableImageViewTarget((ImageView) rootView
							.findViewById(R.id.image)));

			// Get conversion unit for Andromeda
			galaxyConversionUnits = dataSource.getGalaxyUnits(getActivity(),
					DataSource.ANDROMEDA_GALAXY);

			break;

		default:

			((TextView) rootView.findViewById(R.id.heading))
					.setText(getString(R.string.unknown));

			// Get default conversion unit
			galaxyConversionUnits = dataSource.getGalaxyUnits(getActivity(), 3);

			break;
		}

		// set conversion units on textView
		for (int unitCounter = 0; unitCounter < data.size(); unitCounter++) {

			data.get(unitCounter).setText(
					galaxyConversionUnits.get(unitCounter));

		}

		return rootView;
	}
}