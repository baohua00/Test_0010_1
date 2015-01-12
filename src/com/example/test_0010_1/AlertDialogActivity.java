package com.example.test_0010_1;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AlertDialogActivity extends Activity {
 	private Button button;
 	private Button button_withList;
 	private Button button_withSingleChooice;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        button = (Button) findViewById(R.id.dialogButton);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				setTitle("doDialog!");
				AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);
				builder.setMessage("test!")
						.setCancelable(false)  
						.setPositiveButton("Yes", new DialogInterface.OnClickListener() {  
					           public void onClick(DialogInterface dialog, int id) {  
					        	   AlertDialogActivity.this.finish();  
					           }
					       })  
					       .setNegativeButton("No", new DialogInterface.OnClickListener() {  
					           public void onClick(DialogInterface dialog, int id) {  
					                dialog.cancel();  
					           }
					       });  
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
        
        button_withList = (Button) findViewById(R.id.dialogButton_withList);
        button_withList.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final CharSequence[] items = {"Red", "Green", "Blue"};   
				AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);  
				builder.setTitle("Pick a color");  
				builder.setItems(items, new DialogInterface.OnClickListener() {  
				    public void onClick(DialogInterface dialog, int item) {  
				        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();  
				    }  
				});  
				AlertDialog alert = builder.create();
				alert.show();
			}
		});
        
        button_withSingleChooice = (Button) findViewById(R.id.dialogButton_withSingleChoice);
        button_withSingleChooice.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final CharSequence[] items = {"Red", "Green", "Blue"};   
				AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);  
				builder.setTitle("Pick a color");  
				builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {  
				    public void onClick(DialogInterface dialog, int item) {  
				        Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();  
				    }  
				});  
				AlertDialog alert = builder.create();
				alert.show();
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
