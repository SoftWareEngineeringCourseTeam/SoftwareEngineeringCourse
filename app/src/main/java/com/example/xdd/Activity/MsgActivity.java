package com.example.xdd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.xdd.Msg;
import com.example.xdd.MsgAdapter;
import com.example.xdd.R;

import java.util.ArrayList;
import java.util.List;

public class MsgActivity extends AppCompatActivity {
    private List<Msg> msgList = new ArrayList<Msg>();



    private EditText inputText;



    private TextView send;



    private RecyclerView msgRecyclerView;



    private MsgAdapter adapter;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_msg);

        initMsgs(); // 初始化消息数据

        inputText = (EditText) findViewById(R.id.input_text);

        send = (TextView) findViewById(R.id.send);

        msgRecyclerView = (RecyclerView) findViewById(R.id.msg_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        msgRecyclerView.setLayoutManager(layoutManager);

        adapter = new MsgAdapter(msgList);

        msgRecyclerView.setAdapter(adapter);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String content = inputText.getText().toString();

                if (!"".equals(content)) {

                    Msg msg = new Msg(content, Msg.TYPE_SENT);

                    msgList.add(msg);

                    adapter.notifyItemInserted(msgList.size() - 1); // 当有新消息时，刷新ListView中的显示

                    msgRecyclerView.scrollToPosition(msgList.size() - 1); // 将ListView定位到最后一行

                    inputText.setText(""); // 清空输入框中的内容

                }

            }

        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }





    private void initMsgs() {

        Msg msg1 = new Msg("请问你是住在武汉徐东旁边吗？", Msg.TYPE_RECEIVED);

        msgList.add(msg1);

        Msg msg2 = new Msg("对的，你有什么需求吗？", Msg.TYPE_SENT);

        msgList.add(msg2);

        Msg msg3 = new Msg("能帮我去睛姿配服眼镜？ ", Msg.TYPE_RECEIVED);

        msgList.add(msg3);

        Msg msg4 = new Msg("可以的，没问题", Msg.TYPE_SENT);

        msgList.add(msg4);
        Msg msg5 =new Msg("我把我在医院的检查单给你，她们会用日本全自动仪器配好",Msg.TYPE_RECEIVED);
        msgList.add(msg5);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(MsgActivity.this,PersonalActivity.class);
                startActivity(intent);
                break;
            default:
        }
        return true;
    }



}

