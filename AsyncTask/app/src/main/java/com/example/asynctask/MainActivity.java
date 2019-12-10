package com.example.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    ProgressDialog progressDialog;
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button=findViewById(R.id.button);
        text=findViewById(R.id.text);
        progressBar=findViewById(R.id.progress);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog=new ProgressDialog(MainActivity.this);
                new DownloadTask().execute();
            }
        });
    }
    class DownloadTask extends AsyncTask<Void,Integer,Boolean>{
        int i=0;
        Random ra =new Random();
        int n=ra.nextInt(10)+1;
        @Override
        protected Boolean doInBackground(Void... voids) {
            try{
                while (true) {
                    i++;
                    publishProgress(i);
                   if(i>=100){
                       break;
                   }
                   Thread.sleep(100);
                }
            }catch (Exception e){
                return false;
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
            progressDialog.setMessage("Downloaded"+values[0]);
        }


        @Override
        protected void onPreExecute() {
           text.setText(Thread.currentThread().getId()+"加载中"+n);
           progressDialog.show();

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            text.setText(Thread.currentThread().getId()+"加载完毕"+n);
            progressDialog.dismiss();
            if(aBoolean){
                Toast.makeText(MainActivity.this,n+"Download succeeded",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this,"Download failed",Toast.LENGTH_SHORT).show();
            }
        }
    }


}

