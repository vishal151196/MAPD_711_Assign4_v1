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
    Button locateMap;
    String title;
    String address = "";
    LatLng latlng;

    //Tommy Hilfier's
    String tommy_ad_1 = "1800 Sheppard Ave E, North York, ON M2J 5A7 · (416) 967-1111";
    String tommy_ad_2 = "900 Dufferin St, Toronto, ON M6H 4A9";
    String tommy_ad_3 = "300 Borough Dr, Scarborough, ON M1P 4P5";
    String tommy_ad_4 = "3499 Wyecroft Rd, Oakville, ON L6L 0B6 - (905) 827-4523";

    ArrayList<String> ListTommyHilfiger = new ArrayList<String>(Arrays.asList(tommy_ad_1,tommy_ad_2,tommy_ad_3,tommy_ad_4));


    LatLng tommy_lat_lng_1 =  new LatLng(43.777748, -79.344498);
    LatLng tommy_lat_lng_2 =  new LatLng(43.655899, -79.433769);
    LatLng tommy_lat_lng_3 =  new LatLng(43.750198, -79.267273);
    LatLng tommy_lat_lng_4 =  new LatLng(43.398476, -79.750427);

    ArrayList<LatLng> ListTommyHilfigerLatLng = new ArrayList<LatLng>(Arrays.asList(tommy_lat_lng_1,tommy_lat_lng_2,tommy_lat_lng_3,tommy_lat_lng_4));

    //Hudson Bay's
    String Hudson_bay_ad_1 = "6500 Yonge St, North York, ON M2M 3X4";
    String Hudson_bay_ad_2 = "1 Eglinton Square, Toronto, ON M1L 2K2";
    String Hudson_bay_ad_3 = "300 Borough Dr, Scarborough, ON M1P 4P5";
    String Hudson_bay_ad_4 = "Oakville Place, 240 Leighland Ave, Oakville, ON L6H 3H6";
    ArrayList<String> ListHudsonBay = new ArrayList<String>(Arrays.asList(Hudson_bay_ad_1,Hudson_bay_ad_2,Hudson_bay_ad_3,Hudson_bay_ad_4));

    LatLng Hb_lat_lng_1 = new LatLng(43.796323,-79.420702);
    LatLng Hb_lat_lng_2 = new LatLng(43.723510,-79.300137);
    LatLng Hb_lat_lng_3 = new LatLng(43.750198,-79.267273);
    LatLng Hb_lat_lng_4 = new LatLng(43.460901,-79.687338);
    ArrayList<LatLng> ListHudsonBayLatLng = new ArrayList<LatLng>(Arrays.asList(Hb_lat_lng_1,Hb_lat_lng_2,Hb_lat_lng_3,Hb_lat_lng_4));

    //Reitmans's
    String reitmans_ad_1 = "4841 Yonge St Unit 102, North York, ON M2N 5X2";
    String reitmans_ad_2 = "218 Yonge St, Toronto, ON M5B 2H6";
    String reitmans_ad_3 = "1900 Eglinton Ave E, Scarborough, ON M1L 2L9";
    String reitmans_ad_4 = "202 Oak Walk Dr, Oakville, ON L6H 0H4";
    ArrayList<String> ListReitmans = new ArrayList<String>(Arrays.asList(reitmans_ad_1,reitmans_ad_2,reitmans_ad_3,reitmans_ad_4));

    LatLng reitmans_lat_lng_1 = new LatLng(43.760099,-79.410495);
    LatLng reitmans_lat_lng_2 = new LatLng(43.653431,-79.380127);
    LatLng reitmans_lat_lng_3 = new LatLng(43.726639,-79.294067);
    LatLng reitmans_lat_lng_4 = new LatLng(43.482902,-79.721884);
    ArrayList<LatLng> ListReitmansLatLng = new ArrayList<LatLng>(Arrays.asList(reitmans_lat_lng_1,reitmans_lat_lng_2,reitmans_lat_lng_3,reitmans_lat_lng_4));

    //Root's
    String root_ad_1 = "3401 Dufferin St Unit 117, Toronto, ON M6A 2T9";
    String root_ad_2 = "2670 Yonge St, Toronto, ON M4P 2J5";
    String root_ad_3 = "1901 Eglinton Ave E Unit B2, Scarborough, ON M1L 2L6";
    String root_ad_4 = "240 Leighland Ave Unit 219, Oakville, ON L6H 3H6";
    ArrayList<String> ListRoot = new ArrayList<String>(Arrays.asList(root_ad_1,root_ad_2,root_ad_3,root_ad_4));

    LatLng root_lat_lng_1 = new LatLng(43.726208,-79.455129);
    LatLng root_lat_lng_2 = new LatLng(43.716160,-79.400570);
    LatLng root_lat_lng_3 = new LatLng(43.740844,-79.229080);
    LatLng root_lat_lng_4 = new LatLng(43.460901,-79.687338);
    ArrayList<LatLng> ListRootLatLng = new ArrayList<LatLng>(Arrays.asList(root_lat_lng_1,root_lat_lng_2,root_lat_lng_3,root_lat_lng_4));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_selector);

        titleShowroom = findViewById(R.id.titleShowroom);
        locationAddress = findViewById(R.id.locationAddress);
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

        if (title.equals("Tommy Hilfiger")){
            address = ListTommyHilfiger.get(position);
            latlng = ListTommyHilfigerLatLng.get(position);

        }
         if (title.equals("HUDSON BAY")){
            address = ListHudsonBay.get(position);
            latlng = ListHudsonBayLatLng.get(position);
        }
        if (title.equals("REITMANS")){
            address = ListReitmans.get(position);
            latlng = ListReitmansLatLng.get(position);
        }
        if (title.equals("ROOTS")){
            address = ListRoot.get(position);
            latlng = ListRootLatLng.get(position);
        }
        else{
            Toast.makeText(this,"Please select one of the available options !", Toast.LENGTH_SHORT).show();
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
