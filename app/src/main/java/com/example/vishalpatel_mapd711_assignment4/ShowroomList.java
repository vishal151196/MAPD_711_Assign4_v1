package com.example.vishalpatel_mapd711_assignment4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class ShowroomList extends AppCompatActivity {
    ListView showroom_listview;
    public String[] showroom_array = getResources().getStringArray(R.array.showroom_list);


    // storing showroom logo images in an array
    int images[] = {R.drawable.tommy_hilfiger,R.drawable.reitmans,R.drawable.hudson_bay,R.drawable.roots};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showroom_list);

        showroom_listview = findViewById(R.id.showroom_list);
        CustomAdaper customAdaper = new CustomAdaper();
        showroom_listview.setAdapter(customAdaper);
//        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, showroom_array);
//        showroom_listview.setAdapter(adapter);

        showroom_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(),ShowroomLocation.class);
                startActivity(intent);
            }
        });

    }
    public class CustomAdaper extends BaseAdapter{

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {

            view =  getLayoutInflater().inflate(R.layout.customlayout,null);

            ImageView imageView = view.findViewById(R.id.showroom_logo);
            TextView textView = view.findViewById(R.id.showroom_title);

            imageView.setImageResource(images[i]);
            textView.setText(showroom_array[i]);
            return view;
        }
    }
}
