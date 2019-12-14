package com.gmailcymbidiumm.fibonaccisequence;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class FibonacciFunFacts_activity extends AppCompatActivity {

    private Button natureInfoBtn;
    private Button artInfoBtn;
    private Button mathInfoBtn;
    private AnimationDrawable anim1;
    private AnimationDrawable anim2;
    private AnimationDrawable anim3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci_fun_facts_activity);

        Toolbar toolbar = findViewById(R.id.toolbar);
        TextView toolbarTitle = findViewById(R.id.titleTextToolbar);
        toolbar.setTitle("");
        toolbarTitle.setText("FibonacciFunFacts");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        natureInfoBtn = (Button) findViewById(R.id.natureInfoBtn);
        artInfoBtn = (Button) findViewById(R.id.artInfoBtn);
        mathInfoBtn = (Button) findViewById(R.id.mathInfoBtn);


        anim1= (AnimationDrawable)natureInfoBtn.getBackground();
        anim1.setEnterFadeDuration(2300);
        anim1.setExitFadeDuration(2300);

        anim2 = (AnimationDrawable)artInfoBtn.getBackground();
        anim2.setEnterFadeDuration(2500);
        anim2.setExitFadeDuration(2500);

        anim3 = (AnimationDrawable)mathInfoBtn.getBackground();
        anim3.setEnterFadeDuration(2800);
        anim3.setExitFadeDuration(2800);
    }

    @Override
    protected void onResume(){
        super.onResume();
        if(anim1!=null && !anim1.isRunning()){
            anim1.start();
        }

        if(anim2!=null && !anim2.isRunning()){
            anim2.start();
        }

        if(anim3!=null && !anim3.isRunning()){
            anim3.start();
        }
    }

    @Override
    protected void onPause(){
        super.onPause();
        if(anim1!=null && anim1.isRunning()){
            anim1.stop();
        }

        if(anim2!=null && anim2.isRunning()){
            anim2.stop();
        }

        if(anim3!=null && anim3.isRunning()){
            anim3.stop();
        }
    }
}
