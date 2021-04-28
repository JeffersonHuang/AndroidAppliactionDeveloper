package edu.hrbeu.ConfigWidget;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.util.Log;
import android.widget.RemoteViews;

public class WidgetProvider extends AppWidgetProvider {
    
    private static final String TAG = "WIDGET";
  
    
    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        Log.d(TAG, "onUpdate");
    }
    
    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        Log.d(TAG, "onDeleted");
    }

    @Override
    public void onEnabled(Context context) {
        Log.d(TAG, "onEnabled");
    }

    @Override
    public void onDisabled(Context context) {
        Log.d(TAG, "onDisabled");
   
    }
    
    static void updateTextColor(Context context, AppWidgetManager appWidgetManager,
            int appWidgetId, int textColor) {
    	
    	RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_layout);
        views.setTextColor(R.id.label,textColor);
        appWidgetManager.updateAppWidget(appWidgetId, views); 
    }
}
