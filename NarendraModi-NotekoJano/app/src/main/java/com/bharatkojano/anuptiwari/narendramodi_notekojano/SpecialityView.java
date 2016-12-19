package com.bharatkojano.anuptiwari.narendramodi_notekojano;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by anuptiwari on 11/26/2016.
 */

public class SpecialityView extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialview);

        Bundle bundle = getIntent().getExtras();
        final int imgResourceId = bundle.getInt("image_res");
        Log.v("SpecialityView", ""+imgResourceId);
        CharSequence titleText = (CharSequence) bundle.getString("title");
        Log.v("SpecialityView", ""+titleText);
        CharSequence mainText = (CharSequence) bundle.getString("text");
        Log.v("SpecialityView", ""+mainText);

        TextView titleView = (TextView)findViewById(R.id.note_title_view);
        TextView txtView = (TextView)findViewById(R.id.note_text_view);
        ImageView imgView = (ImageView)findViewById((R.id.note_view));

        titleView.setText(titleText);
        imgView.setImageResource(imgResourceId);
        txtView.setText(mainText);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //txtView.setText();

    }
}
