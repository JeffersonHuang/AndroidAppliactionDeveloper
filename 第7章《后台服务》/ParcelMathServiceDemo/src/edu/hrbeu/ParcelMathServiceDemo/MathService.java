package edu.hrbeu.ParcelMathServiceDemo;

import edu.hrbeu.ParcelMathServiceDemo.AllResult;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.Toast;

public class MathService extends Service{
	
	private final IMathService.Stub mBinder = new IMathService.Stub() {   
        public long Add(long a, long b) { 
            return a + b; 
        }

		@Override
		public AllResult ComputeAll(long a, long b) throws RemoteException {
			long addRusult = a + b;
			long subResult = a - b;
			long mulResult = a * b;
			double divResult = (double) a / (double)b;
			
			AllResult allResult = new AllResult(addRusult, subResult, mulResult, divResult);
			return allResult;
		}               
    }; 
    
	@Override
	public IBinder onBind(Intent intent) {
		 Toast.makeText(this, "远程绑定：MathService", 
	     		  Toast.LENGTH_SHORT).show();
		return mBinder;
	}
	
	@Override
	public boolean  onUnbind  (Intent intent){
		  Toast.makeText(this, "取消远程绑定：MathService", 
		    		 Toast.LENGTH_SHORT).show();  
		return false;
	}
}
