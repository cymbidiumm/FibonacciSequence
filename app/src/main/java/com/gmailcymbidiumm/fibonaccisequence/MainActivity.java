package com.gmailcymbidiumm.fibonaccisequence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigInteger;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText typeNumberEditText;
    private Button getSequenceButton;
    private Button resetButton;
    private TextView textView;

    private AnimationDrawable anim1;
    private AnimationDrawable anim2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        typeNumberEditText = (EditText) findViewById(R.id.typeNumberEditText);
        getSequenceButton = (Button)findViewById(R.id.getSequenceButton);
        resetButton = (Button)findViewById(R.id.resetButton);
        textView = (TextView)findViewById(R.id.textView);

        getSequenceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(fibonacci(Integer.parseInt(typeNumberEditText.getText().toString())));
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                textView.setText("");
                typeNumberEditText.setText("");
            }
        });


        anim1= (AnimationDrawable)getSequenceButton.getBackground();
        anim1.setEnterFadeDuration(2300);
        anim1.setExitFadeDuration(2300);

        anim2 = (AnimationDrawable)resetButton.getBackground();
        anim2.setEnterFadeDuration(2800);
        anim2.setExitFadeDuration(2800);


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
    }

    private String fibonacci(int n){
        String text = "";
        ArrayList<BigInteger> fibo = new ArrayList<>();
        BigInteger first = new BigInteger("0");
        BigInteger second = new BigInteger("1");
        fibo.add(first);
        fibo.add(second);
        for(int i = 1; i<n; i++){
            fibo.add(fibo.get(i).add(fibo.get(i-1)));
        }
        for(int i = 1; i <= n; i++){
            text = text + i + ". " + fibo.get(i) + "\n" + "\n" ;
        }

        return text;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.action_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( @NonNull MenuItem item) {

        int id = item.getItemId();

        if(id == R.id.item1){

            Intent intent = new Intent(MainActivity.this,FibonacciFunFacts_activity.class);
            startActivity(intent);

            return true;
        } else
        if (id == R.id.item2){

            Intent intent = new Intent(MainActivity.this,FibonacciCalendar_activity.class);
            startActivity(intent);

            return true;
        }



        switch(item.getItemId()){
            case R.id.item1:
                Toast.makeText(this,"Item 1 selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item2:
                Toast.makeText(this,"Item 2 selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subitem1:
                Toast.makeText(this,"Subitem 1 selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subitem2:
                Toast.makeText(this,"Subitem 2 selected",Toast.LENGTH_SHORT).show();
                return true;

            case R.id.subitem3:
                Toast.makeText(this,"Subitem 3 selected",Toast.LENGTH_SHORT).show();
                return true;
            default:

                return super.onOptionsItemSelected(item);

        }
    }


}
