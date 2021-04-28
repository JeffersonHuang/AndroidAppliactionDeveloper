package edu.hrbeu.ServiceWidget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class TRandomService extends Service implements Runnable {
	
	private static boolean threadRunning = false;  
	private static Thread workThread  = new Thread("WorkThread");
	
	@Override
	public void onCreate() {
	    super.onCreate();
	    Toast.makeText(this, "(1) 调用onCreate()", 
	    		Toast.LENGTH_LONG).show();    
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
	      super.onStart(intent, startId);
	      Toast.makeText(this, "(2) 调用onStart() :"  ,  Toast.LENGTH_SHORT).show();      
	       if (!threadRunning) {  
               threadRunning=true;  
               new Thread(this).start();  
           }
	}
	
	@Override
	public void onDestroy() {
	     super.onDestroy();
	     Toast.makeText(this, "(3) 调用onDestroy()", 
	    		 Toast.LENGTH_SHORT).show();     
	     workThread.interrupt();
	     threadRunning = false;
	}
	 
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public void run() {
		while(!Thread.interrupted()){				
			double randomDouble = Math.random();
			String msg = String.valueOf(randomDouble);
		    WidgetProvider.updateAppWidget(this, msg);	    
		    
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	

}
