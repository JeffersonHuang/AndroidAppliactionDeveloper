package edu.hrbeu.SpinnerDemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class SpinnerDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Spinner spinner = (Spinner) findViewById(R.id.Spinner01);   
        List<String> list  = new ArrayList<String>();
        list .add("Spinner子项1");
        list .add("Spinner子项2");
        list .add("Spinner子项3");
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, 
        		android.R.layout.simple_spinner_item, list );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         //adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);

      }

}