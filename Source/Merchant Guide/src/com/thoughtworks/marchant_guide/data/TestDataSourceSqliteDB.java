package com.thoughtworks.marchant_guide.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import android.content.Context;

import com.thoughtworks.marchant_guide.convertor.UniversalCurrencyConvertor;

/*
 *  Data provider according to Galaxy system from sQlite DB
 */
public class TestDataSourceSqliteDB implements DataSource {

	@Override
	public ArrayList<String> getGalaxyUnits(Context context, int planetIndex) {

		DatabaseHandler db = new DatabaseHandler(context);

		switch (planetIndex) {
		case MILKEY_WAY_GALAXY:
			return db.getGalaxy("Milky Way").toList();

		case ANDROMEDA_GALAXY:
			return db.getGalaxy("Andromeda").toList();

		default:

			return db.getGalaxy("Default").toList();
		}
	}

	/*
	 * Data Source sqlite DataBase
	 */
	@Override
	public LinkedHashMap<Character, String> getGalaxyUnitMap(Context context,
			int planetIndex) {
		LinkedHashMap<Character, String> unitConversionMap = new LinkedHashMap<Character, String>();

		ArrayList<String> units;
		DatabaseHandler db = new DatabaseHandler(context);

		switch (planetIndex) {
		case MILKEY_WAY_GALAXY:
			units = db.getGalaxy("Milky Way").toList();

			break;

		case ANDROMEDA_GALAXY:

			units = db.getGalaxy("Andromeda").toList();

			break;

		default:
			units = db.getGalaxy("Default").toList();

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
	
	
//	/**
//	 * CRUD Operations
//	 * */
//
//	// Reading all Galaxy
//	Log.d("Reading: ", "Reading all Galaxy..");
//	List<GalaxyUnitSytem> galaxies = db.getAllGalaxy();
//
//	for (GalaxyUnitSytem cn : galaxies) {
//		String log = "Name   " + cn.getGalaxyName() + "\n I " + cn.getI()
//				+ "\n V " + cn.getV() + "\n X " + cn.getX() + "\n L "
//				+ cn.getL() + "\n C " + cn.getC() + "\n D " + cn.getD()
//				+ "\n M " + cn.getM();
//		// Writing Contacts to log
//		Log.e("Name: ", log);
//	}

//	// Deleting all Galaxy
//	Log.d("Deleting: ", "Deleting all Galaxy..");
//
//	db.deleteContact(new GalaxyUnitSytem("Milky Way", "ONE", "FIVE", "TEN",
//			"FIFTY", "HUNDRED", "FIVE_HUNDRED", "THOUSAND"));
//
//	db.deleteContact(new GalaxyUnitSytem("Andromeda", "glob", "prok",
//			"pish", "tegj", "zedi", "seti", "glax"));
//
	// Inserting Galaxy
//	Log.e("Insert: ", "Inserting ..");
//	db.addContact(new GalaxyUnitSytem("Milky Way", "ONE", "FIVE", "TEN",
//			"FIFTY", "HUNDRED", "FIVE_HUNDRED", "THOUSAND"));
//
//	db.addContact(new GalaxyUnitSytem("Andromeda", "glob", "prok", "pish",
//			"tegj", "zedi", "seti", "glax"));


}
