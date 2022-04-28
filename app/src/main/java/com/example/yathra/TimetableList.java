package com.example.yathra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class TimetableList extends AppCompatActivity {

    RecyclerView recyclerView;
    YathraDatabaseHelper myDBHelper;
    ArrayList<String> routeName, tDate, arriveTime, departTime, trainName;
    TimetableAdapter timetableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable_list);

        recyclerView = findViewById(R.id.recycleView);
        myDBHelper = new YathraDatabaseHelper(TimetableList.this);
        routeName = new ArrayList<>();
        tDate = new ArrayList<>();
        arriveTime = new ArrayList<>();
        departTime = new ArrayList<>();
        trainName = new ArrayList<>();

        timetableAdapter = new TimetableAdapter(TimetableList.this, routeName, tDate, arriveTime,departTime,trainName);
        recyclerView.setAdapter(timetableAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(TimetableList.this));

        storeDataInArray();
    }

    private void storeDataInArray(){

        Cursor cursor = myDBHelper.readAllData();

        if(cursor.getCount() == 0){
            Toast.makeText(TimetableList.this, "No Data", Toast.LENGTH_SHORT).show();
            return;
        }else{
            while (cursor.moveToNext()){
                routeName.add(cursor.getString(0));
                tDate.add(cursor.getString(1));
                arriveTime.add(cursor.getString(2));
                departTime.add(cursor.getString(3));
                trainName.add(cursor.getString(4));
            }
        }
    }
}