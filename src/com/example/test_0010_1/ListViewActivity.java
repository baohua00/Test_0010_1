package com.example.test_0010_1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListViewActivity extends Activity {
	private ListView listView;
 	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        
        listView = (ListView) findViewById(R.id.listV);
//        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.listciewlayout, returnSTR()));
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, returnSTR()));
//        setContentView(listView);
    }
    
    private List<String> returnSTR(){
    	List<String > str = new ArrayList<String>();
    	str.add("test0");
    	str.add("test1");
    	str.add("test2");
    	str.add("test3");
    	str.add("test4");
    	return str;
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
