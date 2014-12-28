package com.example.wid;

import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

public class widgetConfig extends Activity implements OnClickListener {
	AppWidgetManager awm;
	Context c;
	int awID;
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	//	RemoteViews views = new RemoteViews(c.getPackageName(), R.layout.widgetfile);
		
	}
	Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widgetfile);
		b = (Button) findViewById(R.id.buttonWidget);
		b.setOnClickListener(this);
		
		
	}
	

}
