package edu.hrbeu.SimplePreferenceDemo;

import edu.hrbue.SimplePreferenceDemo.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SimplePreferenceDemoActivity extends Activity {
	
	private EditText nameText;
	private EditText ageText;
	private EditText heightText;
    
	public static final String PREFERENCE_NAME = "SaveSetting";
	public static int MODE = Context.MODE_WORLD_READABLE + Context.MODE_WORLD_WRITEABLE;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        nameText = (EditText)findViewById(R.id.name);
        ageText = (EditText)findViewById(R.id.age);
        heightText = (EditText)findViewById(R.id.height);
    }
    
    @Override
    public void onStart(){
    	super.onStart();
    	loadSharedPreferences();
    }
    
    @Override
    public void onStop(){
    	super.onStop();	
    	saveSharedPreferences();
    }
    
    private void loadSharedPreferences(){
  	    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE);
  	    String name = sharedPreferences.getString("Name","Tom");
  	    int age = sharedPreferences.getInt("Age", 20);
  	    float height = sharedPreferences.getFloat("Height",1.81f);
	
  	    nameText.setText(name);
  	    ageText.setText(String.valueOf(age));
  	    heightText.setText(String.valueOf(height));    	
    }
    
    private void saveSharedPreferences(){
  	    SharedPreferences sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE);
  	    SharedPreferences.Editor editor = sharedPreferences.edit();
  	    
  	    editor.putString("Name", nameText.getText().toString());
  	    editor.putInt("Age", Integer.parseInt(ageText.getText().toString()));
  	    editor.putFloat("Height", Float.parseFloat(heightText.getText().toString()));
  	    editor.commit();
    }

    
}