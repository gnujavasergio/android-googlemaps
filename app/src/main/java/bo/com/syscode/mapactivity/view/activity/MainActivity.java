package bo.com.syscode.mapactivity.view.activity;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import bo.com.syscode.mapactivity.R;

public class MainActivity extends FragmentActivity implements OnMapReadyCallback {

	private GoogleMap mMap;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Obtain the SupportMapFragment and get notified when the map is ready to be used.
		SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
				.findFragmentById(R.id.map);
		mapFragment.getMapAsync(this);
	}


	/**
	 * Manipulates the map once available.
	 * This callback is triggered when the map is ready to be used.
	 * This is where we can add markers or lines, add listeners or move the camera. In this case,
	 * we just add a marker near Sydney, Australia.
	 * If Google Play services is not installed on the device, the user will be prompted to install
	 * it inside the SupportMapFragment. This method will only be triggered once the user has
	 * installed Google Play services and returned to the app.
	 */
	@Override
	public void onMapReady(GoogleMap googleMap) {
		mMap = googleMap;

		mMap.setMinZoomPreference(10);
		mMap.setMaxZoomPreference(19);

		// Add a marker in Sydney and move the camera
		LatLng sucre = new LatLng(-19.040179078634807, -65.25621296313443);

		MarkerOptions marker = new MarkerOptions()
				.position(sucre)
				.title("Bienvenidos a la CCBOL2017")
				.draggable(true);

		mMap.addMarker(marker);

		CameraPosition camera = new CameraPosition.Builder()
				.target(sucre)
				.zoom(18)  //limite ->21
				.bearing(0) // 0 - 360
				.tilt(45) // limite ->90
				.build();

		mMap.animateCamera(CameraUpdateFactory.newCameraPosition(camera));
		//mMap.moveCamera(CameraUpdateFactory.newLatLng(sucre));

		//Eventos
		mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
			@Override
			public void onMapClick(LatLng latLng) {
				Toast.makeText(getApplicationContext(), "Click: "  + latLng.latitude + "," + latLng.longitude, Toast.LENGTH_SHORT).show();
			}
		});

		mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
			@Override
			public void onMapLongClick(LatLng latLng) {
				Toast.makeText(getApplicationContext(), "Click Long: " + latLng.latitude + "," + latLng.longitude, Toast.LENGTH_SHORT).show();
			}
		});

		mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
			@Override
			public void onMarkerDragStart(Marker marker) {

			}

			@Override
			public void onMarkerDrag(Marker marker) {

			}

			@Override
			public void onMarkerDragEnd(Marker marker) {
				Toast.makeText(getApplicationContext(), "Drag: " + marker.getPosition().latitude + "," + marker.getPosition().longitude, Toast.LENGTH_SHORT).show();
			}
		});


	}
}
