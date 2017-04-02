package com.att.tsa.home.geolocator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.att.tsa.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * @author Rajesh Pattanaik
 */

public class GeolocatorFragment extends Fragment {

    @BindView(R.id.mapView)
    MapView mapView;

    private GoogleMap mGoogleMap;

    public static Fragment newInstance() {
        return new GeolocatorFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_geolocator, container, false);
        ButterKnife.bind(this, view);

        mapView.onCreate(savedInstanceState);

        mapView.onResume();

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        mapView.getMapAsync(googleMap -> {
            mGoogleMap = googleMap;

            // For dropping a marker at a point on the Map
            LatLng techm = new LatLng(18.5822503, 73.689267);
            LatLng tcs = new LatLng(18.580286, 73.6852447);
            LatLng infy = new LatLng(18.5990005, 73.707941);
            LatLng cogni = new LatLng(18.58651, 73.6954096);
            LatLng wipro = new LatLng(18.5872485, 73.7308252);
            mGoogleMap.addMarker(new MarkerOptions().position(techm).title("Tech Mahindra").snippet("Tech Mahindra Ltd"));
            mGoogleMap.addMarker(new MarkerOptions().position(tcs).title("TCS").snippet("Tata Consultancy Services"));
            mGoogleMap.addMarker(new MarkerOptions().position(infy).title("Infy").snippet("Infosys"));
            mGoogleMap.addMarker(new MarkerOptions().position(cogni).title("CTS").snippet("Cognizant"));
            mGoogleMap.addMarker(new MarkerOptions().position(wipro).title("Wipro").snippet("Wipro"));

            // For zooming automatically to the location of the marker
            CameraPosition cameraPosition = new CameraPosition.Builder().target(techm).zoom(12).build();
            mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }
}
