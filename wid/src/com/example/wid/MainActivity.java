package com.example.wid;

import java.util.Timer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.SharedPreferences;


public class MainActivity extends Activity implements OnClickListener, OnItemClickListener {

	Button sqlsubmit, sqlhint, sqlsolution;
	EditText sqlAttempt;
	TextView sqlid, sqlname, sqldifficulty, sqlques, sqlans, sqlansimg, sqlimg,
			sqlhint1, sqlhint2,TxtScore = null;
	private dbPuzzle dbp = null;

//	private  DrawerLayout drawerLayout;
//	private ListView listView;
	private String[] menu;
	private int core=0,p=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	//	Toast.makeText(getApplicationContext(), "Testing 123",
	//			Toast.LENGTH_SHORT).show();
	//	drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
	//	listView = (ListView) findViewById(R.id.drawerList);
	//	menu= getResources().getStringArray(R.array.planets);
	//	listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
	//	listView.setOnItemClickListener(this);
		
		sqlsubmit = (Button) findViewById(R.id.buttonSubmit);
		sqlhint = (Button) findViewById(R.id.buttonHint);
		sqlsolution = (Button) findViewById(R.id.buttonSolution);
		sqlname = (TextView) findViewById(R.id.textViewName);
		sqldifficulty = (TextView) findViewById(R.id.textViewStars);
		sqlques = (TextView) findViewById(R.id.textViewQues);
		sqlAttempt =(EditText)findViewById(R.id.editTextAns);
		
		sqlsubmit.setOnClickListener(this);
		sqlhint.setOnClickListener(this);
		sqlques.setOnClickListener(this);
		sqlsolution.setOnClickListener(this);

		dbp = new dbPuzzle(this);
		dbp.openDb();
		String ques = dbp.getQues();
		String difficulty = dbp.getDifficulty();
		String name = dbp.getName();

		//dbp.close();
		sqlname.setText(name);
		sqldifficulty.setText(difficulty);
		sqlques.setText(ques);
		SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); 
		core= pref.getInt("MyPref",0);

	}

	@Override
	public void onClick(View v) {
		SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); 

		Editor editor = pref.edit();
		
		//SharedPreferences pref1 = getApplicationContext().getSharedPreferences("MyPref2", 0); 

		//Editor editor1 = pref1.edit();
		//editor1.putInt("MyPref2", 0);

		//String dat= dbp.getDate();
		
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttonHint:
			AlertDialog.Builder a= new AlertDialog.Builder(v.getContext())
			.setTitle("Hint")
			.setMessage(dbp.getHint1())
			.setIcon(R.drawable.ic_launcher);	
			AlertDialog ab= a.create();
			ab.show();
			Timer t1=new Timer();
			t1.schedule(new CloseDialogTimerTask(ab), 5000); 
			break;
		case R.id.buttonSolution:
			Intent i2 = new Intent(this, SQLAns.class);
			startActivity(i2);
			break;
		case R.id.buttonSubmit:
			boolean che = dbp.checkAns(sqlAttempt.getText().toString()) ;
			if(che)
			{
				//editor1.putInt("MyPref2",1);
				//p=pref1.getInt("MyPref2",0);
				AlertDialog.Builder adb= new AlertDialog.Builder(v.getContext())
				.setTitle("Congratulations !!!")
				.setMessage("You are correct. The next puzzle will be up tomorrow")
				.setIcon(R.drawable.ic_launcher);	
				AlertDialog ad= adb.create();
				ad.show();
				//if (Integer.parseInt(dbp.getTime())<=15 && p==1)
				if (Integer.parseInt(dbp.getTime())<=15)
				{
					core= pref.getInt("MyPref",0);
					core=core+100;
					editor.putInt("MyPref",core);
					editor.commit();
				}
				//else if(Integer.parseInt(dbp.getTime())>=15 && Integer.parseInt(dbp.getTime())<=20 && p==1)
				else if(Integer.parseInt(dbp.getTime())>=15 && Integer.parseInt(dbp.getTime())<=20)
				{
					core= pref.getInt("MyPref",0);
					core=core+50;
					editor.putInt("MyPref",core);
					editor.commit();
				}
				Timer t=new Timer();
				t.schedule(new CloseDialogTimerTask(ad), 5000);  
				
			}
			else
			{
				AlertDialog.Builder asd= new AlertDialog.Builder(v.getContext())
				.setMessage("The answer you entered is incorrect. Try again")
				.setTitle("Sorry :(")
				.setIcon(R.drawable.ic_launcher);
				AlertDialog ad= asd.create();
				ad.show();
				Timer t=new Timer();
				t.schedule(new CloseDialogTimerTask(ad), 5000); 
				 
			}	
			break;
		}

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
			
			
		
	}
}
