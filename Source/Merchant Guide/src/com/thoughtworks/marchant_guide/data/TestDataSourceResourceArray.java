package com.thoughtworks.marchant_guide.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import android.content.Context;

import com.thoughtworks.marchant_guide.R;
import com.thoughtworks.marchant_guide.convertor.UniversalCurrencyConvertor;

/*
 * Data provider according to Galaxy system from Resource Array
 */
public class TestDataSourceResourceArray implements DataSource {

	@Override
	public ArrayList<String> getGalaxyUnits(Context context, int planetIndex) {

		switch (planetIndex) {
		case MILKEY_WAY_GALAXY:
			return new ArrayList<String>(Arrays.asList(context.getResources()
					.getStringArray(R.array.MilkyWay)));

		case ANDROMEDA_GALAXY:
			return new ArrayList<String>(Arrays.asList(context.getResources()
					.getStringArray(R.array.Andromeda)));

		default:

			return new ArrayList<String>(Arrays.asList(context.getResources()
					.getStringArray(R.array.Default)));

		}
	}

	/*
	 * Data Source resource Array
	 */
	@Override
	public LinkedHashMap<Character, String> getGalaxyUnitMap(Context context,
			int planetIndex) {

		List<String> units;

		switch (planetIndex) {
		case MILKEY_WAY_GALAXY:
			units = Arrays.asList(context.getResources().getStringArray(
					R.array.MilkyWay));

			break;

		case ANDROMEDA_GALAXY:
			units = Arrays.asList(context.getResources().getStringArray(
					R.array.Andromeda));
			break;

		default:

			units = Arrays.asList(context.getResources().getStringArray(
					R.array.Default));
			break;

		}

		List<Character> keys = new ArrayList<Character>(
				UniversalCurrencyConvertor.getCurrencyInstance()
						.getCurrencyMap().keySet());

		for (int i = 0; i < keys.size(); i++) {

			unitConversionMap.put(keys.get(i), units.get(i));
		}

		return unitConversionMap;
	}

}
