package com.example.wid;

import java.text.*;
import java.util.Calendar;
import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.*;

public class db {
	public db(Context c) {
		ourContext = c;
	}

	public static final String key_id = "id";
	public static final String key_name = "name";
	public static final String key_date = "date";
	public static final String key_difficulty = "difficulty";
	public static final String key_ques = "ques";
	public static final String key_ans = "ans";
	public static final String key_explain = "explain";
	public static final String key_ans_img = "ans_img";
	public static final String key_img = "img";
	public static final String key_hint1 = "hint1";
	public static final String key_hint2 = "hint2";

	public static final String database_name = "puzzle";
	public static final String database_table = "one";
	public static final int database_version = 2;

	private DbHelper ourHelper;
	private final Context ourContext;
	private SQLiteDatabase ourDatabase;

	private static class DbHelper extends SQLiteOpenHelper {
		public DbHelper(Context context) {
			super(context, database_name, null, database_version);
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			// TODO Auto-generated method stub
			db.execSQL("create table " + database_table + " (" + key_id
					+ " integer primary key autoincrement, " + key_name
					+ " varchar(50) not null, " + key_date + " varchar(20), "
					+ key_difficulty + " integer, " + key_ques
					+ " varchar(500) not null, " + key_ans
					+ " varchar(100) not null, " + key_explain
					+ " varchar(500), " + key_ans_img + " varchar(20), "
					+ key_img + " varchar(20), " + key_hint1
					+ " varchar(100), " + key_hint2 + " varchar(100) );");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("drop table if exists " + database_table);
			onCreate(db);
		}
		
	}

	public db open() {
		ourHelper = new DbHelper(ourContext);
		ourDatabase = ourHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		ourHelper.close();
	}
	public void createEntry(String name, String date, String difficulty, String ques, String ans, String explain, String ans_img, String img, String hint1, String hint2 ){
		ContentValues cv = new ContentValues();
		cv.put(key_name, name);
		cv.put(key_date, date);
		cv.put(key_difficulty, difficulty);
		cv.put(key_ques, ques);
		cv.put(key_ans, ans);
		cv.put(key_ans_img, ans_img);
		cv.put(key_img, img);
		cv.put(key_explain, explain);
		cv.put(key_hint1, hint1);
		cv.put(key_hint2, hint2);
		
		
	}

	public String getDate() {

		SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		return reportDate;
	}

	public String getHint1() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_hint1, key_date };
		Cursor c = ourDatabase.query(database_table, cols, null, null, null,
				null, null);

		int iHint1 = c.getColumnIndex(key_hint1);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate) == getDate()) {
				return c.getString(iHint1);
			}
		}
		String result = "No hints available";
		return result;
	}

	public String getHint2() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_hint2, key_date };
		Cursor c = ourDatabase.query(database_table, cols, null, null, null,
				null, null);

		int iHint2 = c.getColumnIndex(key_hint2);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate) == getDate()) {
				return c.getString(iHint2);
			}
		}
		String result = "No hints available";
		return result;
	}

	public String getImg() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_img, key_date };
		Cursor c = ourDatabase.query(database_table, cols, null, null, null,
				null, null);

		int iImg = c.getColumnIndex(key_img);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate) == getDate()) {
				return c.getString(iImg);
			}
		}
		String result = "No hints available";
		return result;
	}

	public String getQues() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_ques, key_date };
		Cursor c = ourDatabase.query(database_table, cols, null, null, null,
				null, null);

		int iQues = c.getColumnIndex(key_ques);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate) == getDate()) {
				return c.getString(iQues);
			}
		}
		String result = "Have Patience";
		return result;
	}

	public String getDifficulty() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_difficulty, key_date };
		Cursor c = ourDatabase.query(database_table, cols, null, null, null,
				null, null);

		int iDiff = c.getColumnIndex(key_difficulty);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate) == getDate()) {
				return c.getString(iDiff) + " stars";
			}
		}
		String result = "Have Patience";
		return result;
	}

	public String getName() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_name, key_date };
		Cursor c = ourDatabase.query(database_table, cols, null, null, null,
				null, null);

		int iName = c.getColumnIndex(key_name);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate) == getDate()) {
				return c.getString(iName);
			}
		}
		String result = "Have Patience";
		return result;
	}

	public String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("HH");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		return reportDate;
	}

	public String getAns() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_ans, key_explain, key_date };
		Cursor c = ourDatabase.query(database_table, cols, null, null, null,
				null, null);

		int iAns = c.getColumnIndex(key_ans);
		int iExplain = c.getColumnIndex(key_explain);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate) == getDate() && getTime() == "06") {
				return c.getString(iAns) + "\n" + c.getString(iExplain);
			}
		}
		String result = "Have Patience, answers will be uploaded at 6pm.";
		return result;
	}

	public String getAnsImg() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_ans_img, key_date };
		Cursor c = ourDatabase.query(database_table, cols, null, null, null,
				null, null);

		int iAnsImg = c.getColumnIndex(key_ans_img);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate) == getDate() && getTime() == "06") {
				return c.getString(iAnsImg);
			}
		}
		String result = "";
		return result;
	}
}
