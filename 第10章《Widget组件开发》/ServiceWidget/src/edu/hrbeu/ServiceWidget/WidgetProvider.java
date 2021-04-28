package edu.hrbeu.ServiceWidget;

import java.util.LinkedList;
import java.util.Queue;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
    
    private static final String TAG = "S_WIDGET";
    private static Queue<Integer> widgetIds=new LinkedList<Integer>(); 
    
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "onUpdate");

        for (int i = 0 ;i<appWidgetIds.length; i++ ){   	  
        	widgetIds.add(appWidgetIds[i]);
        	Log.d(TAG," widgetId:" + appWidgetIds[i]+ ", Size:" + widgetIds.size());
        }
              
        Log.d(TAG, "appWidgetIds.length:" + appWidgetIds.length);  
        context.startService(new Intent(context, TRandomService.class));
    }
    
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG, "onDeleted");
        for (int i = 0; i< appWidgetIds.length ;i++){
        	if (widgetIds.contains(appWidgetIds[i])){
        		widgetIds.remove((Object)appWidgetIds[i]);
        	}
        	Log.d(TAG," widgetIds:" + appWidgetIds[i]+ ", Size:" + widgetIds.size());
        }
        Log.d(TAG, "appWidgetIds.length:" + appWidgetIds.length); 
    }

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "onEnabled");
    }

    @Override
    public void onDisabled(Context context) {
        Log.d(TAG, "onDisabled");
        context.stopService(new Intent(context, TRandomService.class));
    }
    
    public static void updateAppWidget(Context context, String displayMsg ) {      
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);  
        RemoteViews views = new RemoteViews(context.getPackageName(),R.layout.widget_layout);  
        views.setTextViewText(R.id.label, displayMsg);  
          
        final int N = widgetIds.size();
        for (int i=0; i<N; i++) {	
        	int appWidgetId = widgetIds.poll();
        	appWidgetManager.updateAppWidget(appWidgetId, views);
        	widgetIds.add(appWidgetId);
        }
    }  

}


