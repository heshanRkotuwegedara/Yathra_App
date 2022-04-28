package com.example.yathra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Timetable_Home extends AppCompatActivity {

    Button createTimetablePage, searchTimetablePage, displayTimetablePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_home);

        createTimetablePage = findViewById(R.id.btnCreateTimetableTH);
        searchTimetablePage = findViewById(R.id.btnSearchTH);
        displayTimetablePage = findViewById(R.id.btnDisplayTimetableTH);

        createTimetablePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Timetable_Home.this,CreateTimetable.class);
                startActivity(intent);

                Toast.makeText(Timetable_Home.this, "Create Timetable", Toast.LENGTH_SHORT).show();
            }
        });

        displayTimetablePage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Timetable_Home.this, TimetableList.class);
                startActivity(intent1);

                Toast.makeText(Timetable_Home.this, "Timetables", Toast.LENGTH_SHORT).show();
            }
        });

    }
}