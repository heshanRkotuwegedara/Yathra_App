package com.example.yathra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class TimetableDisplay extends AppCompatActivity {

    RecyclerView recyclerView;

    YathraDatabaseHelper myDBHelper;

    ArrayList<String> ID, Route_name, Start_Station, End_Station, Train_Name;
    TimetableAdapter timetableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_display);

        recyclerView = findViewById(R.id.recycleView);
        myDBHelper = new YathraDatabaseHelper(TimetableDisplay.this);
        ID = new ArrayList<>();
        Route_name = new ArrayList<>();
        Start_Station = new ArrayList<>();
        End_Station = new ArrayList<>();
        Train_Name = new ArrayList<>();


        storeDataInArray();

        timetableAdapter = new TimetableAdapter(TimetableDisplay.this, ID, Route_name, Start_Station,End_Station,Train_Name);
        recyclerView.setAdapter(timetableAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(TimetableDisplay.this));
    }

    void storeDataInArray(){

        Cursor cursor = myDBHelper.readAllData();

        if(cursor.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                ID.add(cursor.getString(0));
                Route_name.add(cursor.getString(1));
                Start_Station.add(cursor.getString(2));
                End_Station.add(cursor.getString(3));
                Train_Name.add(cursor.getString(4));
            }
        }
    }
}