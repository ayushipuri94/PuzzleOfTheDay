package com.example.wid;


import java.util.Timer;

import android.app.Activity;
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
	TextView soln;
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
		btnSol.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		soln.setVisibility(View.INVISIBLE);
		

		Toast.makeText(getApplicationContext(), "Testing 123",
				Toast.LENGTH_SHORT).show();
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		listView = (ListView) findViewById(R.id.drawerList);
		menu= getResources().getStringArray(R.array.planets);
		listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, menu));
		listView.setOnItemClickListener(this);
			
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
