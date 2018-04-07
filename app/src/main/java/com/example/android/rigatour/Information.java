package com.example.android.rigatour;


//This claass will contain information about city objects for ArrayList

public class Information {

    //Name of object
    private String mName;

    //Location adress
    private String mAdress;

    //Description of object
    private String mDescription;

    //Picture of object
    private int mPictureId;

    public Information(String name, String adress, String description, int pictureId){
        mName = name;
        mAdress = adress;
        mDescription = description;
        mPictureId = pictureId;

    }

    public String getName(){
        return mName;
    }

    public String getAdress(){
        return mAdress;
    }

    public String getDescription(){
        return mDescription;
    }

    public int getPictureId() {
        return mPictureId;
    }







}


