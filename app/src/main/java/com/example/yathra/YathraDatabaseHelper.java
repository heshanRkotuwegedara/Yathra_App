package com.example.yathra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class YathraDatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "Yathra.db";
    private static final String TABLE_NAME = "Train_Timetable";

    //Timetable Table Column Names
    private static final String TIMETABLE_ID = "ID";
    private static final String ROUTE_NAME = "Route_Name";
    private static final String START_STATION = "Start_Station";
    private static final String END_STATION = "End_Station";
    private static final String TRAIN_NAME = "Train_Name";


    public YathraDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create Table
        String TABLE_CREATE_QUERY = " CREATE TABLE " + TABLE_NAME + " " +
                "("
                + TIMETABLE_ID + " INTEGER PRIMARY KEY, "
                + ROUTE_NAME + " TEXT, "
                + START_STATION + " TEXT, "
                + END_STATION + " TEXT, "
                + TRAIN_NAME + " TEXT " +
                ");";

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE_QUERY = " DROP TABLE IF EXISTS " + TABLE_NAME;

        //Drop Older Table if Existed
        db.execSQL(DROP_TABLE_QUERY);
        //Create Table Again
        onCreate(db);

    }

    void insertData(String rName, String sStation, String eStation, String trainName){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();

        //store all data and pass it to database table
        cv.put(ROUTE_NAME,rName);
        cv.put(START_STATION,sStation);
        cv.put(END_STATION,eStation);
        cv.put(TRAIN_NAME,trainName);

        //insert data inside database table
        long result = db.insert(TABLE_NAME, null, cv);

        if(result == -1 ){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show();
        }

    }

    public Cursor readAllData(){

        String GET_DATA_QUERY = " SELECT * FROM " +TABLE_NAME;

        SQLiteDatabase yathraDB = this.getReadableDatabase(); //sqlite db obj

        Cursor cursor = null ; //Cursor obj
        if(yathraDB != null){
            cursor = yathraDB.rawQuery(GET_DATA_QUERY,null); //cursor obtain all data from db
        }
        return cursor;


    }


}
