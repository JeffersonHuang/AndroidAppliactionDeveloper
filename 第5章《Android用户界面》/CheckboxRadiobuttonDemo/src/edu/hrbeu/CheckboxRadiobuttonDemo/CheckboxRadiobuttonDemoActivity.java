package edu.hrbeu.CheckboxRadiobuttonDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;

public class CheckboxRadiobuttonDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final TextView textView = (TextView)findViewById(R.id.TextView01);
        
        //(1)CheckBox
        final CheckBox checkBox1= (CheckBox)findViewById(R.id.CheckBox01);
        final CheckBox checkBox2= (CheckBox)findViewById(R.id.CheckBox02);  
        CheckBox.OnClickListener checkboxListener = new CheckBox.OnClickListener(){
			@Override
			public void onClick(View v) {
				switch(v.getId()){
				case R.id.CheckBox01:
					textView.setText("CheckBox01, isChecked:"+String.valueOf(checkBox1.isChecked()));
					return;
				case R.id.CheckBox02:
					textView.setText("CheckBox02, isChecked:"+String.valueOf(checkBox2.isChecked()));
					return;
			}			
			}};  	
		checkBox1.setOnClickListener(checkboxListener);
		checkBox2.setOnClickListener(checkboxListener);
		
		//(2)RadioButton
        final RadioButton radioButton1 = (RadioButton)findViewById(R.id.RadioButton01);
        final RadioButton radioButton2 = (RadioButton)findViewById(R.id.RadioButton02);
        RadioButton.OnClickListener radioButtonListener = new RadioButton.OnClickListener(){
			@Override
			public void onClick(View v) {
				switch(v.getId()){
				case R.id.RadioButton01:
					textView.setText("RadioButton1 is selected");
					return;
				case R.id.RadioButton02:
					textView.setText("RadioButton2 is selected");;
					return;
			}			
			}};  	
		radioButton1.setOnClickListener(radioButtonListener);
		radioButton2.setOnClickListener(radioButtonListener);
    }
}