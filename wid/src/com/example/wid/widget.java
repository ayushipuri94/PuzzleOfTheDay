package com.example.wid;

import java.util.Random;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Button;
import android.widget.RemoteViews;
import android.widget.Toast;

public class widget extends AppWidgetProvider{
	private dbPuzzle dbp = null;

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds ){
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		dbp = new dbPuzzle(context);
		dbp.openDb();
		String ques = dbp.getQues();
		dbp.close();
		
		final int N = appWidgetIds.length;
		for(int i=0; i<N; i++){
			int awID = appWidgetIds[i];
			
			RemoteViews v = new RemoteViews(context.getPackageName(), R.layout.widgetfile);
			v.setTextViewText(R.id.buttonWidget, ques);
			//v.setTextViewText(R.id.textView1, ques);
			appWidgetManager.updateAppWidget(awID, v);
		}
	}
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onDeleted(context, appWidgetIds);
		Toast.makeText(context, "Seee ya sucka!", Toast.LENGTH_SHORT).show();
	}

	

}
