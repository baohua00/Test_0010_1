package com.example.test_0010_1.tools;

import java.util.ArrayList;
import java.util.List;

import com.example.test_0010_1.beans.Person;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DBManager {
	private DBHelper helper;
	private SQLiteDatabase database;
	
	public DBManager (Context context){
		//因为getWritableDatabase内部调用了mContext.openOrCreateDatabase(mName, 0, mFactory);  
        //所以要确保context已初始化,我们可以把实例化DBManager的步骤放在Activity的onCreate里
		helper = new DBHelper(context);
		database = helper.getWritableDatabase();
	}
	
	/** 
     * add persons 
     * @param persons 
     */
	public void add(List<Person> persons){
		//开始事务
		database.beginTransaction();
		try {
			for(Person person: persons){
				database.execSQL("INSERT INTO person VALUES(null, ?, ?, ?)", new Object[]{person.name, person.password, person.info});
			}
			//设置事务成功完成
			database.setTransactionSuccessful();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			//事务结束
			database.endTransaction();
		}
	}
	
	 /** 
     * query all persons, return list 
     * @return List<Person> 
     */  
    public List<Person> query() {
    	ArrayList<Person> persons = new ArrayList<Person>();
    	Cursor cursor = database.rawQuery("SELECT * FROM person", null);
    	while(cursor.moveToNext()){
    		Person person = new Person();
    		person._id = cursor.getInt(cursor.getColumnIndex("_id"));  
            person.name = cursor.getString(cursor.getColumnIndex("name"));  
            person.password = cursor.getString(cursor.getColumnIndex("password"));  
            person.info = cursor.getString(cursor.getColumnIndex("info"));  
            persons.add(person);
    	}
    	cursor.close();
		return persons;
    }
    
    /** 
     * query all persons, return cursor 
     * @return  Cursor 
     */  
    public Cursor queryTheCursor() {  
        Cursor c = database.rawQuery("SELECT * FROM person", null);  
        return c;  
    }
	
}
