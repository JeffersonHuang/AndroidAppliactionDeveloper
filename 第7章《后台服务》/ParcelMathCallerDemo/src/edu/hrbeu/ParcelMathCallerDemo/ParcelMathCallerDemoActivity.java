package edu.hrbeu.ParcelMathCallerDemo;

import edu.hrbeu.ParcelMathServiceDemo.IMathService;
import edu.hrbeu.ParcelMathServiceDemo.AllResult;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParcelMathCallerDemoActivity extends Activity {
	private IMathService mathService;
	private boolean isBound = false;
	TextView labelView;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        labelView = (TextView)findViewById(R.id.label);
        Button bindButton = (Button)findViewById(R.id.bind);
        Button unbindButton = (Button)findViewById(R.id.unbind);
        Button computAllButton = (Button)findViewById(R.id.compute_all);
        
        bindButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				if(!isBound){
					final Intent serviceIntent = new Intent();
					serviceIntent.setAction("edu.hrbeu.ParcelMathServiceDemo.MathService");
					bindService(serviceIntent,mConnection,Context.BIND_AUTO_CREATE);
					isBound = true;
				}
			}  	
        }); 
        
        unbindButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
				if(isBound){
					isBound = false;
					unbindService(mConnection);
					mathService = null;
				}
			}    	
        });
       
        
        computAllButton.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View v) {
					if (mathService == null){
						labelView.setText("未绑定远程服务");
						return;
					}
					long a = Math.round(Math.random()*100);
					long b = Math.round(Math.random()*100);
					AllResult result = null;
					try {
						result = mathService.ComputeAll(a, b);
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					String msg = "";
					if (result != null){
						msg += String.valueOf(a)+" + "+String.valueOf(b)+" = "+String.valueOf(result.AddResult)+"\n";
						msg += String.valueOf(a)+" - "+String.valueOf(b)+" = "+String.valueOf(result.SubResult)+"\n";
						msg += String.valueOf(a)+" * "+String.valueOf(b)+" = "+String.valueOf(result.MulResult)+"\n";
						msg += String.valueOf(a)+" / "+String.valueOf(b)+" = "+String.valueOf(result.DivResult);
					}
					labelView.setText(msg);
			} 	
        });
    }
    
    private ServiceConnection mConnection = new ServiceConnection() {                           
		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			mathService = IMathService.Stub.asInterface(service);                          
		}
		@Override
		public void onServiceDisconnected(ComponentName name) {
			mathService = null; 
		} 
    }; 
}