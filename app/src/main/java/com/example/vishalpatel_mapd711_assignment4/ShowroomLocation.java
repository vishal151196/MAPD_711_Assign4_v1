package com.example.vishalpatel_mapd711_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ShowroomLocation extends AppCompatActivity {

    ListView showroom_location_listview;
    ArrayAdapter<String> adapter;
    private String[] showroom_location_array;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showroom_location);

        showroom_location_array = getResources().getStringArray(R.array.showroom_location);

        showroom_location_listview = findViewById(R.id.showroom_location_list);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, showroom_location_array);
        showroom_location_listview.setAdapter(adapter);

        showroom_location_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),Map.class);
                startActivity(intent);
            }
        });


    }
}
