package com.example.seminar4;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Weather extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_weather);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Button btnSend= findViewById(R.id.button5);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link= "http://dataservice.accuweather.com/locations/v1/cities/search?apikey=2vLdJuqKYv22AARdtA9k6qY9LRdGq3G4&q=Bucure%C8%99ti";
                Executor executor = Executors.newSingleThreadExecutor();
                Handler handler = new Handler(Looper.myLooper());

                executor.execute(new Runnable() {
                    @Override
                    public void run() {
                        HttpURLConnection connection = null;
                        try {
                            URL url = new URL(link);
                            connection = (HttpURLConnection) url.openConnection();
                            InputStream is = connection.getInputStream();
                            InputStreamReader isr= new InputStreamReader(is);
                            BufferedReader bufferedReader= new BufferedReader(isr);
                            StringBuilder response= new StringBuilder();
                            String line;
                            while((line= bufferedReader.readLine())!=null){
                                response.append(line);
                            }
                            JSONArray vector= new JSONArray(response.toString());
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        handler.post(new Runnable() {
                            @Override
                            public void run() {

                            }
                        });
                    }

                });
            }
        });

    }
}