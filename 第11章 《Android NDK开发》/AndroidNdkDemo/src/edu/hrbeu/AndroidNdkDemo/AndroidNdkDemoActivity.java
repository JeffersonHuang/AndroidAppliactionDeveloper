package edu.hrbeu.AndroidNdkDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AndroidNdkDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final TextView displayLable = (TextView)findViewById(R.id.display);
        
        Button btn = (Button)findViewById(R.id.add_btn);
        btn.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				double randomDouble = Math.random();
			    long x = Math.round(randomDouble*100);
			    randomDouble = Math.random();
			    long y = Math.round(randomDouble*100);
			        
			    System.loadLibrary("add-module");
			    long  z = add(x, y);
			    String msg = x+" + " +y+" = "+z;
			    displayLable.setText(msg);				
			}
        	
        });
        
       
    }
    
    public native long add(long  x, long  y);
    
//    public long add(long  x, long  y){
//    	return x+y;
//    }
//    static {
//        System.loadLibrary("add-module");
//    }
}