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

public class InformationActivity extends AppCompatActivity {

    private List<Trip> tripList=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trip_main);
        initTrips();
        TripAdapter adapter=new TripAdapter(InformationActivity.this,R.layout.activity_information,tripList);
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
                Intent intent=new Intent(InformationActivity.this,PersonalActivity.class);
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
                Intent intent = new Intent(InformationActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }


    private void initTrips(){

        Trip trip1=new Trip("用户:老郭\n类型:请求帮助\n详细地点:武汉市汉口中山公园","详细信息" +
                ":请去中山公园的朋友帮我买一个孙中山纪念像！",R.drawable.guobiting);
        tripList.add(trip1);
        Trip trip2=new Trip("用户:大俊\n类型:帮助他人\n详细地点：武汉市江汉路","详细信息" +
                ":武汉地区的朋友们，你们有福了，我可以帮你们买江汉路附近的美食",R.drawable.linjunjie);
        tripList.add(trip2);
        Trip trip3=new Trip("用户:小谦\n类型:请求帮助\n详细地点：武汉市武昌群星城","详细信息" +
                ":请群星城附近的朋友们帮我去群星城睛姿配一副眼镜，等下把检查单发给你",R.drawable.xuezhiqian);
        tripList.add(trip3);
        Trip trip4=new Trip("用户:胖迪\n类型：请求帮助\n详细地点:北京市鼓楼","详细信息:请北京" +
                "鼓楼附近的朋友帮我买个纪念品貔貅",R.drawable.dilireba);
        tripList.add(trip4);
        Trip trip5=new Trip("用户:阿萌\n类型:帮助他人\n地点：全国","详细信息;" +
                "全国的朋友们我可以帮你们买北京的特产哦",R.drawable.xiaoyan);
        tripList.add(trip5);
        Trip trip6=new Trip("用户:小蕾\n类型:帮助他人\n详细地点:北京市故宫博物馆","详细信息:北京地区的小伙伴们" +
                "我可以帮你们代买故宫的门票哦",R.drawable.alalei);
        tripList.add(trip6);
        Trip trip7=new Trip("用户:阿信\n类型:帮助他人\n地点：成都市宽窄巷子","详细信息;" +
                "成都的朋友有福了，我可以帮你们买正宗的火锅底料",R.drawable.axin);
        tripList.add(trip7);
        Trip trip8=new Trip("用户:阿杰\n类型:请求帮助\n详细地点:成都市杜甫草堂","详细信息:" +
                "请杜甫草堂附近的朋友们帮我买件杜甫纪念品",R.drawable.zhoujielun);
        tripList.add(trip8);
        Trip trip9=new Trip("用户:小陈\n类型:请求帮助\n详细地点:成都市武侯祠","详细信息:请武侯祠附近的朋友" +
                "们帮我买一张武侯祠的门票，多谢了",R.drawable.chenduling);
        tripList.add(trip9);


    }
}


