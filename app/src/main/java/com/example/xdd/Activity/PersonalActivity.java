package com.example.xdd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xdd.R;

public class PersonalActivity extends AppCompatActivity {
    private TextView send1;
    private TextView help;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        send1=(TextView)findViewById(R.id.faxiaoxi);
        help=(TextView)findViewById(R.id.help);
        send1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(PersonalActivity.this,MsgActivity.class);
                startActivity(intent1);
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PersonalActivity.this,"成功接受任务",Toast.LENGTH_SHORT).show();
            }
        });
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_person,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_friends:
                Toast.makeText(this,"好友添加成功",Toast.LENGTH_SHORT).show();
                break;
            case android.R.id.home:
                Intent intent=new Intent(PersonalActivity.this,MainActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }
}
