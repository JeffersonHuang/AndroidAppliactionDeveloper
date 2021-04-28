package edu.hrbeu.KeyEventDemo;


import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class KeyEventDemoActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        EditText entryText = (EditText)findViewById(R.id.entry);
        final CheckBox checkBox = (CheckBox)findViewById(R.id.block);
        final TextView labelView = (TextView)findViewById(R.id.label);
        entryText.setOnKeyListener(new OnKeyListener(){
			@Override
			public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {

				int metaState = keyEvent.getMetaState();
				int unicodeChar = keyEvent.getUnicodeChar();
				String msg = "";
				msg +="按键动作:" + String.valueOf(keyEvent.getAction())+"\n";
				msg +="按键代码:" + String.valueOf(keyCode)+"\n";
				msg +="按键字符:" + (char)unicodeChar+"\n";
				msg +="UNICODE:" + String.valueOf(unicodeChar)+"\n";
				msg +="重复次数:" + String.valueOf(keyEvent.getRepeatCount())+"\n";
				msg +="功能键状态:" + String.valueOf(metaState)+"\n";
				msg +="硬件编码:" + String.valueOf(keyEvent.getScanCode())+"\n";
				msg +="按键标志:" + String.valueOf(keyEvent.getFlags())+"\n";
				labelView.setText(msg);
		
				if (checkBox.isChecked())
					return true;
				else
					return false;
			}      	
        });  
    }
}