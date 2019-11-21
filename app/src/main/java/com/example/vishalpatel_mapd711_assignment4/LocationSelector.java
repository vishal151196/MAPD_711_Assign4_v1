package com.example.vishalpatel_mapd711_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Arrays;

public class LocationSelector extends AppCompatActivity implements  View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView titleShowroom,locationAddress;
    Button Search,locateMap;
    String title;
    String address = "";
    LatLng latlng;

    String tommy_ad_1 = "41 Lapsley Rd · (416) 967-1111";
    String tommy_ad_2 = "1011 Upper Middle Rd E, Oakville, ON L6H 4L2";
    String tommy_ad_3 = "4844 Yonge St, North York, ON M2N 5N2";
    String tommy_ad_4 = "40 Bay St, Toronto, ON M5J 2X2";

    ArrayList<String> ListTommyHilfiger = new ArrayList<String>(Arrays.asList(tommy_ad_1,tommy_ad_2,tommy_ad_3,tommy_ad_4));


    LatLng tommy_lat_lng_1 =  new LatLng(43.797184, -79.228351);
    LatLng tommy_lat_lng_2 =  new LatLng(43.484491, -79.697253);
    LatLng tommy_lat_lng_3 =  new LatLng(43.763361, -79.411115);
    LatLng tommy_lat_lng_4 =  new LatLng(43.647878, -79.379857);

    ArrayList<LatLng> ListTommyHilfigerLatLng = new ArrayList<LatLng>(Arrays.asList(tommy_lat_lng_1,tommy_lat_lng_2,tommy_lat_lng_3,tommy_lat_lng_4));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selector);

        titleShowroom = findViewById(R.id.titleShowroom);
        locationAddress = findViewById(R.id.locationAddress);
        Search = findViewById(R.id.Search);
        locateMap = findViewById(R.id.locateMap);
        Spinner locationSpinner = findViewById(R.id.spinner);


        Intent intent = getIntent();
        title = intent.getStringExtra("Place");



        locateMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMapActivity();
            }

        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.showroom_location, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(adapter);
        locationSpinner.setOnItemSelectedListener(this);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if (title.equals("TOMMY HILFIGER")){
            address = ListTommyHilfiger.get(position);
            latlng = ListTommyHilfigerLatLng.get(position);

        }
        if (title.equals("HUDSON BAY")){
            //address = ListTommyHilfigerLatLng.get(position);

        }

        titleShowroom.setText(title);
        locationAddress.setText(address);


        Toast.makeText(this,"position " + latlng,Toast.LENGTH_LONG).show();



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void openMapActivity() {
        Intent intent = new Intent(this, MapActivity.class);
        intent.putExtra("Lat",latlng.latitude);
        intent.putExtra("Lng",latlng.longitude);

        intent.putExtra("Address",address);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
