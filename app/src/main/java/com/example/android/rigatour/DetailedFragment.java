package com.example.android.rigatour;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedFragment extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_view);

        // getting attached intent data
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        //Must be default value for int- for example 0
        String adress = i.getStringExtra("adress");
        String description = i.getStringExtra("description");

        int picture = i.getIntExtra("picture", 0);
        int stars = i.getIntExtra("stars", 0);


        TextView nameView = (TextView) findViewById(R.id.detailed_name);
        nameView.setText(name);

        TextView adressView = (TextView) findViewById(R.id.detailed_adress);
        adressView.setText(adress);

        TextView descriptionView = (TextView) findViewById(R.id.detailed_description);
        descriptionView.setText(description);

        ImageView pictureView = (ImageView) findViewById(R.id.detailed_picture);
        pictureView.setImageResource(picture);

        ImageView starsView = (ImageView) findViewById(R.id.detailed_stars);
        if (stars > 0) {
            // If an image is available, display the provided image based on the resource ID
            starsView.setImageResource(stars);
            // Make sure the view is visible
            starsView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            starsView.setVisibility(View.GONE);
        }




    }



}


