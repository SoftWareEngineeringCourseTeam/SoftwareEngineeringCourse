package com.example.xdd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.xdd.R;
import com.example.xdd.Trip;
import com.example.xdd.TripAdapter;

import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {
    private List<Trip>tripList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_main);
        initTrips();
        TripAdapter adapter=new TripAdapter(FriendsActivity.this,R.layout.friends,tripList);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

       listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Intent intent=new Intent(FriendsActivity.this,MsgActivity.class);
                startActivity(intent);
                //Trip trip=tripList.get(position);
                //Toast.makeText(TripMainActivity.this,trip.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_friends,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(FriendsActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            case R.id.add_friends:
                Toast.makeText(this,"抱歉，暂无好友可添加",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }


    private void initTrips(){

        Trip trip1=new Trip("张伟","最近留言：你好，我是张伟很高兴认识你，以后请多多指教，希望能够帮上你！",R.drawable.friend1);
        tripList.add(trip1);
        Trip trip2=new Trip("李强","最近留言：你好，我是李强，听说你们武汉周黑鸭不错，帮我买点呗，多谢了！",R.drawable.friend2);
        tripList.add(trip2);
        Trip trip3=new Trip("赵简","最近留言：你好，我是赵简，想找你帮我去群星城配副眼镜，我等下把检查单发给你！",R.drawable.friend3);
        tripList.add(trip3);
        Trip trip4=new Trip("李珍","最近留言:你好，我是李珍，周黑鸭帮我买点，过年带点武汉特产回去！",R.drawable.friend4);
        tripList.add(trip4);
        Trip trip5=new Trip("刘华","最近留言：你好，我是刘华，很高兴认识你，希望以后我们相互帮助！",R.drawable.friend5);
        tripList.add(trip5);
        Trip trip6=new Trip("张洁","最近留言：你好，很高兴认识你，以后多多帮助！",R.drawable.friend6);
        tripList.add(trip6);
        Trip trip7=new Trip("罗月","最近留言:：你好，很高兴认识你，以后多多帮助！",R.drawable.friend7);
        tripList.add(trip7);
        Trip trip8=new Trip("周丽","最近留言:无",R.drawable.friend8);
        tripList.add(trip8);


    }
}