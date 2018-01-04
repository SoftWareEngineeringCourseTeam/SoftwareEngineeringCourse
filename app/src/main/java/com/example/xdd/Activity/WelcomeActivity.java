package com.example.xdd.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.xdd.R;

public class WelcomeActivity extends BaseActivity{

    private boolean isFirst;
        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);
            Handler x = new Handler();
            x.postDelayed(new splashhandler(), 4000);
        }
        class splashhandler implements Runnable{
            public void run() {
                startActivity(new Intent(getApplication(),LoginActivity.class));
                WelcomeActivity.this.finish();
            }
        }
}

