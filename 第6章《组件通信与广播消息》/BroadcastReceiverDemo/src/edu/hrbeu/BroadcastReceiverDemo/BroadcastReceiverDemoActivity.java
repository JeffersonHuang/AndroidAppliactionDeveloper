package edu.hrbeu.BroadcastReceiverDemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class BroadcastReceiverDemoActivity extends Activity {
	private EditText entryText ;
	private Button button;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        entryText = (EditText)findViewById(R.id.entry);
        button = (Button)findViewById(R.id.btn);
        
        button.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		Intent intent = new Intent("edu.hrbeu.BroadcastReceiverDemo");
        		intent.putExtra("message", entryText.getText().toString());
        		sendBroadcast(intent);
        	}
        });
    }
}