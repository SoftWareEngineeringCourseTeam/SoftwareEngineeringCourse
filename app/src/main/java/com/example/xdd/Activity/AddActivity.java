package com.example.xdd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.xdd.R;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.add);
        super.onCreate(savedInstanceState);
        FloatingActionButton fab=(FloatingActionButton)findViewById(R.id.fab);
        FloatingActionButton fab2=(FloatingActionButton)findViewById(R.id.fab2);
        FloatingActionButton fab3=(FloatingActionButton)findViewById(R.id.fab3);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(AddActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent=new Intent(AddActivity.this,Ask_for_help_Activity.class);
                startActivity(intent);
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
               Intent intent2=new Intent(AddActivity.this,HelpOthersActivity.class);
                startActivity(intent2);
            }
        });

    }
}
