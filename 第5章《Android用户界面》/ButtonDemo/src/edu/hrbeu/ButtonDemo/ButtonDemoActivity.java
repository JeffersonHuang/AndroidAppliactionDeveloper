package edu.hrbeu.ButtonDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class ButtonDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button button = (Button)findViewById(R.id.Button01);
        ImageButton imageButton = (ImageButton)findViewById(R.id.ImageButton01);
        button.setText("Button按钮");
        imageButton.setImageResource(R.drawable.download);
        
        final TextView textView = (TextView)findViewById(R.id.TextView01);
        
        //（1）按钮注册到各自的监听器
        button.setOnClickListener(new View.OnClickListener() {
          public void onClick(View view) {
          textView.setText("Button按钮");
          }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            textView.setText("ImageButton按钮");
            }
          });
        
        //（2）按钮注册到同一个监听器
//        Button.OnClickListener buttonListener = new Button.OnClickListener(){
//			@Override
//			public void onClick(View v) {
//				switch(v.getId()){
//					case R.id.Button01:
//						textView.setText("Button按钮");
//						return;
//					case R.id.ImageButton01:
//						textView.setText("ImageButton按钮");
//						return;
//				}	
//			}};
//        	
//		button.setOnClickListener(buttonListener);
//		imageButton.setOnClickListener(buttonListener);
		
        }
        
    }
