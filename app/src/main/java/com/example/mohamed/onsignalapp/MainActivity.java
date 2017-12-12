package com.example.mohamed.onsignalapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mohamed.onsignalapp.oneSignal.SendOnSignalNotification;
import com.example.mohamed.onsignalapp.oneSignal.model.ButtonData;
import com.example.mohamed.onsignalapp.oneSignal.model.Content;
import com.example.mohamed.onsignalapp.oneSignal.model.Data;
import com.example.mohamed.onsignalapp.oneSignal.model.Heading;
import com.example.mohamed.onsignalapp.oneSignal.model.NotificationFilter;

import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity  implements Result.resultLisinter{
    private TextView textView;
    private Button send;
 //   List<String> filter= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        filter.add("{\"field\":\"last_session\" , \"relation\": \">\" , \"value\":\"1000\"}");
//       // filter.add("{\"field\":\"country\" , \"relation\":\"=\" ,\"value\":\"EG\"}");
        textView=findViewById(R.id.textview);
        send=findViewById(R.id.send);
        Result.getInstance().setLisner(this);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    SendOnSignalNotification build = new SendOnSignalNotification.
                            SendOnSignalNotificationBuilder("OTU3Y2U1NTQtMDEzYi00ZTg0LTk1NjctNmJjN2MzN2QyNjli", "f9c26313-895c-433d-a695-5ab0ca4cf89e")
                            .setAddinalData(new Data("name", "ahmed"), new Data("age", "25"))
                            .setbig_picture("http://i.imgur.com/DKw1J2F.gif")
                            .setButtons(new ButtonData("1", "confirm"), new ButtonData("2", "cancel"))
                            .setFilter(new NotificationFilter("last_session",">","10"))
                            .setUrl("http://www.google.com")
                            .setContents(new Content("en", "i am do this "))
                            .setHeadings(new Heading("en", "hello "))
                            .build(new SendOnSignalNotification.response() {
                                @Override
                                public void onResponse(String response) {
                                    Log.d("myresponse", response + "");
                                }

                                @Override
                                public void onError(String error) {
                                    Log.d("error", error + "");

                                }
                            });

                        Log.d("hhh", build.getJson() + "");


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
            }





    @Override
    public void onsucess(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.d("mymsg", s + "");
                textView.setText(s);
            }
        });
    }
}
