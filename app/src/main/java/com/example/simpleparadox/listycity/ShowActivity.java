package com.example.simpleparadox.listycity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private String cityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        TextView textView = findViewById(R.id.txt_activityView);
        Button backButton = findViewById(R.id.btn_back);

        cityName = getIntent().getExtras().get("city").toString();
        textView.setText(cityName);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cityList = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(cityList);
            }
        });
    }
}