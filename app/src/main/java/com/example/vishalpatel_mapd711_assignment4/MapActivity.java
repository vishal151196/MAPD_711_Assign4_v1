package com.example.vishalpatel_mapd711_assignment4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    ArrayList<LatLng> arrayList = new ArrayList<LatLng>();
    LatLng shop1 = new LatLng(-34, 151);
    LatLng shop2 = new LatLng(-31.916668, 151.750000);
    LatLng shop3 = new LatLng(-27.470125, 153.021072);

    String address = "";
    Double lat = 0.0;
    Double lng = 0.0;
    LatLng latlng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        arrayList.add(shop1);
        arrayList.add(shop2);
        arrayList.add(shop3);


        Intent intent = getIntent();
        address = intent.getStringExtra("Address");
        lat = intent.getDoubleExtra("Lat",0.0);
        lng = intent.getDoubleExtra("Lng",0.0);



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);


        int i;

        LatLng place = new LatLng(lat, lng);

        mMap.addMarker(new MarkerOptions().position(place).title(address));

        Integer zoom =15;
        CameraUpdate camUpdate = CameraUpdateFactory.newLatLngZoom(place,zoom);

        mMap.moveCamera(camUpdate);

    }

    public void addMark(LatLng latlng, String title){

        mMap.addMarker(new MarkerOptions().position(latlng).title(this.address));


    }

}
