package com.example.android.rigatour;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class FragmentAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;


    public FragmentAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    private String tabTitles[] = new String[] {"Hotels", "Restaurants", "Parks", "Attractions"};


    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HotelsFragment();
        } else if (position == 1){
            return new RestaurantsFragment();
        } else if (position == 2) {
            return new ParksFragment();
        } else {
            return new AttractionsFragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }

    @Override
    public int getCount() {
        return 4;
    }




}