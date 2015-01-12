package com.example.test_0010_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	private Button button;
	private Button button_SimpleAdapter;
	private Button button_Dialog;
	private Button button_SharePreference;
	private Button button_SQLite;
	private Button button_FileManager;
	private Button button_FileIO;
	private Button button_Service;
	private Button button_BroadCast;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.listView);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , ListViewActivity.class);
				startActivity(intent);
			}
		});
        
        button_SimpleAdapter = (Button) findViewById(R.id.listView_SimpleADP);
        button_SimpleAdapter.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , ListViewActivity_SimpleAdapter.class);
				startActivity(intent);
			}
		});
        
        button_Dialog = (Button) findViewById(R.id.dialog_Button);
        button_Dialog.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , AlertDialogActivity.class);
				startActivity(intent);
			}
		});
        
        button_SharePreference = (Button) findViewById(R.id.dialog_SharePreferenc);
        button_SharePreference.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , SharePreferenceActivity.class);
				startActivity(intent);
			}
		});
        
        button_SQLite = (Button) findViewById(R.id.dialog_SQLite);
        button_SQLite.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , SQLiteActivity.class);
				startActivity(intent);
			}
		});
        
        button_FileManager = (Button) findViewById(R.id.file_manager);
        button_FileManager.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , FileManageActivity.class);
				startActivity(intent);
			}
		});
		
        button_FileIO = (Button) findViewById(R.id.file_IO);
        button_FileIO.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , FileIOActivity.class);
				startActivity(intent);
			}
		});
		
        button_Service = (Button) findViewById(R.id.Service);
        button_Service.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , ServiceActivity.class);
				startActivity(intent);
			}
		});
		
        button_BroadCast = (Button) findViewById(R.id.BroadCast);
        button_BroadCast.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(MainActivity.this , BroadCastActivity.class);
				startActivity(intent);
			}
		});
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
