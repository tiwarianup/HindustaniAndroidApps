package com.bharatkojano.anuptiwari.narendramodi_notekojano;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by anuptiwari on 11/25/2016.
 */

public class NotesBothActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notesboth);

        ImageView imgView500 = (ImageView)findViewById(R.id.front_500);
        imgView500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NotesBothActivity.this, SpecialitiesFiveHundred.class);
                startActivity(i);
            }
        });


        ImageView imgView2000 = (ImageView)findViewById(R.id.front_2000);
        imgView2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(NotesBothActivity.this, SpecialitiesTwoThousand.class);
                startActivity(i);
            }
        });

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }
}
