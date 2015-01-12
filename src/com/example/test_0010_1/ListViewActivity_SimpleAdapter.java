package com.example.test_0010_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ListViewActivity_SimpleAdapter extends Activity {
	private ListView listView;
 	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_simpleadapter);
        
        listView = (ListView) findViewById(R.id.listV);
//        listView.setAdapter(new ArrayAdapter<String>(this, R.layout.listciewlayout, returnSTR()));
        listView.setAdapter(new SimpleAdapter(this, 
        										returnList(), 
								        		R.layout.listciewlayout, 
								        		new String[]{"a","b"}, 
								        		new int[]{R.id.textview1, R.id.textview2}));
        
        listView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
					JSONTokener jsonTokener = new JSONTokener(parent.getItemAtPosition(position).toString());
					JSONObject person;
					try {
						person = (JSONObject) jsonTokener.nextValue();
//						person.getJSONArray("phone");  
						setTitle(person.getString("a"));  
//					    person.getInt("age");  
//					    person.getJSONObject("address");  
//					    person.getBoolean("married");
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}  
			}
		});
//        setContentView(listView);
    }
    
    private ArrayList<HashMap<String, String>> returnList(){
    	ArrayList<HashMap<String, String> > list = new ArrayList<HashMap<String, String>>();
    	HashMap<String, String> map1 = new HashMap<String, String>();
    	map1.put("a", "a1");
    	map1.put("b", "a2");
    	list.add(map1);
    	HashMap<String, String> map2 = new HashMap<String, String>();
    	map2.put("a", "b1");
    	map2.put("b", "b2");
    	list.add(map2);
    	HashMap<String, String> map3 = new HashMap<String, String>();
    	map3.put("a", "c1");
    	map3.put("b", "c2");
    	list.add(map3);
    	HashMap<String, String> map4 = new HashMap<String, String>();
    	map4.put("a", "d1");
    	map4.put("b", "d2");
    	list.add(map4);
    	HashMap<String, String> map5 = new HashMap<String, String>();
    	map5.put("a", "e1");
    	map5.put("b", "e2");
    	list.add(map5);
    	HashMap<String, String> map6 = new HashMap<String, String>();
    	map6.put("a", "f1");
    	map6.put("b", "f2");
    	list.add(map6);
    	return list;
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
