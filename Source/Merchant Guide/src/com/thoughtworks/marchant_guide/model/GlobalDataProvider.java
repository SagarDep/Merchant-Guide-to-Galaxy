package com.thoughtworks.marchant_guide.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;

import com.thoughtworks.marchant_guide.data.DataSource;
import com.thoughtworks.marchant_guide.data.TestDataSourceResourceArray;

/**
 * The Class GlobalDataProvider.
 */
public class GlobalDataProvider {

	/** The data provider. */
	private static GlobalDataProvider dataProvider;
	
	/** The galaxy conversion units. */
	private HashMap<Character, String> galaxyConversionUnits;
	
	/** The keys. */
	private List<Character> keys = new ArrayList<Character>();
	
	/** The data source. */
	private DataSource dataSource = new TestDataSourceResourceArray();

	/**
	 * Gets the global data provider.
	 *
	 * @return the global data provider
	 */
	public static GlobalDataProvider getGlobalDataProvider() {

		if (null == dataProvider) {
			dataProvider = new GlobalDataProvider();
		}
		return dataProvider;

	}

	/**
	 * Instantiates a new global data provider.
	 */
	private GlobalDataProvider() {

	}

	/**
	 * Inits the.
	 *
	 * @param context the context
	 */
	public void init(Context context) {

		galaxyConversionUnits = dataSource.getGalaxyUnitMap(context, 3);
	}

	/**
	 * Gets the galaxy conversion units.
	 *
	 * @return the galaxyConversionUnits
	 */
	public HashMap<Character, String> getGalaxyConversionUnits() {
		return galaxyConversionUnits;
	}

	/**
	 * Update galaxy conversion units.
	 *
	 * @param galaxyIndex the galaxy index
	 * @param context the context
	 */
	public void updateGalaxyConversionUnits(int galaxyIndex, Context context) {

		switch (galaxyIndex) {
		case TestDataSourceResourceArray.MILKEY_WAY_GALAXY:

			galaxyConversionUnits = dataSource.getGalaxyUnitMap(context,
					TestDataSourceResourceArray.MILKEY_WAY_GALAXY);

			break;

		case TestDataSourceResourceArray.ANDROMEDA_GALAXY:

			galaxyConversionUnits = dataSource.getGalaxyUnitMap(context,
					TestDataSourceResourceArray.ANDROMEDA_GALAXY);

			break;

		default:
			break;
		}

		keys = new ArrayList<Character>(galaxyConversionUnits.keySet());
	}

	/**
	 * Gets the key mapping.
	 *
	 * @param keyIndex the key index
	 * @return the key mapping
	 */
	public String getKeyMapping(int keyIndex) {

		return galaxyConversionUnits.get(keys.get(keyIndex));

	}

}
