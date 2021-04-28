package edu.hrbeu.ActivityCommunication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityCommunicationActivity extends Activity {
	
	private static final int SUBACTIVITY1 = 1;
	private static final int SUBACTIVITY2 = 2;
	
	TextView textView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        textView = (TextView)findViewById(R.id.textShow);
        final Button btn1 = (Button)findViewById(R.id.btn1);
        final Button btn2 = (Button)findViewById(R.id.btn2);
        
        btn1.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		Intent intent = new Intent(ActivityCommunicationActivity.this, SubActivity1.class);
                startActivityForResult(intent, SUBACTIVITY1);
        	}
        });
        
        btn2.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		Intent intent = new Intent(ActivityCommunicationActivity.this, SubActivity2.class);
                startActivityForResult(intent, SUBACTIVITY2);
        	}
        });
    }

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		switch(requestCode){
		case SUBACTIVITY1:
			if (resultCode == RESULT_OK){
				Uri uriData = data.getData();
				textView.setText(uriData.toString());
			}
			break;
		case SUBACTIVITY2:
			break;
		}
	}
}