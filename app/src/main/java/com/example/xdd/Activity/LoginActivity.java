package com.example.xdd.Activity;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xdd.R;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

      private EditText uname = null;
      private EditText upswd = null;
      private CheckBox checkboxButton = null;
      private Button login = null;
      private TextView register;
      SharedPreferences sp = null;
    @Override
    protected void onCreate(Bundle saveInstanceState) {

        super.onCreate(saveInstanceState);

        setContentView(R.layout.activity_login);
        sp = this.getSharedPreferences("userinfo", Context.MODE_PRIVATE);
        init();
        register=(TextView)findViewById(R.id.textview_register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

 }

         public void init()
         {
             uname = (EditText) findViewById(R.id.login_edit_account);
             upswd = (EditText) findViewById(R.id.login_edit_pwd);
             checkboxButton = (CheckBox) findViewById(R.id.Login_Remember);
             login = (Button) findViewById(R.id.login_btn_login);
             if (sp.getBoolean("checkboxBoolean", false))
             {
                 uname.setText(sp.getString("uname", null));
                 upswd.setText(sp.getString("upswd", null));
                 checkboxButton.setChecked(true);
             }
             login.setOnClickListener(this);
         }

         @Override
         public void onClick(View v) {
             if (v == login){
                 String name = uname.getText().toString();
                 String pswd = upswd.getText().toString();
                 if(name.trim().equals("")){
                     Toast.makeText(this, "请您输入用户名！", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 if(pswd.trim().equals("")){
                     Toast.makeText(this,"请您输入密码！", Toast.LENGTH_SHORT).show();
                     return;
                 }
                 boolean CheckBoxLogin = checkboxButton.isChecked();
                 if (CheckBoxLogin)
                 {
                     SharedPreferences.Editor editor = sp.edit();
                     editor.putString("uname", name);
                     editor.putString("upswd", pswd);
                     editor.putBoolean("checkboxBoolean", true);
                     editor.commit();
                 }
                 else
                     {
                         SharedPreferences.Editor editor = sp.edit();
                         editor.putString("uname", null);
                         editor.putString("upswd", null);
                         editor.putBoolean("checkboxBoolean", false);
                         editor.commit();
                     }
                     //Intent跳转
                 Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                 startActivity(intent);
                 finish();
             }
         }
}


