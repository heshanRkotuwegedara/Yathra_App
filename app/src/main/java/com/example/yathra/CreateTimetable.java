package com.example.yathra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateTimetable extends AppCompatActivity {

    EditText routeName, startStation, endStation, trainName;
    Button btncreate;

    YathraDatabaseHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_timetable);

        routeName = findViewById(R.id.editTextRouteName);
        startStation = findViewById(R.id.editTextStartStation);
        endStation = findViewById(R.id.editTextEndStation);
        trainName = findViewById(R.id.editTextTrainName);
        btncreate = findViewById(R.id.btnSaveTimetable);

        myDBHelper = new YathraDatabaseHelper(this);//create YathraDatabaseHelper class obj

        AddData();
    }

    public void AddData(){
        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Pass Data to Database
                myDBHelper.insertData(routeName.getText().toString().trim(),
                                                           startStation.getText().toString().trim(),
                                                           endStation.getText().toString().trim(),
                                                           trainName.getText().toString().trim());

            }
        });
    }
}