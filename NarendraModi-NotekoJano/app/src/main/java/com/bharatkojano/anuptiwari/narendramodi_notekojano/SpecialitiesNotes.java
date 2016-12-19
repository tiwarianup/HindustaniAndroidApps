package com.bharatkojano.anuptiwari.narendramodi_notekojano;

import android.media.Image;

/**
 * Created by anuptiwari on 11/26/2016.
 */

public class SpecialitiesNotes {

    private int mImageResId;
    private String mTextViewTxt;
    private String mTitleText;

    public SpecialitiesNotes(String titleText, String textViewText, int imageResId){
        this.mTitleText = titleText;
        this.mTextViewTxt = textViewText;
        this.mImageResId = imageResId;
    }

    public int getImageResId(){
        return mImageResId;
    }

    public String getTitleText(){
        return mTitleText;
    }

    public String getTextViewText(){
        return mTextViewTxt;
    }

}
