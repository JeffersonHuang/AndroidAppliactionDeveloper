package edu.hrbeu.ActionBar;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class ActionBarActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
    	TextView label = (TextView)findViewById(R.id.label);
    	switch(item.getItemId())
    	{
    	  case R.id.main_menu_0:
          	label.setText("打印，菜单ID：" + item.getItemId());
              return true;
          case R.id.main_menu_1:
          	label.setText("新建，菜单ID：" + item.getItemId());
              return true;
          case R.id.main_menu_2:
          	label.setText("邮件，菜单ID：" + item.getItemId());
              return true;
          case R.id.main_menu_3:
          	label.setText("设置，菜单ID：" + item.getItemId());
              return true;
          case R.id.main_menu_4:
          	label.setText("订阅，菜单ID：" + item.getItemId());
              return true;
    	}
 	
    	return false;
    }

}