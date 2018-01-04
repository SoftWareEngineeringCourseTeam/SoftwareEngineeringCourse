package com.example.xdd.Activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapPoi;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.OverlayOptions;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.core.SearchResult;
import com.baidu.mapapi.search.geocode.GeoCodeOption;
import com.baidu.mapapi.search.geocode.GeoCodeResult;
import com.baidu.mapapi.search.geocode.GeoCoder;
import com.baidu.mapapi.search.geocode.OnGetGeoCoderResultListener;
import com.baidu.mapapi.search.geocode.ReverseGeoCodeResult;
import com.example.xdd.Info;
import com.example.xdd.R;

import java.util.ArrayList;
import java.util.List;



public class MainActivity extends AppCompatActivity implements OnGetGeoCoderResultListener,SearchView.OnQueryTextListener {



    public LocationClient mLocationClient;



    private TextView positionText;



    private MapView mapView;
    //地图控件


    private BaiduMap baiduMap;

    private   GeoCoder mSearch = null;
    //最新一次的经纬度

    private double mCurrentLantitude;

    private double mCurrentLongitude;

    private boolean isFirstLocate = true;


    private DrawerLayout mDrawerLayout;

    private RelativeLayout mMarkerInfoLy;

    private ImageView mImageView;

    private BitmapDescriptor mIconMaker;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        mLocationClient = new LocationClient(getApplicationContext());

        mLocationClient.registerLocationListener(new MyLocationListener());

        SDKInitializer.initialize(getApplicationContext());

        setContentView(R.layout.activity_main);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);//获取toolbr

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add2);

        FloatingActionButton fab2=(FloatingActionButton)findViewById(R.id.friends);//获取我的好友悬浮按钮

        FloatingActionButton fab3=(FloatingActionButton)findViewById(R.id.my_location);//获取我的位置悬浮按钮

        mIconMaker = BitmapDescriptorFactory.fromResource(R.drawable.icon_gcoding);

        setSupportActionBar(toolbar);

        mDrawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);

        mMarkerInfoLy = (RelativeLayout) findViewById(R.id.marker_info);

        mImageView = (ImageView)findViewById(R.id.info_img);

        NavigationView navView=(NavigationView)findViewById(R.id.nav_view);

        mapView = (MapView) findViewById(R.id.bmapView);

        baiduMap = mapView.getMap();

        baiduMap.setMyLocationEnabled(true);
        // 初始化搜索模块，注册事件监听
        mSearch = GeoCoder.newInstance();

        mSearch.setOnGetGeoCodeResultListener(this);

        positionText = (TextView) findViewById(R.id.position_text_view);

//        mapView.showZoomControls(false);//将地图放大缩小设为不可见
        /*//定义Maker坐标点
        LatLng point = new LatLng(39.991002,116.328896);
//构建Marker图标
        BitmapDescriptor bitmap = BitmapDescriptorFactory
                .fromResource(R.drawable.icon_marka);
//构建MarkerOption，用于在地图上添加Marker
        final OverlayOptions option = new MarkerOptions()
                .position(point)
                .icon(bitmap);
//在地图上添加Marker，并显示
        baiduMap.addOverlay(option);*/
        addInfosOverlay(Info.infos);

        baiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                // 获得marker中的数据
                Info info = (Info) marker.getExtraInfo().get("info");
                // 根据商家信息为详细信息布局设置信息
                mMarkerInfoLy.setVisibility(View.VISIBLE);
                popupInfo(mMarkerInfoLy, info);
                return true;
            }
        });
        InitMapClick();
        mMarkerInfoLy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, PersonalActivity.class);
                startActivity(intent);
            }
        });
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, PersonalActivity.class);
                startActivity(intent);
            }
        });

        List<String> permissionList = new ArrayList<>();
       //获取权限
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);

        }

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {

            permissionList.add(Manifest.permission.READ_PHONE_STATE);

        }

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);

        }

        if (!permissionList.isEmpty()) {

            String [] permissions = permissionList.toArray(new String[permissionList.size()]);

            ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);

        } else {

            requestLocation();

        }
        ActionBar actionBar = getSupportActionBar();//得到ActionBar的实例

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);                            //使ActionBar可见
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);                    //使ActionBar使用指定图标
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivity(intent);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, FriendsActivity.class);
                startActivity(intent);
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               updateMyLocation();
            }
        });

        //侧滑界面选择
        navView.setCheckedItem(R.id.nav4);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav4:
                        Intent intent4 = new Intent(MainActivity.this, SecondLayoutActivity.class);
                        startActivity(intent4);
                        break;

                    case R.id.nav1:
                        Intent intent1 = new Intent(MainActivity.this, BalanceActivity.class);
                        startActivity(intent1);
                        break;

                    case R.id.nav2:
                        Intent intent2 = new Intent(MainActivity.this, TripMainActivity.class);
                        startActivity(intent2);
                        break;

                    case R.id.nav3:
                        Intent intent3=new Intent(Intent.ACTION_SEND);
                        intent3.setType("image/*");
                        intent3.putExtra(Intent.EXTRA_SUBJECT, "Share");
                        intent3.putExtra(Intent.EXTRA_TEXT, "I have successfully share my message through my app");
                        intent3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(Intent.createChooser(intent3, getTitle()));
                        break;
                }
                return true;
            }
        });
    }
   // 获取toolbar
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.item_search).getActionView();
        searchView.setQueryHint("请输入地点");
        searchView.setOnQueryTextListener(this);
        return true;
    }
   @Override
    public boolean onQueryTextSubmit(String query) {
       // 实际应用中应该在该方法内执行实际查询  
       //搜索城市+关键字 
           mSearch.geocode(new GeoCodeOption().city(
                   query).address(query));
       // 此处仅使用Toast显示用户输入的查询内容
       Toast.makeText(this,"你输入的地址是:" + query,Toast.LENGTH_SHORT).show();
             return false;
            }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
    /*
     * 百度地图点击事件将InfoWindow隐藏
     */
    private void InitMapClick() {
        baiduMap.setOnMapClickListener(new BaiduMap.OnMapClickListener() {

            @Override
            public boolean onMapPoiClick(MapPoi arg0) {
                // TODO Auto-generated method stub
                return false;
            }

            @Override
            public void onMapClick(LatLng arg0) {
                mMarkerInfoLy.setVisibility(View.GONE);
                baiduMap.hideInfoWindow();
            }
        });
    }

    //获取自己的位置
    private void navigateTo(BDLocation location) {

        if (isFirstLocate) {

            Toast.makeText(this, "我的位置 " + location.getAddrStr(), Toast.LENGTH_SHORT).show();

            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());

            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);

            baiduMap.animateMapStatus(update);

            update = MapStatusUpdateFactory.zoomTo(16f);

            baiduMap.animateMapStatus(update);


            isFirstLocate = false;

        }

        MyLocationData.Builder locationBuilder = new MyLocationData.

                Builder();

        locationBuilder.latitude(location.getLatitude());

        locationBuilder.longitude(location.getLongitude());

        MyLocationData locationData = locationBuilder.build();

        baiduMap.setMyLocationData(locationData);

    }
    //更新自己的位置
    private void updateMyLocation() {
        LatLng ll = new LatLng(mCurrentLantitude,mCurrentLongitude);
         MapStatusUpdate u = MapStatusUpdateFactory.newLatLng(ll);
         baiduMap.animateMapStatus(u);
    }

   //程序的周期

    private void requestLocation() {

        initLocation();

        mLocationClient.start();

    }



    private void initLocation(){

        LocationClientOption option = new LocationClientOption();

        option.setScanSpan(5000);

        option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);

        option.setIsNeedAddress(true);

        option.setOpenGps(true);

        mLocationClient.setLocOption(option);

    }
    @Override

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        switch (requestCode) {

            case 1:

                if (grantResults.length > 0) {

                    for (int result : grantResults) {

                        if (result != PackageManager.PERMISSION_GRANTED) {

                            Toast.makeText(this, "必须同意所有权限才能使用本程序", Toast.LENGTH_SHORT).show();

                            finish();

                            return;

                        }

                    }

                    requestLocation();

                } else {

                    Toast.makeText(this, "发生未知错误", Toast.LENGTH_SHORT).show();

                    finish();

                }

                break;

            default:

        }

    }
    //头部菜单
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item_information:
                Intent intent1=new Intent(MainActivity.this,InformationActivity.class);
                startActivity(intent1);
                break;//点击消息界面
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;//打开侧滑界面
            default:
        }
        return true;
    }

    /**
     * 对检索事件的监听
     */
    @Override
    public void onGetGeoCodeResult(GeoCodeResult result) {
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
            Toast.makeText(MainActivity.this, "抱歉，未能找到结果", Toast.LENGTH_LONG)
                    .show();
            return;
        }
       // baiduMap.clear();
        /*baiduMap.addOverlay(new MarkerOptions().position(result.getLocation())
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.icon_gcoding)));*/
        baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
                .getLocation()));
        String strInfo = String.format("纬度：%f 经度：%f",
                result.getLocation().latitude, result.getLocation().longitude);
        Toast.makeText(MainActivity.this, strInfo, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onGetReverseGeoCodeResult(ReverseGeoCodeResult result) {
        if (result == null || result.error != SearchResult.ERRORNO.NO_ERROR) {
            Toast.makeText(MainActivity.this, "抱歉，未能找到结果", Toast.LENGTH_LONG)
                    .show();
            return;
        }
        // baiduMap.clear();
      /*  baiduMap.addOverlay(new MarkerOptions().position(result.getLocation())
                .icon(BitmapDescriptorFactory
                        .fromResource(R.drawable.icon_gcoding)));*/
        baiduMap.setMapStatus(MapStatusUpdateFactory.newLatLng(result
                .getLocation()));
        Toast.makeText(MainActivity.this, result.getAddress(),
                Toast.LENGTH_LONG).show();

    }
    /**
     * 根据info为布局上的控件设置信息
     *
     */
    protected void popupInfo(RelativeLayout mMarkerLy, Info info)
    {
        ViewHolder viewHolder = null;
        if (mMarkerLy.getTag() == null)
        {
            viewHolder = new ViewHolder();
            viewHolder.infoImg = (ImageView) mMarkerLy
                    .findViewById(R.id.info_img);
            viewHolder.infoName = (TextView) mMarkerLy
                    .findViewById(R.id.info_name);
            viewHolder.infoContent = (TextView) mMarkerLy
                    .findViewById(R.id.info_content);
            viewHolder.infoCredit = (TextView) mMarkerLy
                    .findViewById(R.id.info_credit);

            mMarkerLy.setTag(viewHolder);
        }
        viewHolder = (ViewHolder) mMarkerLy.getTag();
        viewHolder.infoImg.setImageResource(info.getImgId());
        viewHolder.infoContent.setText(info.getContent());
        viewHolder.infoName.setText(info.getName());
        viewHolder.infoCredit.setText(info.getCredit());
    }


    /**
     * 复用弹出面板mMarkerLy的控件
     *
     * @author zhy
     *
     */
    private class ViewHolder
    {
        ImageView infoImg;
        TextView infoName;
        TextView infoContent;
        TextView infoCredit;
    }
    /**
     * 为地图添加marker
     */
    public void addInfosOverlay(List<Info> infos)
    {
       baiduMap.clear();
        LatLng latLng = null;
        OverlayOptions overlayOptions = null;
        Marker marker = null;
        for (Info info : infos)
        {
            // 位置
            latLng = new LatLng(info.getLatitude(), info.getLongitude());
            // 图标
            overlayOptions = new MarkerOptions().position(latLng)
                    .icon(mIconMaker).zIndex(5);
            marker = (Marker) (baiduMap.addOverlay(overlayOptions));
            Bundle bundle = new Bundle();
            bundle.putSerializable("info", info);
            marker.setExtraInfo(bundle);
        }
    }





    public class MyLocationListener implements BDLocationListener {

        @Override

        public void onReceiveLocation(BDLocation location) {

            StringBuilder currentPosition = new StringBuilder();

            if (location.getLocType() == BDLocation.TypeGpsLocation) {

                currentPosition.append("GPS");

            } else if (location.getLocType() == BDLocation.TypeNetWorkLocation) {

                currentPosition.append("网络");
                mCurrentLantitude = location.getLatitude();
                mCurrentLongitude = location.getLongitude();
            }

            positionText.setText(currentPosition);

            if (location.getLocType() == BDLocation.TypeGpsLocation

                    || location.getLocType() == BDLocation.TypeNetWorkLocation) {

                navigateTo(location);

            }

        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }


    }

    /**
     * 地图的周期
     */
    @Override

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

        mLocationClient.stop();

        mapView.onDestroy();

        baiduMap.setMyLocationEnabled(false);

    }



}