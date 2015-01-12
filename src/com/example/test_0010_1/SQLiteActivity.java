package com.example.test_0010_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.test_0010_1.beans.Person;
import com.example.test_0010_1.tools.DBManager;

import android.app.Activity;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class SQLiteActivity extends Activity {
	private EditText nameEditText;
	private EditText passwordEditText;
	private Button button;
	
	private DBManager manager;  
    private ListView listView; 
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);
        
        manager = new DBManager(this);
        
        listView = (ListView) findViewById(R.id.listView_Person);
        
        nameEditText = (EditText) findViewById(R.id.name);
        passwordEditText = (EditText) findViewById(R.id.password);
        
        button = (Button) findViewById(R.id.saveButton);
        button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ArrayList<Person> persons = new ArrayList<Person>();
				String name  = nameEditText.getText().toString();
				String password  = passwordEditText.getText().toString();
				persons.add(new Person(name, password));
				
				//
				manager.add(persons);
				Toast.makeText(getApplicationContext(), ""+name+":*** is saved", Toast.LENGTH_SHORT).show();
				query();
//				queryTheCursor();
			}
		});
    }
    
    public void query() {  
        List<Person> persons = manager.query();  
        ArrayList<Map<String, String>> list = new ArrayList<Map<String, String>>();  
        for (Person person : persons) {  
            HashMap<String, String> map = new HashMap<String, String>();  
            map.put("name", person.name);  
            map.put("info", person.password + ": " + person.info);  
            list.add(map);  
        }  
        SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,  
                    new String[]{"name", "info"}, new int[]{android.R.id.text1, android.R.id.text2});  
        listView.setAdapter(adapter);
    }
      
//    @SuppressWarnings("deprecation")
//	public void queryTheCursor() {  
//        Cursor c = manager.queryTheCursor();  
//        CursorWrapper cursorWrapper = new CursorWrapper(c) {  
//            @Override  
//            public String getString(int columnIndex) {  
//                if (getColumnName(columnIndex).equals("info")) {  
//                    int password = getInt(getColumnIndex("password"));  
//                    return password + " : " + super.getString(columnIndex);  
//                }  
//                return super.getString(columnIndex);  
//            }  
//        };  
//        //确保查询结果中有"_id"列  
//        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,   
//                cursorWrapper, new String[]{"name", "info"}, new int[]{android.R.id.text1, android.R.id.text2});  
//        listView.setAdapter(adapter);
//        c.close();
//    }
    
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
