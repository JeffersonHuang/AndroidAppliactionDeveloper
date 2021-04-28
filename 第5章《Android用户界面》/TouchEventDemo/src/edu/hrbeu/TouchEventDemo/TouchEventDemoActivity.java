package edu.hrbeu.TouchEventDemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class TouchEventDemoActivity extends Activity {
	
	TextView labelView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TextView touchView = (TextView)findViewById(R.id.touch_area);
        labelView = (TextView)findViewById(R.id.event_label);
        final TextView historyView = (TextView)findViewById(R.id.history_label);
        
        touchView.setOnTouchListener(new View.OnTouchListener(){
        	 @Override
        	 public boolean onTouch(View v, MotionEvent event) {
        	      int action = event.getAction();
        	      switch (action) {
        	        case (MotionEvent.ACTION_DOWN): 
        	        	Display("ACTION_DOWN",event);
        	        	break;
        	        case (MotionEvent.ACTION_UP): 
        	        	int historySize = ProcessHistory(event);
        	        	historyView.setText("历史数据量："+historySize);
        	        	Display("ACTION_UP",event);   
        	        	break;
        	        case (MotionEvent.ACTION_MOVE): 
        	        	Display("ACTION_MOVE",event);
        	        	break;
        	      }
        	      
        	      return true;
        	    }
        });
    
    }
    
    private void Display(String eventType, MotionEvent event){
    	int x = (int)event.getX();
    	int y = (int)event.getY();
    	float pressure = event.getPressure();
    	float size = event.getSize();
    	int RawX = (int)event.getRawX();
    	int RawY = (int)event.getRawY();

    	String msg = "";
    	msg += "事件类型：" + eventType + "\n";
    	msg += "相对坐标："+String.valueOf(x)+","+String.valueOf(y)+"\n";
    	msg += "绝对坐标："+String.valueOf(RawX)+","+String.valueOf(RawY)+"\n";
    	msg += "触点压力："+String.valueOf(pressure)+"，  ";
    	msg += "触点尺寸："+String.valueOf(size)+"\n";
    	labelView.setText(msg);
    }
    
    private int ProcessHistory(MotionEvent event)
    {
    	int historySize = event.getHistorySize();
    	for (int i = 0; i < historySize; i++) {
    		long time = event.getHistoricalEventTime(i);
    		float pressure = event.getHistoricalPressure(i);
    		float x = event.getHistoricalX(i);
    		float y = event.getHistoricalY(i);
    		float size = event.getHistoricalSize(i);
    		
    		// 处理过程......
    	}        
    	
    	return historySize;
    }
   
}