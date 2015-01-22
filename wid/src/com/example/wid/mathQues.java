package com.example.wid;


import java.util.Timer;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class mathQues extends Activity implements OnClickListener, OnItemClickListener {

	Button btnSol, btnBack;
	TextView soln, ques;
	private  DrawerLayout drawerLayout;
	private ListView listView;

	private String[] menu;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.math_ques);
		btnSol = (Button) findViewById(R.id.buttonSolution);
		btnBack = (Button) findViewById(R.id.btnBack);
		soln = (TextView) findViewById(R.id.solution);
		ques = (TextView) findViewById(R.id.question);
		btnSol.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		soln.setVisibility(View.INVISIBLE);
		
		Typeface tf = Typeface.createFromAsset(getAssets(),
		        "font/indiepimptbs.ttf");
		btnBack.setTypeface(tf);
		btnSol.setTypeface(tf);
		soln.setTypeface(tf);ques.setTypeface(tf);
		
		Toast.makeText(getApplicationContext(), "Testing 123",
				Toast.LENGTH_SHORT).show();
		
			
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.btnBack:
			finish();
			break;
		case R.id.buttonSolution:
			soln.setVisibility(View.VISIBLE);
			
			break;
			
		
		}
		
	}
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}

}
