package edu.hrbeu.MapOverlayDemo;

import java.util.List;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

import android.os.Bundle;

public class MapOverlayDemoActivity extends MapActivity {
	
	private MapView mapView;
	private MapController mapController;
	
	private TextOverlay textOverlay;
	
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
        
        textOverlay = new TextOverlay();
        List<Overlay> overlays = mapView.getOverlays();
        overlays.add(textOverlay);
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
}