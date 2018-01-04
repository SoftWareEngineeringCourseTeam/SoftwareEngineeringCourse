package com.example.xdd.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapView;
import com.example.xdd.R;

public class DetailActivity extends AppCompatActivity {
    private MapView mapView;

    private BaiduMap baiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button button = (Button) findViewById(R.id.button);
       // mapView = (MapView) findViewById(R.id.bmapView_detail);
      //  baiduMap = mapView.getMap();
        //mapView.showZoomControls(false);//将地图放大缩小设为不可见
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);
                dialog.setTitle("投诉注意事项");
                dialog.setMessage("投诉请进入官网或者联系GAT团队QQ");
                dialog.setCancelable(true);
                dialog.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                dialog.show();

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(DetailActivity.this, TripMainActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 地图的周期
     */
  /*  @Override

    protected void onResume() {

        super.onResume();

        mapView.onResume();

    }


    @Override

    protected void onPause() {

        super.onPause();

        mapView.onPause();

    }


    @Override

    protected void onDestroy() {

        super.onDestroy();
        mapView.onDestroy();

        baiduMap.setMyLocationEnabled(false);

    }*/
}