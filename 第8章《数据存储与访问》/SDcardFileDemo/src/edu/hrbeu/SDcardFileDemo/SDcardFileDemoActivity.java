package edu.hrbeu.SDcardFileDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SDcardFileDemoActivity extends Activity {
    
	private static String randomNumbersString = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button randomButton = (Button)findViewById(R.id.random);
        Button writeButton = (Button)findViewById(R.id.write);
        randomButton.setOnClickListener(randomButtonListener);
        writeButton.setOnClickListener(writeButtonListener);
    }
    
    OnClickListener randomButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			randomNumbersString = "";
			for (int i = 0 ; i<10; i++){
				randomNumbersString+=Math.random()+"\n";
			}
			TextView displayView = (TextView)findViewById(R.id.display);
			displayView.setText(randomNumbersString);
		}
    };
    OnClickListener writeButtonListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			String fileName = "SdcardFile-"+System.currentTimeMillis()+".txt";    
		    File dir = new File("/sdcard/");                                     
		    if (dir.exists() && dir.canWrite()) { 
		    	File newFile = new File(dir.getAbsolutePath() + "/" + fileName);   
		    	FileOutputStream fos  = null;
					try {
						newFile.createNewFile();
						if (newFile.exists() && newFile.canWrite()) { 
				    		fos  = new FileOutputStream(newFile); 
				        	fos.write(randomNumbersString.getBytes());    
				        	TextView labelView = (TextView)findViewById(R.id.label);
				        	labelView.setText(fileName + "ÎÄ¼þÐ´ÈëSD¿¨");
						}
					} catch (IOException e) {
						e.printStackTrace();
					} finally { 
		        	 if (fos != null) { 
		        		 try { 
		        			 fos.flush(); 
		        			 fos.close(); 
		        			 } 
		        		 catch (IOException e) { } 
		        			 } 
		        	 } 
		    	}
		    }
		};
}