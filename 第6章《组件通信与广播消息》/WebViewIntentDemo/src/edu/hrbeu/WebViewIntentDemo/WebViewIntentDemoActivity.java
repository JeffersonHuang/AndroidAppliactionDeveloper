package edu.hrbeu.WebViewIntentDemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class WebViewIntentDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final EditText editText = (EditText)findViewById(R.id.edit_url);
        final Button button = (Button)findViewById(R.id.btn);
        
        button.setOnClickListener(new OnClickListener(){
        	public void onClick(View view){
        		String urlString = editText.getText().toString();
        		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlString));
                startActivity(intent);
        	}
        });
    }
}