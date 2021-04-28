package edu.hrbeu.LogCat;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class LogCatActivity extends Activity {
    /** Called when the activity is first created. */
	
	final static String TAG = "LOGCAT";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Log.v(TAG,"Verbose");
        Log.d(TAG,"Debug");
        Log.i(TAG,"Info");
        Log.w(TAG,"Warn");
        Log.e(TAG,"Error");
    }
}