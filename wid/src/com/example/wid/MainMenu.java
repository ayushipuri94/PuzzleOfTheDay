package com.example.wid;

import java.util.Timer;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;
import android.content.SharedPreferences;


public class MainMenu extends Activity implements OnClickListener {

	Button STP, Instr,Quit, Other;
	TextView name;
	private dbPuzzle dbp = null;

	private int core=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		Typeface tf = Typeface.createFromAsset(getAssets(),
		        "font/indiepimptbs.ttf");
		
		setContentView(R.layout.main_menu);
		STP = (Button) findViewById(R.id.Play);
		Other = (Button) findViewById(R.id.other);
		Instr = (Button) findViewById(R.id.Instructions);
	
		Quit= (Button) findViewById(R.id.Exit);
		name = (TextView) findViewById(R.id.textViewName);
		STP.setOnClickListener(this);
		Other.setOnClickListener(this);
		Instr.setOnClickListener(this);
		Quit.setOnClickListener(this);
	
		STP.setTypeface(tf);
		Other.setTypeface(tf);
		Instr.setTypeface(tf);
		Quit.setTypeface(tf);
		name.setTypeface(tf);
	}

	@Override
	public void onClick(View v) {
		SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0); 

		Editor editor = pref.edit();

		// TODO Auto-generated method stub
		switch (v.getId()) {
		
		
		case R.id.Play:
			Intent i2 = new Intent(this, MainActivity.class);
			
			startActivity(i2);

			overridePendingTransition(R.animator.pull_in_left, R.animator.push_out_right);
			
			break;
			
		case R.id.other:
			Intent i3 = new Intent(this, otherPuzzles.class);
			
			startActivity(i3);

			overridePendingTransition(R.animator.pull_in_left, R.animator.push_out_right);
			
			break;
		
		case R.id.Instructions:
			AlertDialog.Builder abc= new AlertDialog.Builder(v.getContext())
			.setTitle("Instructions")
			.setMessage("1. Puzzles will be updated every day.\n2. Difficulty of the puzzle is mentioned in form of Starts right beside name\n3. Hints will be available after 4pm.\n4. Solutions will be available after 8pm.\n5. If you answer correctly before 4pm, you will be awarded 100 points. If you answer correctly in between 4pm to 8pm you will be awarded 50 points. Any Answers after 8pm will get a Big Zero.\n6. Enjoy Solving ! :D")
			.setIcon(R.drawable.ic_launcher);	
			AlertDialog abd= abc.create();
			abd.show();
			Timer t2=new Timer();
			t2.schedule(new CloseDialogTimerTask(abd), 20000); 
			break;
			
		case R.id.Exit:
			finish();
			break;
		}

	}
}
