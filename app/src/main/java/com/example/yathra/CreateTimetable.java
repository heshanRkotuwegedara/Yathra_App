package com.example.yathra;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateTimetable extends AppCompatActivity {

    YathraDatabaseHelper myDBHelper;
    EditText routeName, date, arriveTime, departTime, trainName;
    Button btnCreate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_timetable);

        routeName = findViewById(R.id.editTextRouteName);
        date = findViewById(R.id.editTextDate);
        arriveTime = findViewById(R.id.editTextArriveTime);
        departTime = findViewById(R.id.editTextDepartRime);
        trainName = findViewById(R.id.editTexTrainName);
        btnCreate = findViewById(R.id.btnSaveTimetable);
        myDBHelper = new YathraDatabaseHelper(this);//create YathraDatabaseHelper class obj

        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
                //get text boxes values to variable
                String editTextRouteName = routeName.getText().toString().trim();
                String editTextDate = date.getText().toString().trim();
                String editTextArriveTime = arriveTime.getText().toString().trim();
                String editTextDepartRime = departTime.getText().toString().trim();
                String editTexTrainName = trainName.getText().toString().trim();

                Boolean checkInsertData = myDBHelper.insertData(editTextRouteName, editTextDate, editTextArriveTime, editTextDepartRime, editTexTrainName);
                if (checkInsertData == true){
                    Toast.makeText(CreateTimetable.this, "Timetable Saved", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CreateTimetable.this, "Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}
