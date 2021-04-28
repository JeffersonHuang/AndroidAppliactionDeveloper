package edu.hrbeu.WeatherDemo;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import edu.hrbeu.WeatherDemo.DB.DBAdapter;
import edu.hrbeu.WeatherDemo.Weather.Weather;
import edu.hrbeu.WeatherDemo.Service.WeatherService;

public class WeatherActivity extends Activity{

	final static int MENU_START_SERVICE= Menu.FIRST ;
	final static int MENU_STOP_SERVICE = Menu.FIRST + 1;
	final static int MENU_REFRESH = Menu.FIRST + 2;
	final static int MENU_QUIT = Menu.FIRST +3;
	
	private DBAdapter dbAdapter ;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.tab_weather);
	        
	        dbAdapter = new DBAdapter(this);
	        dbAdapter.open();  
			dbAdapter.LoadConfig();		
			
	 }
	 	 
	  @Override
	 public boolean onCreateOptionsMenu(Menu menu){

		 menu.add(0,MENU_START_SERVICE,0,"启动服务");
		 menu.add(0,MENU_STOP_SERVICE,1,"停止服务");
		 menu.add(0,MENU_REFRESH ,2,"刷新");
 		 menu.add(0,MENU_QUIT,3,"退出");
 		 return true;
	 }
	 
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item){
		 final Intent serviceIntent = new Intent(this, WeatherService.class);
		 switch(item.getItemId()){
		 	case MENU_REFRESH:
		 		RefreshWeatherData();
	    		return true;	   
		 	case MENU_START_SERVICE:
		 		startService(serviceIntent);
	    		return true;	
		 	case MENU_STOP_SERVICE:
		 		stopService(serviceIntent);
	    		return true;	
	    	case MENU_QUIT:
	    		finish();
	    		break;
	    	}	
	    	return false;
	  } 

	 private void RefreshWeatherData(){
		 
		 //(0) 当前温度
			TextView currentCondition = (TextView)findViewById(R.id.tab_weather_current_condition);
			TextView currentWind = (TextView)findViewById(R.id.tab_weather_current_wind);
			ImageView currentImage = (ImageView)findViewById(R.id.tab_weather_current_image);
			TextView currentCity = (TextView)findViewById(R.id.tab_weather_current_city);
			
			String msgCondition = "";
			msgCondition += "Temperature：" + Weather.current_temp + ", ";
			msgCondition += Weather.current_humidity ;
			currentCondition.setText(msgCondition);
			
			currentWind.setText(Weather.current_wind + ", " + Weather.current_date_time);	
			currentImage.setImageBitmap(Weather.current_image);
			currentCity.setText(Weather.city);
			
			 //(1) 预报：第1天
			TextView forcastD1Date = (TextView)findViewById(R.id.tab_weather_d1_date);
			ImageView forcastD1Image = (ImageView)findViewById(R.id.tab_weather_d1_image);
			TextView forcastD1Temperature = (TextView)findViewById(R.id.tab_weather_d1_temperature);
			
			forcastD1Date.setText(Weather.day[0].day_of_week);
			forcastD1Image.setImageBitmap(Weather.day[0].image);
			
			String msgD1Temperature = Weather.day[0].high + "/" + Weather.day[0].low;
			forcastD1Temperature.setText(msgD1Temperature);
			
			 //(2) 预报：第2天
			TextView forcastD2Date = (TextView)findViewById(R.id.tab_weather_d2_date);
			ImageView forcastD2Image = (ImageView)findViewById(R.id.tab_weather_d2_image);
			TextView forcastD2Temperature = (TextView)findViewById(R.id.tab_weather_d2_temperature);
			
			forcastD2Date.setText(Weather.day[1].day_of_week);
			forcastD2Image.setImageBitmap(Weather.day[1].image);
			
			String msgD2Temperature = Weather.day[1].high + "/" + Weather.day[1].low;
			forcastD2Temperature.setText(msgD2Temperature);
			
			 //(3) 预报：第3天
			TextView forcastD3Date = (TextView)findViewById(R.id.tab_weather_d3_date);
			ImageView forcastD3Image = (ImageView)findViewById(R.id.tab_weather_d3_image);
			TextView forcastD3Temperature = (TextView)findViewById(R.id.tab_weather_d3_temperature);
			
			forcastD3Date.setText(Weather.day[2].day_of_week);
			forcastD3Image.setImageBitmap(Weather.day[2].image);
			
			String msgD3Temperature = Weather.day[2].high + "/" + Weather.day[2].low;
			forcastD3Temperature.setText(msgD3Temperature);
			
			
			 //(4) 预报：第4天
			TextView forcastD4Date = (TextView)findViewById(R.id.tab_weather_d4_date);
			ImageView forcastD4Image = (ImageView)findViewById(R.id.tab_weather_d4_image);
			TextView forcastD4Temperature = (TextView)findViewById(R.id.tab_weather_d4_temperature);
			
			forcastD4Date.setText(Weather.day[3].day_of_week);
			forcastD4Image.setImageBitmap(Weather.day[3].image);
			
			String msgD4Temperature = Weather.day[3].high + "/" + Weather.day[3].low;
			forcastD4Temperature.setText(msgD4Temperature);
			
	 }
	 
}
