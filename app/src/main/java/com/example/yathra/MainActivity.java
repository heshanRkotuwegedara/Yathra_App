package com.example.yathra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView CreateTimetable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CreateTimetable = (TextView) findViewById(R.id.txtTimetableHome);

        CreateTimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Timetable_Home.class);
                startActivity(intent);

                Toast.makeText(MainActivity.this, "Timetable Home", Toast.LENGTH_SHORT).show();
            }
        });
    }
}