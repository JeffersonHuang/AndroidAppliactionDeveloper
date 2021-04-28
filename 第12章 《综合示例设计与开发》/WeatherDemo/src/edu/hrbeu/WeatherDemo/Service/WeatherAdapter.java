package edu.hrbeu.WeatherDemo.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import edu.hrbeu.WeatherDemo.DB.Config;
import edu.hrbeu.WeatherDemo.Weather.Weather;

public class WeatherAdapter {
	
	public static void GetWeatherData() throws IOException, Throwable {

    	String queryString = "http://www.google.com/ig/api?weather=" + Config.CityName;

    	URL aURL = new URL(queryString.replace(" ", "%20"));
     	URLConnection conn = aURL.openConnection();
        conn.connect();
        InputStream is = conn.getInputStream();
         
      	XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
        factory.setNamespaceAware(true);
        XmlPullParser parser = factory.newPullParser();
        parser.setInput(is,"UTF-8");
        
        int dayCounter = 0;
        while(parser.next()!= XmlPullParser.END_DOCUMENT){
  
        	String element = parser.getName(); 
        	if (element != null && element.equals("forecast_information")){
        		while(true){
        			int eventCode = parser.next();
        			element =  parser.getName();
        			if (eventCode == XmlPullParser.START_TAG){
        				if (element.equals("city")){
    	            		Weather.city =  parser.getAttributeValue(0);
        				}else if (element.equals("current_date_time")){ 
        					Weather.current_date_time = parser.getAttributeValue(0);  
        				}
        			}
        			
        			if (element.equals("forecast_information") && 
        					eventCode == XmlPullParser.END_TAG){
        				break;
        			}
        		}    		
        	}
        	if (element != null && element.equals("current_conditions")){
        		while(true){
        			int eventCode = parser.next();
        			element =  parser.getName();
        			if (eventCode == XmlPullParser.START_TAG){
        				if (element.equals("condition")){
    	            		Weather.current_condition =  parser.getAttributeValue(0);
        				}else if (element.equals("temp_f")){ 
        					Weather.current_temp = parser.getAttributeValue(0);  
        				}else if (element.equals("humidity")){ 
        					Weather.current_humidity = parser.getAttributeValue(0);  
        				}else if (element.equals("wind_condition")){ 
        					Weather.current_wind = parser.getAttributeValue(0); 
        				}else if (element.equals("icon")){ 
        					Weather.current_image_url = parser.getAttributeValue(0);  
        					Weather.current_image = GetURLBitmap(Weather.current_image_url);
        				}
        			}
        			
        			if (element.equals("current_conditions") && 
        					eventCode == XmlPullParser.END_TAG){
        				break;
        			}
        		}    		
        	}
        	if (element != null && element.equals("forecast_conditions")){
        		while(true){
        			int eventCode = parser.next();
        			element =  parser.getName();
        			if (eventCode == XmlPullParser.START_TAG){
        				if (element.equals("day_of_week")){
    	            		Weather.day[dayCounter].day_of_week =  parser.getAttributeValue(0);
        				}else if (element.equals("low")){ 
        					Weather.day[dayCounter].low = parser.getAttributeValue(0);  
        				}else if (element.equals("high")){ 
        					Weather.day[dayCounter].high = parser.getAttributeValue(0);  
        				}else if (element.equals("icon")){ 
        					Weather.day[dayCounter].image_url = parser.getAttributeValue(0); 
        					Weather.day[dayCounter].image = GetURLBitmap(Weather.day[dayCounter].image_url);
        				}else if (element.equals("condition")){ 
        					Weather.day[dayCounter].condition = parser.getAttributeValue(0);  
        				}
        			}
        			
        			if (element.equals("forecast_conditions") && 
        					eventCode == XmlPullParser.END_TAG){
        				dayCounter++;
        				break;
        			}
        		}    
        	}
        	
        }       
        is.close();
	}
	
	private static Bitmap GetURLBitmap(String urlString){
		
	    URL url = null;
	    Bitmap bitmap = null;
	    try {
	    	url = new URL("http://www.google.com" + urlString);
	    }
	    catch (MalformedURLException e){
	      e.printStackTrace();
	    }
	    
	    try{
	      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	      conn.connect();
	      InputStream is = conn.getInputStream();
	      bitmap = BitmapFactory.decodeStream(is);
	      is.close();
	    }
	    catch (IOException e){
	      e.printStackTrace();
	    }
	    return bitmap;
	  }

	
}
