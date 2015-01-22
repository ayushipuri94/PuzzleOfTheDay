package com.example.wid;


import java.util.Timer;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class jumbleQues extends Activity implements OnClickListener {

	Button btnSol, btnBack;
	TextView soln,ques;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jumble_ques);
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

}
