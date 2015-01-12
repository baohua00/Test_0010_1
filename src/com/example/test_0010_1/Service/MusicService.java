package com.example.test_0010_1.Service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service{
    public static final String ACTION = "com.example.test_0010_1.Service.MusicService";
	private static final String TAG = "MediaPlayerService";
	
//	private MediaPlayer mediaPlayer;

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		Log.v(TAG, "TestService onBind");
		return null;
	}
	
	@Override  
    public void onCreate() {
		Log.v(TAG, "TestService onCreate");
	}
	
	@Override  
    public void onDestroy() {
		Log.v(TAG, "TestService onDestroy");
	}
	
	@Override  
	public void onStart(Intent intent, int startId) {
		Log.v(TAG, "TestService onStart");
	}

	@Override  
    public int onStartCommand(Intent intent, int flags, int startId) { 
        Log.v(TAG, "TestService onStartCommand");  
        return super.onStartCommand(intent, flags, startId);  
    }
}
