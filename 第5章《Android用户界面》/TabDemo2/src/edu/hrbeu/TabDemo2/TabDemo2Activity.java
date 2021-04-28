package edu.hrbeu.TabDemo2;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

@SuppressWarnings("deprecation")
public class TabDemo2Activity extends TabActivity  {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        TabHost tabHost = getTabHost(); 
        
        tabHost.addTab(tabHost.newTabSpec("TAB1").
        		setIndicator("线性布局").setContent(new Intent().setClass(this, Tab1Activity.class)));
        tabHost.addTab(tabHost.newTabSpec("TAB2").
        		setIndicator("绝对布局").setContent(new Intent().setClass(this, Tab2Activity.class)));
        tabHost.addTab(tabHost.newTabSpec("TAB3").
        		setIndicator("相对布局").setContent(new Intent().setClass(this, Tab3Activity.class)));


    }
}