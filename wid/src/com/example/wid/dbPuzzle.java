package com.example.wid;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.util.Log;
import android.widget.Toast;

public class dbPuzzle extends SQLiteOpenHelper {

	private final Context myContext;
	private static final String database_name = "Puzzle.db";
	public static final String database_table = "Puzzle";
	public static final int database_version = 1;
	public SQLiteDatabase sqldb;

	public static final String key_id = "id";
	public static final String key_name = "name";
	public static final String key_date = "date";
	public static final String key_difficulty = "difficulty";
	public static final String key_ques = "ques";
	public static final String key_ans = "ans";
	public static final String key_explain = "explain";
	//public static final String key_ans_img = "ans_img";
	//public static final String key_img = "img";
	public static final String key_hint1 = "hint1";
	//public static final String key_hint2 = "hint2";

	public dbPuzzle(Context context) {
		super(context, database_name, null, database_version);
		myContext = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists " + database_table);

		//Toast.makeText(myContext, "Creating", Toast.LENGTH_SHORT).show();
		db.execSQL("create table if not exists " + database_table + " ("
				+ key_id + " integer primary key autoincrement, " 
				+ key_name + " varchar(50) not null, " 
				+ key_date + " varchar(20), "
				+ key_difficulty + " varchar(20) default '**', " 
				+ key_ques+ " varchar(2000) not null, " 
				+ key_ans + " varchar(200) not null, " 
				+ key_explain + " varchar(500), "
				+ key_hint1 + " varchar(200) );");
		insert(db);
		//Toast.makeText(myContext, "Created", Toast.LENGTH_SHORT).show();
	}
	public void insert(SQLiteDatabase db){
	db.execSQL("insert into Puzzle values(1, 'HAND PROBLEM', '09/01/2015',  '*', 'What can you hold with your right hand but not your left hand?', 'left hand', null, 'it is one of your hands');");	
	db.execSQL("insert into Puzzle values(2, 'THE BRAVE BABY', '05/01/2015', '**', 'How could a baby fall out of a twenty-story building onto the ground and live?', 'ground', 'who said anything about falling from the 20th floor? The baby simply fell from the ground floor!', 'It does not matter what the baby lands on, and it has nothing to do with luck.' );");
	db.execSQL("insert into Puzzle values(3, 'TOM & JOE', '06/01/2015', '** ', 'Tom and Joe want to sit behind each other in class and the teacher arranges them so they are both happy. What does their teacher do?', 'back to back', 'Make Tom and Joe sit back to back.', 'They both get what they wanted.' );");
	db.execSQL("insert into Puzzle values(4, 'SURGEON', '07/01/2015',  '*****', 'Fill the 3 blank spaces with the same set of letters to give the sentence meaning. THE _ _ _ _ _ _ _ SURGEON WAS _ _ _ _ _ _ _ TO OPERATE BECAUSE OF _ _ _ _ _ _ _  ', 'notable', 'The NOTABLE surgeon was NOT ABLE to operate because of NO TABLE.', 'NOWHERE can be comprehended as NOW HERE or NO WHERE.');");	
	db.execSQL("insert into Puzzle values(5, 'PING PONG', '08/01/2015',  '*', 'Your last good ping-pong ball fell down into a narrow metal pipe embedded in concrete one foot deep. How can you get it out undamaged, if all the tools you have are your tennis paddle, your shoe-laces, and your plastic water bottle, which does not fit into the pipe? ', 'blow', 'Blow into the pipe, the air thrust will push it up.', 'You do not need those items.');");	
	db.execSQL("insert into Puzzle values(6, 'Supersonic Bee', '04/01/2015',  '***', 'Two trains enter a tunnel 200 miles long traveling at 100mph at the same time from opposite directions. When they enter the tunnel a supersonic bee flying at 1000mph starts from on train and heads towards the other, and heads back towards the first, going back and forth between the trains until the trains collide in a fiery explosion in the middle of the tunnel. How much did the bee travel?', '1000miles', 'It takes one hour for the trains to reach the middle point of the tunnel to collide, and the bee flies at 1000mph.', 'This does not require any calculations.');");

	}
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if exists " + database_table);
		onCreate(db);
	}

	/*
	 * private void createDb() { boolean dbExist = DBExists(); if (!dbExist) {
	 * this.getReadableDatabase(); copyDBFromResource(); } else { openDb(); } }
	 */
	public void openDb() {
		// Open the database
		Toast.makeText(myContext, "Opening", Toast.LENGTH_SHORT).show();
		sqldb = myContext.openOrCreateDatabase(database_name,
				Context.MODE_PRIVATE, null);
		Toast.makeText(myContext, "Opened", Toast.LENGTH_SHORT).show();
		onCreate(sqldb);
	}
	public void close() {
		if (sqldb != null)
			sqldb.close();
		super.close();
	}


	public String getDate() {

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
		
		return reportDate+"";
	}

	public String getQues() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_ques, key_date };
		Cursor c = sqldb.query(database_table, cols, null, null, null,
				null, null);

		int iQues = c.getColumnIndex(key_ques);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate).matches(getDate())) {
				return c.getString(iQues);
			}
		}
		String result = "Have Patience";
		return result;
	}

	public String getDifficulty() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_difficulty, key_date };
		Cursor c = sqldb.query(database_table, cols, null, null, null,
				null, null);

		int iDiff = c.getColumnIndex(key_difficulty);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate).matches(getDate())) {
				return c.getString(iDiff) ;
			}
		}
		String result = "Have Patience";
		return result;
}

	public String getName() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_name, key_date };
		Cursor c = sqldb.query(database_table, cols, null, null, null,
				null, null);

		int iName = c.getColumnIndex(key_name);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
//			Toast.makeText(myContext, "table se "+ c.getString(iDate), Toast.LENGTH_SHORT).show();
			
			if (c.getString(iDate).matches(getDate())) {
			return c.getString(iName);
			}
		}
		String result = "Have Patience";
		return result;
}

	public String getHint1() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_hint1, key_date };
		Cursor c = sqldb.query(database_table, cols, null, null, null,
				null, null);

		int iHint1 = c.getColumnIndex(key_hint1);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate).matches(getDate())&& Integer.parseInt(getTime())>=15) {
				return c.getString(iHint1);
			}
		}
		String result = "Will be available at 3:00 pm";
		return result;
	}

	/*public String getHint2() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_hint2, key_date };
		Cursor c = sqldb.query(database_table, cols, null, null, null,
				null, null);

	//	int iHint2 = c.getColumnIndex(key_hint2);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate).matches(getDate())&& Integer.parseInt(getTime())>=18) {
				return c.getString(iHint2);
			}
		}
		String result = "No hints available";
		return result;
	}*/
	public String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("HH");
		Date today = Calendar.getInstance().getTime();
		String reportDate = df.format(today);
	
		return reportDate;
	}

	public String getAns() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_ans, key_explain, key_date };
		Cursor c = sqldb.query(database_table, cols, null, null, null,
				null, null);

		int iAns = c.getColumnIndex(key_ans);
		int iExplain = c.getColumnIndex(key_explain);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate).matches(getDate()) && Integer.parseInt(getTime())>=20) {
				return c.getString(iExplain);
			}
		}
		String result = "Have Patience, answers will be uploaded at 8pm.";
		return result;
	}
	@SuppressWarnings("unused")
	public String getCheckAns() {
		// TODO Auto-generated method stub
		String[] cols = new String[] { key_ans, key_explain, key_date };
		Cursor c = sqldb.query(database_table, cols, null, null, null,
				null, null);

		int iAns = c.getColumnIndex(key_ans);
		int iExplain = c.getColumnIndex(key_explain);
		int iDate = c.getColumnIndex(key_date);
		for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
			if (c.getString(iDate).matches(getDate())) {
				return c.getString(iAns);
			}
		}
		String result = "Have Patience, answers will be uploaded at 8pm.";
		return result;
	}
	public boolean checkAns(String s) {
		// TODO Auto-generated method stub
		int j=0;
		char [] ansArray= s.toCharArray();
		char keys[][]= new char[40][40];int t=0;
		for(int i=0; i<ansArray.length; i++){
			if(ansArray[i]!=32)
				keys[j][t++]=ansArray[i];
			else{
				j++;t=0;}
		}
		int len = 0;
		String answer=getCheckAns();
		int leng=0;
		char [] sqlAns = answer.toCharArray();
		
		for(int k=0; k<=j; k++){
			for(leng=0; keys[k][leng]!='\0'; leng++){}
			
			for(int i=0; sqlAns[i]!='\0'; i++){
				
				for(int l=0; keys[k][l]!='\0'; l++){
					
					if(keys[k][l]==(sqlAns[i+l]))
						len++;
					else break;
				}
				if(len==sqlAns.length){
					
					return true;
				}
				else return false;
			}
			
		}
		
		return false;
	}
}