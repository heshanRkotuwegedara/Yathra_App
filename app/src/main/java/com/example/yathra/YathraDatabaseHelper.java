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
    private static final String Timetable_TABLE_NAME = "Train_Timetable_Test1";

    //Timetable Table Column Names
    private static final String ROUTE_NAME = "Route_Name";
    private static final String DATE = "Date";
    private static final String ARRIVE_TIME = "Arrive_Time";
    private static final String DEPART_TIME = "Depart_Time";
    private static final String TRAIN_NAME = "Train_Name";


    public YathraDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Create Table
        String TABLE_CREATE_QUERY = " CREATE TABLE " + Timetable_TABLE_NAME + " "+
                " ("
                + ROUTE_NAME + " TEXT PRIMARY KEY, "
                + DATE + " TEXT, "
                + ARRIVE_TIME + " TEXT, "
                + DEPART_TIME + " TEXT, "
                + TRAIN_NAME + " TEXT"+
                ");";

        db.execSQL(TABLE_CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int ii) {

        String DROP_TABLE_QUERY = " DROP TABLE IF EXISTS " + Timetable_TABLE_NAME;

        //Drop Older Table if Existed
        db.execSQL(DROP_TABLE_QUERY);
        //Create Table Again
        onCreate(db);

    }

    public boolean insertData(String rName, String tDate, String arriveTime, String departTime, String trainName){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        //store all data and pass it to database table
        contentValues.put(ROUTE_NAME,rName);
        contentValues.put(DATE,tDate);
        contentValues.put(ARRIVE_TIME,arriveTime);
        contentValues.put(DEPART_TIME,departTime);
        contentValues.put(TRAIN_NAME,trainName);

        //insert data inside database table
        long result = db.insert(Timetable_TABLE_NAME, null, contentValues);

        if(result == -1 ){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show();
            return true;
        }

    }

    public Cursor readAllData(){

        String GET_DATA_QUERY = " SELECT * FROM " +Timetable_TABLE_NAME;

        SQLiteDatabase yathraDB = this.getWritableDatabase(); //sqlite db obj

        Cursor cursor = null ; //Cursor obj
        if(yathraDB != null){
            cursor = yathraDB.rawQuery(GET_DATA_QUERY,null); //cursor obtain all data from db
        }
        return cursor;


    }


}
