package com.example.test_0010_1.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * @author baohua00
 * ���ݿ��һ�δ���ʱonCreate�����ᱻ���ã����ǿ���ִ�д��������䣬��ϵͳ���ְ汾�仯֮�󣬻����onUpgrade���������ǿ���ִ���޸ı�ṹ����䡣
 */
public class DBHelper extends SQLiteOpenHelper {
	
	private static final String DATABASE_NAME = "test";
	private static final int DATABASE_VERSION = 1;

	public DBHelper(Context context) {
		//CursorFactory����Ϊnull,ʹ��Ĭ��ֵ
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	//���ݿ��һ�α�����ʱonCreate�ᱻ����
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS person" +  
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR, password VARCHAR, info TEXT)");
		
	}

	//���DATABASE_VERSIONֵ����Ϊ2,ϵͳ�����������ݿ�汾��ͬ,�������onUpgrade
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("ALTER TABLE person ADD COLUMN other STRING");
	}

}
