package com.example.test_0010_1;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.test_0010_1.tools.FileManagerAdapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class FileManageActivity extends Activity {
	private TextView mCurrentPath;
    private TextView mReturn;
    private ListView mList;
    private View mPathLine;
    private String mReturnPath = null;
    private FileManagerAdapter adapter;
    private ArrayList<Map<String, Object>> infos = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
//      this.getWindow().setBackgroundDrawableResource(R.drawable.psb);
        initView();
    }
    
    private void initView() {
        mCurrentPath = (TextView) findViewById(R.id.file_path);
        mPathLine = findViewById(R.id.file_path_line);
        mReturn = (TextView) findViewById(R.id.file_return);
        mList = (ListView) findViewById(R.id.file_list);
 
        mList.setOnItemClickListener(clickListener);
        mReturn.setOnClickListener(new OnClickListener() {
 
            @Override
            public void onClick(View v) {
                String returnStr = mReturn.getText().toString();
                if (mReturnPath.length() > 0 && returnStr.equals("������һ��")) {
                    initList(mReturnPath); 
                }
            }
        });
         
        initList("/");   //��ʼ���Ӹ�Ŀ¼��ʼ
    }
    
    private void initList(String path) {
    	//�ļ�����
        File file = new File(path);
        File[] fileList = file.listFiles();
        
        infos = new ArrayList<Map<String, Object>>();
        Map<String, Object> item = new HashMap<String, Object>();
        Drawable drawable;
        if (path.equals("/")) {   //�����ǰΪ��Ŀ¼,������һ����ť������ʾ
            drawable = getResources().getDrawable(R.drawable.versionup);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                    drawable.getMinimumHeight());
            mCurrentPath.setCompoundDrawablePadding(10);
            mCurrentPath.setCompoundDrawables(drawable, null, null, null);
            mCurrentPath.setText("��Ŀ¼�б�");
            mReturn.setVisibility(View.GONE);
            mPathLine.setVisibility(View.GONE);
        } else {
            drawable = getResources().getDrawable(R.drawable.versionup);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(),
                    drawable.getMinimumHeight());
            mReturn.setCompoundDrawables(drawable, null, null, null);
            mReturn.setText("������һ��");
            mReturnPath = file.getParent();  //����ü�Ŀ¼����һ��·��
            mCurrentPath.setVisibility(View.VISIBLE);
            mPathLine.setVisibility(View.VISIBLE);
            mCurrentPath.setText(file.getPath());
        }
 
        try {
            for (int i = 0; i < fileList.length; i++) {
                item = new HashMap<String, Object>();
                File fileItem = fileList[i];
                if (fileItem.isDirectory()) {  //�����ǰ�ļ�Ϊ�ļ��У������ļ��е�ͼ��
                    item.put("icon", R.drawable.icon_one);
                } else
                    item.put("icon", R.drawable.icon_two);
                item.put("name", fileItem.getName());
                item.put("path", fileItem.getAbsolutePath());
                infos.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        adapter = new FileManagerAdapter(this);
        adapter.setFileListInfo(infos);
        mList.setAdapter(adapter);
    }
 
    private OnItemClickListener clickListener = new OnItemClickListener() {
 
        @Override
        public void onItemClick(AdapterView<?> arg0, View arg1, int position,
                long arg3) {
            File file = new File((String) (infos.get(position).get("path")));
            if (file.isDirectory()) {  //������ļ��У��������һ��Ŀ¼
                String nextPath = (String) (infos.get(position).get("path"));
                initList(nextPath);
            } else {            //������ļ������ļ��������������ļ��������������
                Intent intent = new Intent();
                intent.setClass(FileManageActivity.this,
                		MainActivity.class);
                intent.putExtra("fileName",
                        (String) (infos.get(position).get("name")));
                intent.putExtra("path", (String) (infos.get(position).get("path")));
                setResult(RESULT_OK, intent);
                finish();
            }
 
        }
    };
    
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
