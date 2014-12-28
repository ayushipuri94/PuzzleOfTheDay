package com.example.wid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SQLHint extends Activity implements OnClickListener {
	ImageView sqlimg;
	TextView sqlhint1, sqlhint2;
	Button sqlback;
	private dbPuzzle dbp = null;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hint_layout);

		sqlback = (Button) findViewById(R.id.buttonBack);
		sqlimg = (ImageView) findViewById(R.id.imageViewImg);
		sqlhint1 = (TextView) findViewById(R.id.textViewHint1);
		sqlhint2 = (TextView) findViewById(R.id.textViewHint2);

		sqlback.setOnClickListener(this);
		dbp = new dbPuzzle(this);
		dbp.openDb();
		String hint1 = dbp.getHint1();
		String hint2 = dbp.getHint2();
		//String img = dbp.getImg();

		dbp.close();
		sqlhint1.setText(hint1);
		sqlhint2.setText(hint2);
		// sqlimg.setText(img);
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
