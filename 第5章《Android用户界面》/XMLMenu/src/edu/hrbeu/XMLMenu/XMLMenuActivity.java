package edu.hrbeu.XMLMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class XMLMenuActivity extends Activity {
    /** Called when the activity is first created. */

	TextView LabelView = null;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        LabelView = (TextView)findViewById(R.id.label);
        registerForContextMenu(LabelView);
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, 
    		View v, ContextMenuInfo menuInfo){
    	
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.context_menu, menu);
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case R.id.contextMenu1:
    		LabelView.setText("菜单子项1");
    		return true;
    	case R.id.contextMenu2:
    		LabelView.setText("菜单子项2");
    		return true;
    	case R.id.contextMenu3:
    		LabelView.setText("菜单子项3");
    		return true;
    	}
    return false;
    }
    
    
}