package com.example.wid;

import android.app.AlertDialog;
import java.util.TimerTask;

public class CloseDialogTimerTask extends TimerTask{

	private AlertDialog ad;
	public CloseDialogTimerTask(AlertDialog ad)
	{
		this.ad=ad;
	}
	
	public void run()
	{
		if(ad.isShowing())
		{
			ad.dismiss();
		}
	}
}
