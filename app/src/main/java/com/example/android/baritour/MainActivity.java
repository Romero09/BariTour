package com.example.android.baritour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void start_page_go_button(View view) {
        Intent i = new Intent(this, StartActivity.class);
        // sending data to DetailedActivity activity
        startActivity(i);
    }


}
