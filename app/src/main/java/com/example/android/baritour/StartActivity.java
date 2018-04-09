package com.example.android.baritour;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {

    public TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.android.baritour.R.layout.view_pager);


        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager = (ViewPager) findViewById(com.example.android.baritour.R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        FragmentAdapter adapter = new FragmentAdapter(this, getSupportFragmentManager());

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        tabLayout = (TabLayout) findViewById(com.example.android.baritour.R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);


        // configure icons array for tabLayout
        int[] imageResId = {
                com.example.android.baritour.R.drawable.hotel,
                com.example.android.baritour.R.drawable.restaurant,
                com.example.android.baritour.R.drawable.park,
                com.example.android.baritour.R.drawable.attractions};

        //setting up icons for each tab image will be taken from imageResId through loop.
        for (int i = 0; i < imageResId.length; i++) {
            tabLayout.getTabAt(i).setIcon(imageResId[i]);
        }

    }


}

