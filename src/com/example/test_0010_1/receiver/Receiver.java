package com.example.test_0010_1.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class Receiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		String str = intent.getExtras().getString("TEST");
		Log.i("Receivier", "receive:"+str);
	}

}
