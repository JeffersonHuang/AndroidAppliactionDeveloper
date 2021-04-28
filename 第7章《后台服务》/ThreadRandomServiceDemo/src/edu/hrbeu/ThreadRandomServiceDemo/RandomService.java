package edu.hrbeu.ThreadRandomServiceDemo;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class RandomService extends Service{
	
	private Thread workThread;
	
	@Override
	public void onCreate() {
	    super.onCreate();
	    Toast.makeText(this, "(1) 调用onCreate()", 
	    		Toast.LENGTH_LONG).show();    
	    workThread = new Thread(null,backgroudWork,"WorkThread");
	}
	
	@Override
	public void onStart(Intent intent, int startId) {
	      super.onStart(intent, startId);
	      Toast.makeText(this, "(2) 调用onStart()", 
	    		  Toast.LENGTH_SHORT).show();
	      if (!workThread.isAlive()){
	    	  workThread.start();
	      }

	}
	
	@Override
	public void onDestroy() {
	     super.onDestroy();
	     Toast.makeText(this, "(3) 调用onDestroy()", 
	    		 Toast.LENGTH_SHORT).show();     
	     workThread.interrupt();
	}
	 
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	private Runnable backgroudWork = new Runnable(){
		@Override
		public void run() {
			try {
				while(!Thread.interrupted()){				
					double randomDouble = Math.random();
					ThreadRandomServiceDemoActivity.UpdateGUI(randomDouble);
					Thread.sleep(1000);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	};
	

}
