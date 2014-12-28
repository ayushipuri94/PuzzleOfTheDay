package com.example.wid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class otherPuzzles extends Activity implements OnClickListener{

	Button btnLogic, btnMath, btnJumble, btnBack, btnRiddle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.others);
		btnRiddle=(Button)findViewById(R.id.riddle);
		btnLogic=(Button)findViewById(R.id.logic);
		btnMath=(Button)findViewById(R.id.maths);
		btnJumble=(Button)findViewById(R.id.jumledWord);
		btnBack=(Button)findViewById(R.id.back);
		
		btnLogic.setOnClickListener(this);
		btnRiddle.setOnClickListener(this);
		btnMath.setOnClickListener(this);
		btnJumble.setOnClickListener(this);
		btnBack.setOnClickListener(this);
		

		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.back:
			finish();
			break;
		case R.id.maths:
			Intent i = new Intent(this, mathQues.class);
			startActivity(i);
			break;
		case R.id.riddle:
			Intent i2 = new Intent(this, riddleQues.class);
			startActivity(i2);
			break;
		
		}
	}

	
	

}
