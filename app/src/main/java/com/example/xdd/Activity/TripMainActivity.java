package com.example.xdd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.xdd.R;
import com.example.xdd.Trip;
import com.example.xdd.TripAdapter;

import java.util.ArrayList;
import java.util.List;

public class TripMainActivity extends AppCompatActivity {
    private List<Trip> tripList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_main);
        initTrips();
        TripAdapter adapter=new TripAdapter(TripMainActivity.this,R.layout.trip,tripList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?>parent,View view,int position,long id){
                Intent intent=new Intent(TripMainActivity.this,DetailActivity.class);
                startActivity(intent);
                //Trip trip=tripList.get(position);
                //Toast.makeText(TripMainActivity.this,trip.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(TripMainActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }
    private void initTrips(){
        for(int i=0;i<3;i++){
            Trip trip1=new Trip("time:2017-6-20","订单状态:待完成\n订单任务:光谷广场购买周黑鸭",R.drawable.time_image7);
            tripList.add(trip1);
            Trip trip2=new Trip("time:2017-6-10","订单状态:已完成\n订单任务:群星城代配一副眼镜",R.drawable.time_image8);
            tripList.add(trip2);
            Trip trip3=new Trip("time:2017-6-5","订单状态:已完成\n订单任务:带本书去表弟家",R.drawable.time_image9);
            tripList.add(trip3);
            Trip trip4=new Trip("time:2017-5-20","订单状态:已完成\n订单任务:批发一箱草稿纸",R.drawable.time_image10);
            tripList.add(trip4);
        }
    }
}
