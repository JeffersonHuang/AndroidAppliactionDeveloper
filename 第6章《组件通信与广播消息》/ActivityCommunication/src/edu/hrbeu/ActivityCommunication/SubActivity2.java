package edu.hrbeu.ActivityCommunication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SubActivity2 extends Activity {
	 /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subactivity2);
        
        Button btnReturn = (Button)findViewById(R.id.btn_return);
        
        btnReturn.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		setResult(RESULT_CANCELED, null);
        		finish();
        	}
        });
    }
}
