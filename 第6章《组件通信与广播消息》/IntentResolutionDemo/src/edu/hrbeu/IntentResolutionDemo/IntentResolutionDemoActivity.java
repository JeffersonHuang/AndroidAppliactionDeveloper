package edu.hrbeu.IntentResolutionDemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class IntentResolutionDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button)findViewById(R.id.btn);
        button.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("schemodemo://edu.hrbeu/path"));
        		startActivity(intent);
        	}
        });
    }
}