package edu.hrbeu.LinearLayout;

import android.app.Activity;
import android.os.Bundle;

public class LinearLayoutActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        //垂直排列的线性布局
        //setContentView(R.layout.main_vertical);
        
        //水平排列的线性布局
        setContentView(R.layout.main_horizontal);
    }
}