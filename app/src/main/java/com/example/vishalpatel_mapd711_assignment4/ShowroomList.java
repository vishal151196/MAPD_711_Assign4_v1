package com.example.vishalpatel_mapd711_assignment4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShowroomList extends AppCompatActivity {
    ListView showroom_listview;
    ArrayAdapter<String> adapter;
    private String showroom_array[] = getResources().getStringArray(R.array.showroom_list);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showroom_list);

        showroom_listview = findViewById(R.id.showroom_list);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, showroom_array);
        showroom_listview.setAdapter(adapter);

        showroom_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "item: " + position,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
