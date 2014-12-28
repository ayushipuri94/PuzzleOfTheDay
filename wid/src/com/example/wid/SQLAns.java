package com.example.wid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLAns extends Activity implements OnClickListener {
	TextView sqlanswer, sqlansimg;
	Button sqlback;
	private dbPuzzle dbp = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ans_layout);

		sqlback = (Button) findViewById(R.id.buttonBack);
		sqlanswer = (TextView) findViewById(R.id.textViewAns);

		sqlback.setOnClickListener(this);
		dbp = new dbPuzzle(this);
		dbp.openDb();
		String result = dbp.getAns();
//		String ansimg = dbp.getAnsImg();

		dbp.close();
		sqlanswer.setText(result);
//		sqlansimg.setText(ansimg);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.buttonBack:
			finish();
			break;
		}
	}

}
