package com.example.test_0010_1.tools;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import android.content.Context;
import android.os.Environment;

/**
 * @author baohua00
 *
 */
public class IOManager {
	private Context context;
	
	public IOManager (Context context) {
		this.setContext(context);
	}
	
	/**
	 * @author baohua00
	 * 存入SDCard
	 */
	public void saveToSDCard(String filename, String data) throws Exception{  
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){  
			File file = new File(Environment.getExternalStorageDirectory(), filename);  
			FileOutputStream outStream = new FileOutputStream(file);  
			outStream.write(data.getBytes());  
			outStream.close();  
		}  
	}
	
	/**
	 * @author baohua00
	 * 存入当前应用的目录
	 */
	public void save(String filename, String data) throws Exception{  
		FileOutputStream outStream = context.openFileOutput(filename, Context.MODE_PRIVATE);  
		outStream.write(data.getBytes());  
		outStream.close();  
	}
	
	/**
	 * @author baohua00
	 * saveAppend
	 */
	public void saveAppend(String filename, String data) throws Exception{
		FileOutputStream outStream = context.openFileOutput(filename, Context.MODE_APPEND);  
		outStream.write(data.getBytes());  
		outStream.close();  
	}
	
	/**
	 * @author baohua00
	 * saveReadable
	 */
	public void saveReadable(String filename, String content) throws Exception{ 
		FileOutputStream outStream = context.openFileOutput(filename, Context.MODE_WORLD_READABLE);  
		outStream.write(content.getBytes());  
		outStream.close();  
	}

	/**
	 * @author baohua00
	 * saveWriteable
	 */
	public void saveWriteable(String filename, String content) throws Exception{ 
		FileOutputStream outStream = context.openFileOutput(filename, Context.MODE_WORLD_WRITEABLE);  
		outStream.write(content.getBytes());  
		outStream.close();  
	}
	
	/**
	 * @author baohua00
	 * saveWriteable&&saveReadable
	 */
	public void saveRW(String filename, String content) throws Exception{  
		FileOutputStream outStream = context.openFileOutput(filename,   
		Context.MODE_WORLD_READABLE+ Context.MODE_WORLD_WRITEABLE);  
		outStream.write(content.getBytes());  
		outStream.close();  
	}
	
	/**
	 * @author baohua00
	 * saveWriteable&&saveReadable&&private
	 */
	public void savePRW(String filename, String content) throws Exception{  
		FileOutputStream outStream = context.openFileOutput(filename,   
		Context.MODE_WORLD_READABLE+ Context.MODE_WORLD_WRITEABLE+Context.MODE_APPEND);  
		outStream.write(content.getBytes());  
		outStream.close();  
	}
	
	/**
	 * @author baohua00
	 * readData By FileInputStream 
	 * from 当前APP目录
	 */
	public String readFile(String filename) throws Exception{  
		FileInputStream inStream = context.openFileInput(filename);  
		byte[] data = readData(inStream);  
		return new String(data);  
	}
	
	/**
	 * @author baohua00
	 * readData By ByteArrayOutputStream
	 */
	private byte[] readData(FileInputStream inStream) throws Exception{  
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();  
		byte[] buffer = new byte[1024];  
		int len = 0;  
		while( (len = inStream.read(buffer))!= -1){  
			outStream.write(buffer, 0, len);  
		}  
		outStream.close();  
		inStream.close();  
		return outStream.toByteArray();  
	}
	
	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	} 
}
