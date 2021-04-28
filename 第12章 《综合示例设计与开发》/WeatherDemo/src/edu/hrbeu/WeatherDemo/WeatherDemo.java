package edu.hrbeu.WeatherDemo;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;

public class WeatherDemo extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TabHost tabHost = getTabHost();   
        tabHost.addTab(tabHost.newTabSpec("TAB1").
        		setIndicator("天气预报",getResources().getDrawable(R.drawable.tab_weather)).
        		setContent(new Intent(this, WeatherActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("TAB2").
        		setIndicator("历史数据",getResources().getDrawable(R.drawable.tab_history)).
        		setContent(new Intent(this, HistoryActivity.class)));
        tabHost.addTab(tabHost.newTabSpec("TAB3").
        		setIndicator("系统设置",getResources().getDrawable(R.drawable.tab_setup)).
        		setContent(new Intent(this, SetupActivity.class)));
    }
}