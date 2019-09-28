package com.example.activity2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Hello3 extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "Hello3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello3);
        setupClicks();
        Log.d(TAG,"onCreate");

    }
    public void onClick(View view){
        Intent intent;
        if(view.getId()==R.id.button1){
            intent=new Intent(Hello3.this,Hello1.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.button2){
            intent=new Intent(Hello3.this,Hello2.class);
            startActivity(intent);
        }
        if(view.getId()==R.id.button3){
            intent=new Intent(Hello3.this,Hello3.class);
            startActivity(intent);
        }
    }

    public void setupClicks(){
        Button button;
        button=(Button)findViewById(R.id.button1);
        button.setOnClickListener(this);
        button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(this);
        button=(Button)findViewById(R.id.button3);
        button.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume() ;
        Log.d(TAG,"onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy()");
    }

    @Override
    protected void onRestart() {
        super.onRestart() ;
        Log.d(TAG,"onRestart()");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
