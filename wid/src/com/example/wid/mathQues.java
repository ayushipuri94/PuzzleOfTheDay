package com.example.wid;


import java.util.Timer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class mathQues extends Activity implements OnClickListener {

	Button btnSol, btnBack;
	TextView soln;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.math_ques);
		btnSol = (Button) findViewById(R.id.buttonSolution);
		btnBack = (Button) findViewById(R.id.btnBack);
		soln = (TextView) findViewById(R.id.solution);
		btnSol.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		soln.setVisibility(View.INVISIBLE);
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
