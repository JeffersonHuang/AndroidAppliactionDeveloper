package edu.hrbeu.ThreadRandomServiceDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ThreadRandomServiceDemoActivity extends Activity {
 
	private static Handler handler = new Handler();
	private static TextView labelView = null;
	private static double randomDouble ;
	
	public static void UpdateGUI(double refreshDouble){
		randomDouble = refreshDouble;
		handler.post(RefreshLable);
	}
	
	private static Runnable RefreshLable = new Runnable(){
		@Override
		public void run() {
			labelView.setText(String.valueOf(randomDouble));
		}
	};
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        labelView = (TextView)findViewById(R.id.label);
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