package com.example.test_0010_1;

import com.example.test_0010_1.tools.IOManager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FileIOActivity extends Activity {
	private EditText editText;
	private Button button;
	private TextView textView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fileio);
        
        editText = (EditText) findViewById(R.id.fileIO_EditText);
        button = (Button) findViewById(R.id.fileIO_Button);
        textView = (TextView) findViewById(R.id.fileIO_TextView);
        
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
					String editTextStr = editText.getText().toString();
				try{
					IOManager io = new IOManager(FileIOActivity.this);
					io.save("test", editTextStr);
					String strFromRead = io.readFile("test");
					textView.setText(strFromRead);
				} catch (Exception e){
					e.printStackTrace();
				}
					
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
