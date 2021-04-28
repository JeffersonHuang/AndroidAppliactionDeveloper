package edu.hrbeu.ContextMenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.TextView;

public class ContextMenuActivity extends Activity {
    /** Called when the activity is first created. */
	final static int CONTEXT_MENU_1 = Menu.FIRST;
	final static int CONTEXT_MENU_2 = Menu.FIRST+1;
	final static int CONTEXT_MENU_3 = Menu.FIRST+2;
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
    	menu.setHeaderTitle("快捷菜单标题");
    	menu.add(0, CONTEXT_MENU_1, 0,"菜单子项1");
    	menu.add(0, CONTEXT_MENU_2, 1,"菜单子项2");
    	menu.add(0, CONTEXT_MENU_3, 2,"菜单子项3");
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item){
    	switch(item.getItemId()){
    	case CONTEXT_MENU_1:
    		LabelView.setText("菜单子项1");
    		return true;
    	case CONTEXT_MENU_2:
    		LabelView.setText("菜单子项2");
    		return true;
    	case CONTEXT_MENU_3:
    		LabelView.setText("菜单子项3");
    		return true;
    	}
    return false;
    }
    
    
}