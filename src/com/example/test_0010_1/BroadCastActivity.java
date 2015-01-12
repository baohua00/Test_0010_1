package com.example.test_0010_1;

import com.example.test_0010_1.receiver.Receiver;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class BroadCastActivity extends Activity {
	private Button button;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);
        button = (Button) findViewById(R.id.sendBroadCast);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setAction("com.TESTRECIEVE");
	            intent.putExtra("TEST", "TESTTEXT");  
	            BroadCastActivity.this.sendBroadcast(intent);
	            Log.i("Sender", "send!");
	            Toast.makeText(BroadCastActivity.this, "���͹㲥�ɹ�", Toast.LENGTH_SHORT).show();
			}
		});
        
//        //�㲥��̬ע��
//        //���ɹ㲥����   
//        Receiver receiver = new Receiver();   
//        //ʵ����������������Ҫ���˵Ĺ㲥   
//        IntentFilter intentFilter = new IntentFilter("com.TESTRECIEVE"); 
//        //ע��㲥   
//        BroadCastActivity.this.registerReceiver(receiver, intentFilter);
    }
    
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
