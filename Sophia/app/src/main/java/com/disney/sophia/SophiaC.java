package com.disney.sophia;


import android.support.v7.app.AppCompatActivity;

import com.google.firebase.database.IgnoreExtraProperties;


/**
 * Created by brijeshsaini on 10/23/17.
 */
@IgnoreExtraProperties
public class SophiaC  {
    String mLastName;
    //String mNumber;

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public SophiaC(String mlastName) {
        this.mLastName = mlastName;
        //this.mNumber=mNumber;
    }

    public SophiaC() {
        mLastName = "";
       // mNumber="";
    }
    //   boolean isFullAsian;



}
