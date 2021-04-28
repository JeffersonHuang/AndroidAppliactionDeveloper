package edu.hrbeu.GoogleMapDemo;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

import android.os.Bundle;

public class GoogleMapDemoActivity extends MapActivity {
    /** Called when the activity is first created. */
	
	private MapView mapView;
	private MapController mapController;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        mapView = (MapView)findViewById(R.id.mapview);
       
        mapController = mapView.getController();
        
        Double lng = 126.676530486 * 1E6;
        Double lat = 45.7698895661 * 1E6;
        GeoPoint point = new GeoPoint(lat.intValue(), lng.intValue());
        
        mapController.setCenter(point);
        mapController.setZoom(11);
        mapController.animateTo(point);
    
        mapView.setSatellite(false);
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return true;
	}
}