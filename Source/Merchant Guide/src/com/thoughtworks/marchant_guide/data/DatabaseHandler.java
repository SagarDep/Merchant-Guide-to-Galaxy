package com.thoughtworks.marchant_guide.data;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.marchant_guide.model.GalaxyUnitSytem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * Manage Database for galaxy system User can add , remove , update
 *  Galaxy systems in DB for future references
 */
public class DatabaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "galaxyManager";

	// Contacts table name
	private static final String TABLE_GALAXY = "galaxy";

	// Contacts Table Columns names
	private static final String KEY_NAME = "name"; // Primary Key
	private static final String KEY_I = "one";
	private static final String KEY_V = "five";
	private static final String KEY_X = "ten";
	private static final String KEY_L = "fifty";
	private static final String KEY_C = "hundred";
	private static final String KEY_D = "five_hundred";
	private static final String KEY_M = "thousand";

	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_GALAXY + " ("
				+ KEY_NAME + " TEXT PRIMARY KEY UNIQUE, " + KEY_I + " TEXT, "
				+ KEY_V + " TEXT, " + KEY_X + " TEXT, " + KEY_L + " TEXT, "
				+ KEY_C + " TEXT, " + KEY_D + " TEXT, " + KEY_M + " TEXT" + ")";
		db.execSQL(CREATE_CONTACTS_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GALAXY);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */

	public// Adding new galaxy
	void addContact(GalaxyUnitSytem contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getGalaxyName()); // Galaxy Name
		values.put(KEY_I, contact.getI());
		values.put(KEY_V, contact.getV());
		values.put(KEY_X, contact.getX());
		values.put(KEY_L, contact.getL());
		values.put(KEY_C, contact.getC());
		values.put(KEY_D, contact.getD());
		values.put(KEY_M, contact.getM());

		// Inserting Row without duplication
		db.insertWithOnConflict(TABLE_GALAXY, null, values,
				SQLiteDatabase.CONFLICT_REPLACE);
		db.close(); // Closing database connection
	}

	// Getting galaxy contact
	GalaxyUnitSytem getGalaxy(String galaxyName) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_GALAXY, new String[] { KEY_NAME, KEY_I,
				KEY_V, KEY_X, KEY_L, KEY_C, KEY_D, KEY_M }, KEY_NAME + "=?",
				new String[] { KEY_NAME }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		GalaxyUnitSytem contact = new GalaxyUnitSytem(cursor.getString(0),
				cursor.getString(1), cursor.getString(2), cursor.getString(3),
				cursor.getString(4), cursor.getString(5), cursor.getString(6),
				cursor.getString(7));
		// return contact
		return contact;
	}

	// Getting All galaxy
	public List<GalaxyUnitSytem> getAllGalaxy() {
		List<GalaxyUnitSytem> contactList = new ArrayList<GalaxyUnitSytem>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_GALAXY;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				GalaxyUnitSytem contact = new GalaxyUnitSytem(
						cursor.getString(0), cursor.getString(1),
						cursor.getString(2), cursor.getString(3),
						cursor.getString(4), cursor.getString(5),
						cursor.getString(6), cursor.getString(7));
				// Adding contact to list
				contactList.add(contact);
			} while (cursor.moveToNext());
		}

		// return contact list
		return contactList;
	}

	// Updating single galaxy
	public int updateGalaxy(GalaxyUnitSytem contact) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getGalaxyName()); // Galaxy Name
		values.put(KEY_I, contact.getI());
		values.put(KEY_V, contact.getV());
		values.put(KEY_X, contact.getX());
		values.put(KEY_L, contact.getL());
		values.put(KEY_C, contact.getC());
		values.put(KEY_D, contact.getD());
		values.put(KEY_M, contact.getM());

		// updating row
		return db.update(TABLE_GALAXY, values, KEY_NAME + " = ?",
				new String[] { String.valueOf(contact.getGalaxyName()) });
	}

	// Deleting single galaxy
	public void deleteGalaxy(GalaxyUnitSytem contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_GALAXY, KEY_NAME + " = ?",
				new String[] { String.valueOf(contact.getGalaxyName()) });
		db.close();
	}

	// Getting galaxy Count
	public int getGalaxyCount() {
		String countQuery = "SELECT  * FROM " + TABLE_GALAXY;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}
}