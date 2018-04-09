package com.example.android.baritour;


//This claass will contain information about city objects for ArrayList

public class Information {

    private static final int NO_STARS = -1;
    //Name of object
    private String mName;
    //Location adress
    private String mAdress;
    //Description of object
    private String mDescription;
    //Picture of object
    private int mPictureId;
    private int mStars = NO_STARS;

    public Information(String name, String adress, String description, int pictureId) {
        mName = name;
        mAdress = adress;
        mDescription = description;
        mPictureId = pictureId;

    }

    public Information(String name, String adress, String description, int pictureId, int stars) {
        mName = name;
        mAdress = adress;
        mDescription = description;
        mPictureId = pictureId;
        mStars = stars;

    }


    //getter methodes for objects data
    public String getName() {
        return mName;
    }

    public String getAdress() {
        return mAdress;
    }

    public String getDescription() {
        return mDescription;
    }

    public int getPictureId() {
        return mPictureId;
    }

    //returning star image depending on stars number from array
    public int getStars() {
        if (mStars == 1) {
            return com.example.android.baritour.R.drawable.star1;
        } else if (mStars == 2) {
            return com.example.android.baritour.R.drawable.star2;
        } else if (mStars == 3) {
            return com.example.android.baritour.R.drawable.star3;
        } else if (mStars == 4) {
            return com.example.android.baritour.R.drawable.star4;
        } else if (mStars == 5) {
            return com.example.android.baritour.R.drawable.star5;
        } else {
            return 0;
        }

    }


    public boolean hasImage() {
        return mStars != NO_STARS;
    }


}


