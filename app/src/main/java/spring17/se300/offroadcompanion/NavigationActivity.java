package spring17.se300.offroadcompanion;

import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.LocationSource;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;


/**
 * Created by Ed Lewis on 3/20/2017.
 *
 * Shawn McDonnell provided assistance on getting the user location to work.
 *
 * onConnected Makes sure that the device has been given permission to find the users location.
 * LongPressLocationSource Drops a pin on a location when a user long presses the screen.
 * onCreate Sets the layout for the map activity and connects to google API services to build the map.
 * onResume communicates with the superclass onResume to resume where the maps were.
 * onPause communicates with the superclass onResume to resume where the maps were.
 * onMapReady when the map activity is started, it sets the camera to center on the users location, as well as change the type of map.
 * onStart connects with GoogleAPIClient when the activity is opened.
 * onStop disconnects with GoogleAPIClient when the activity is opened.
 *
 *
 */

public class NavigationActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks
{
    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    GoogleMap mMap;
    private LongPressLocationSource mLocationSource;

    @Override
    public void onConnected(@Nullable Bundle bundle)
    {
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.
                PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                (this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED)
        {
            return;
        }
        mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
    }

    @Override
    public void onConnectionSuspended(int i)
    {

    }

    private static class LongPressLocationSource implements LocationSource, OnMapLongClickListener
    {

        private OnLocationChangedListener mListener;
        private boolean mPaused;

        @Override
        public void activate(OnLocationChangedListener listener)
        {
            mListener = listener;
        }

        @Override
        public void deactivate() {
            mListener = null;
        }

        @Override
        public void onMapLongClick(LatLng point)
        {
            if (mListener != null && !mPaused)
            {
                Location location = new Location("LongPressLocationProvider");
                location.setLatitude(point.latitude);
                location.setLongitude(point.longitude);
                location.setAccuracy(100);
                mListener.onLocationChanged(location);
            }
        }

        public void onPause()
        {
            mPaused = true;
        }

        public void onResume()
        {
            mPaused = false;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        mLocationSource = new LongPressLocationSource();

        if (mGoogleApiClient == null)
        {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addApi(LocationServices.API)
                    .build();
        }
        SupportMapFragment mapFragment =
                (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        mLocationSource.onResume();
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        mLocationSource.onPause();
    }

    @Override
    public void onMapReady(GoogleMap map)
    {
        mMap = map;
        mMap.setOnMapLongClickListener(mLocationSource);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.setMyLocationEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(29.189329, -81.048740)));
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }

    protected void onStart()
    {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop()
    {
        mGoogleApiClient.disconnect();
        super.onStop();
    }
}
