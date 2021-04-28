package edu.hrbeu.SimpleRandomServiceDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SimpleRandomServiceDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button startButton = (Button)findViewById(R.id.start);
        Button stopButton = (Button)findViewById(R.id.stop);
        
        final Intent serviceIntent = new Intent(this, RandomService.class);
        
        startButton.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View view){
        		startService(serviceIntent);
        	}
        });
        
        stopButton.setOnClickListener(new Button.OnClickListener(){
        	public void onClick(View view){
        		stopService(serviceIntent);
        	}
        });
    }
}