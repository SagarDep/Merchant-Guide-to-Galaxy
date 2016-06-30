package com.thoughtworks.marchant_guide.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import android.content.Context;

// TODO: Auto-generated Javadoc
/**
 * The Interface DataSource.
 */
public interface DataSource {

	/** The Constant ANDROMEDA_GALAXY. */
	public static final int ANDROMEDA_GALAXY = 1;
	
	/** The Constant MILKEY_WAY_GALAXY. */
	public static final int MILKEY_WAY_GALAXY = 0;

	/** The unit conversion map. */
	LinkedHashMap<Character, String> unitConversionMap = new LinkedHashMap<Character, String>();

	/**
	 * Gets the galaxy unit map.
	 *
	 * @param context the context
	 * @param planetIndex the planet index
	 * @return the galaxy unit map
	 */
	LinkedHashMap<Character, String> getGalaxyUnitMap(Context context,
			int planetIndex);

	/**
	 * Gets the galaxy units.
	 *
	 * @param context the context
	 * @param planetIndex the planet index
	 * @return the galaxy units
	 */
	ArrayList<String> getGalaxyUnits(Context context, int planetIndex);

}
