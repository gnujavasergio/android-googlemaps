package bo.com.syscode.mapactivity.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import bo.com.syscode.mapactivity.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback{

	private View root;
	private GoogleMap gMap;
	private MapView mapView;

	public MapFragment() {
		// Required empty public constructor
	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		root  = inflater.inflate(R.layout.fragment_map, container, false);
		mapView = root.findViewById(R.id.map_view);
		if(mapView != null){
			mapView.onCreate(null);
			mapView.onResume();
			mapView.getMapAsync(this);
		}
		return root;
	}

	@Override
	public void onMapReady(GoogleMap googleMap) {
		gMap =googleMap;
		// Add a marker in Sydney and move the camera
		LatLng sucre = new LatLng(-19.040179078634807, -65.25621296313443);

		MarkerOptions marker = new MarkerOptions()
				.position(sucre)
				.title("Bienvenidos a la CCBOL2017")
				.draggable(true);

		gMap.addMarker(marker);

		CameraPosition camera = new CameraPosition.Builder()
				.target(sucre)
				.zoom(18)  //limite ->21
				.bearing(0) // 0 - 365
				.tilt(45) // limite ->90
				.build();

		gMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
	}
}
