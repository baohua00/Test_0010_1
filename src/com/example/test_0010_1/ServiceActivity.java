package com.example.test_0010_1;

import com.example.test_0010_1.Service.MusicService;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ServiceActivity extends Activity {
	protected static final String TAG = "ServiceDemoActivity";
	private Button onStartButton;
	private Button onBindButton;
	
	ServiceConnection conn = new ServiceConnection() {
		
		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.v(TAG, "onServiceConnected");
		}
		
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			Log.v(TAG, "onServiceDisconnected");
		}
	};
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        onStartButton = (Button) findViewById(R.id.onStart);
        onBindButton = (Button) findViewById(R.id.onBind);
        
        onStartButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent4Start = new Intent();
				intent4Start.setAction(MusicService.ACTION);
				intent4Start.setClass(ServiceActivity.this, MusicService.class);
				startService(intent4Start);
			}
		});
        
        onBindButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent4Bind = new Intent();
				intent4Bind.setAction(MusicService.ACTION);
				intent4Bind.setClass(ServiceActivity.this, MusicService.class);
				bindService(intent4Bind, conn, BIND_AUTO_CREATE);
			}
		});
    }
    
    @Override  
    protected void onDestroy() {  
        Log.v(TAG, "onDestroy unbindService");  
        unbindService(conn);  
        super.onDestroy();  
    };
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
