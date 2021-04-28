package edu.hrbeu.BroadcastReceiverDemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		String msg = intent.getStringExtra("message");

		Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();

	}
}
