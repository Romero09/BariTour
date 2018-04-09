package com.example.android.baritour;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.baritour.R.layout.detailed_view);

        // getting attached intent data
        Intent i = getIntent();
        String name = i.getStringExtra("name");
        //Must be default value for int- for example 0
        final String adress = i.getStringExtra("adress");
        String description = i.getStringExtra("description");
        int picture = i.getIntExtra("picture", 0);
        int stars = i.getIntExtra("stars", 0);

        //storing object name in name TextView field
        TextView nameView = (TextView) findViewById(com.example.android.baritour.R.id.detailed_name);
        nameView.setText(name);

        //storing object address in address TextView field
        TextView adsressView = (TextView) findViewById(com.example.android.baritour.R.id.detailed_adress);
        adsressView.setText("Adress: " + adress + "\n (show on map)");

        //storing object description in description TextView field
        TextView descriptionView = (TextView) findViewById(com.example.android.baritour.R.id.detailed_description);
        descriptionView.setText("Description: " + description);

        //storing object picture in pciture ImageView field
        ImageView pictureView = (ImageView) findViewById(com.example.android.baritour.R.id.detailed_picture);
        pictureView.setImageResource(picture);

        //storing stars picture in stars  ImageView field
        ImageView starsView = (ImageView) findViewById(com.example.android.baritour.R.id.detailed_stars);
        //checking if object have stars
        if (stars > 0) {
            // If an image is available, display the provided image based on the resource ID
            starsView.setImageResource(stars);
            // Make sure the view is visible
            starsView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            starsView.setVisibility(View.GONE);
        }

        //Opening address in google maps to see the location.
        adsressView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a Uri from an intent string. Use the result to create an Intent.
                Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + adress);

                // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                // Make the Intent explicit by setting the Google Maps package
                mapIntent.setPackage("com.google.android.apps.maps");

                // Attempt to start an activity that can handle the Intent
                //Chech if there google maps installed and can hande the intent. If not if function will be false.
                if (mapIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(mapIntent);

                }

            }
        });


    }


}


