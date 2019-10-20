package com.example.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupClicks();
    }

    public void onClick(View view){
        Intent intent;
        if(view.getId()==R.id.button1){
             intent=new Intent(Intent.ACTION_VIEW);
             intent.setData(Uri.parse("http://www.baidu.com"));
            startActivity(intent);
        }
        if(view.getId()==R.id.button2){
            intent=new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:10086"));
            startActivity(intent);
        }
        if(view.getId()==R.id.button3){
            intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:"));
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

}
