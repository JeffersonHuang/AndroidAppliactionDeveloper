package edu.hrbeu.MapOverlayDemo;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class TextOverlay extends Overlay {
	
	private final int mRadius = 5;

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		Projection projection = mapView.getProjection();
		
		if (shadow == false){
			
			Double lng = 126.676530486 * 1E6;
	        Double lat = 45.7698895661 * 1E6;
	        GeoPoint geoPoint = new GeoPoint(lat.intValue(), lng.intValue());
			
			Point point = new Point();
			projection.toPixels(geoPoint, point);
			
			RectF oval = new RectF(point.x - mRadius, point.y - mRadius, 
								   point.x + mRadius, point.y + mRadius);
			
			Paint paint = new Paint();
			paint.setARGB(250, 250, 0, 0);
			paint.setAntiAlias(true);
			paint.setFakeBoldText(true);
			
			canvas.drawOval(oval, paint);
			canvas.drawText("±ê¼Çµã", point.x+2*mRadius, point.y, paint);
		}
		
		super.draw(canvas, mapView, shadow);
	}

	@Override
	public boolean onTap(GeoPoint p, MapView mapView) {

		return false;
	}
}
