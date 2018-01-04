package com.example.xdd.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.example.xdd.R;

public class BalanceActivity extends AppCompatActivity {
    private LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.balance);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_balance);
        mLinearLayout=(LinearLayout)findViewById(R.id.chongzhi);
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch (v.getId()){
                    case R.id.chongzhi:
                        AlertDialog.Builder dialog=new AlertDialog.Builder(BalanceActivity.this);
                        dialog.setTitle("充值提示");
                        dialog.setMessage("小额充值请进官网，大额充值请联系GAT团队QQ");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("好的",new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog,int which){}
                        });
                        dialog.show();
                        break;
                    default:
                        break;
                }
            }
        });
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar_balance,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(BalanceActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }
}
