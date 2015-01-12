package com.example.test_0010_1;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SharePreferenceActivity extends Activity {
	private EditText editText;
	private Button button;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharepreference);
        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.textButton);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String textString = editText.getText().toString();
				
				SharedPreferences sharedPreferences = getSharedPreferences("Test", SharePreferenceActivity.MODE_PRIVATE); //私有数据
				Editor editor = sharedPreferences.edit();//获取编辑器
				editor.putString("testText", textString);
				editor.commit();//提交修改
				
				String str = sharedPreferences.getString("testText", "");
				
				Toast.makeText(SharePreferenceActivity.this, "from sharePreference : "+str, Toast.LENGTH_SHORT).show();
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
