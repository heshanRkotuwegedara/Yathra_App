package com.sliit.my_apllication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class login_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int item_id=item.getItemId();

        if(item_id == R.id.android){
            Toast.makeText(this, "this is a android option", Toast.LENGTH_SHORT).show();
        }
        else if(item_id == R.id.profile){
            Toast.makeText(this, "This is profile option", Toast.LENGTH_SHORT).show();
        }
        else if(item_id == R.id.setting){
            Toast.makeText(this, "This is setting option", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "This is exit option", Toast.LENGTH_SHORT).show();

        return true;
    }



}