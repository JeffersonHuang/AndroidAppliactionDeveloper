package edu.hrbeu.SubMenu2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.TextView;

public class SubMenu2Activity extends Activity {
	final static int MENU_00 = Menu.FIRST;
	final static int MENU_01 = Menu.FIRST+1;
	final static int SUB_MENU_00_01 = Menu.FIRST+2;
	final static int SUB_MENU_01_00 = Menu.FIRST+3;
	final static int SUB_MENU_01_01 = Menu.FIRST+4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       	
		SubMenu sub1 = (SubMenu) menu.addSubMenu(0,MENU_00,0,"设置")
				.setHeaderIcon(R.drawable.pic3);
		sub1.add(0,SUB_MENU_00_01 ,0,"打印").setIcon(R.drawable.pic0);
		
		SubMenu sub2 = (SubMenu) menu.addSubMenu(0,MENU_01,1,"新建")
				.setHeaderIcon(R.drawable.pic1);
		sub2.add(0,SUB_MENU_01_00 ,0,"邮件").setIcon(R.drawable.pic2);
		sub2.add(0,SUB_MENU_01_01 ,0,"订阅").setIcon(R.drawable.pic4);

        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        TextView label = (TextView)findViewById(R.id.label);
        
        switch (item.getItemId()) {
        case MENU_00:
        	label.setText("设置，菜单ID：" + item.getItemId());
            return true;
        case MENU_01:
        	label.setText("新建，菜单ID：" + item.getItemId());
            return true;
        case SUB_MENU_00_01:
        	label.setText("打印，子菜单ID：" + item.getItemId());
            return true;
        case SUB_MENU_01_00:
        	label.setText("邮件，子菜单ID：" + item.getItemId());
            return true;
        case SUB_MENU_01_01:
        	label.setText("订阅，子菜单ID：" + item.getItemId());
            return true;
        default:
            return false;
        }
    }
}