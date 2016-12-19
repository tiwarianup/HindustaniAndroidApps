package com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by anuptiwari on 12/1/2016.
 */

public class AboutActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView facebookLike = (TextView)findViewById(R.id.headingTextView);
        TextView playReview   = (TextView)findViewById(R.id.headingTextView2);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        facebookLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://www.facebook.com/hindustani.android.apps");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        playReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // To be replaced
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Know India - Religion & Cultures  \nhttps://play.google.com/store/apps/details?id=com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods \n\nDownload from Google Play Store now! ");
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }
}
