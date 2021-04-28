package edu.hrbeu.TextViewDemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class TextViewDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView textView = (TextView)findViewById(R.id.TextView01);
        EditText editText = (EditText)findViewById(R.id.EditText01);
        textView.setText("ÓÃ»§Ãû£º");
        editText.setText("Rajan");
    }
}