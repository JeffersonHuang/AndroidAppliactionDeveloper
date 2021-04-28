package edu.hrbeu.ListViewDemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListViewDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextView textView = (TextView)findViewById(R.id.TextView01);
        ListView listView = (ListView)findViewById(R.id.ListView01);
        
        List<String> list  = new ArrayList<String>();
        list .add("ListView子项1");
        list .add("ListView子项2");
        list .add("ListView子项3");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_list_item_1, list );
        listView.setAdapter(adapter);
		
		AdapterView.OnItemClickListener listViewListener = new AdapterView.OnItemClickListener(){
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) { 
				String msg = "父View："+arg0.toString()+"\n"+
				"子View："+arg1.toString()+"\n"+
				"位置："+String.valueOf(arg2)+"，ID："+String.valueOf(arg3);
				textView.setText(msg);
			}};
			
		listView.setOnItemClickListener(listViewListener);
    }
}