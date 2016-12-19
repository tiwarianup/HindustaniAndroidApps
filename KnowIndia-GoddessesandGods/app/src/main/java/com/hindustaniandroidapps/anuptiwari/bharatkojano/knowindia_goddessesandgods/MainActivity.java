package com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        LinearLayout devi_devta_layout = (LinearLayout)findViewById(R.id.devi_devta_layout);
        LinearLayout dharm_layout = (LinearLayout)findViewById(R.id.dharm_layout);
        LinearLayout ramayan_layout = (LinearLayout)findViewById(R.id.ramayan_layout);
        LinearLayout mahabharat_layout = (LinearLayout)findViewById(R.id.mahabharat_layout);
        LinearLayout dharm_sthal_layout = (LinearLayout)findViewById(R.id.dharm_sthal_layout);
        LinearLayout lalit_kala_layout = (LinearLayout)findViewById(R.id.lalit_kala_layout);
        LinearLayout mahan_layout = (LinearLayout)findViewById(R.id.mahan_layout);
        LinearLayout aboutUs = (LinearLayout)findViewById(R.id.aboutUs);
        TextView aboutTextView = (TextView)aboutUs.findViewById(R.id.aboutTextView);

        devi_devta_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent devi_devta_intent = new Intent(MainActivity.this, DeviDevta.class);
                startActivity(devi_devta_intent);
            }
        });

        dharm_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dharma_intent = new Intent(MainActivity.this, Dharm.class);
                startActivity(dharma_intent);
            }
        });

        ramayan_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ramayan_intent = new Intent(MainActivity.this, RamayanSe.class);
                startActivity(ramayan_intent);
            }
        });

        mahabharat_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mahabharata_intent = new Intent(MainActivity.this, MahabharatSe.class);
                startActivity(mahabharata_intent);
            }
        });

        dharm_sthal_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dharm_sthal_intent = new Intent(MainActivity.this, DharmSthal.class);
                startActivity(dharm_sthal_intent);
            }
        });

        lalit_kala_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lalit_kala_intent = new Intent(MainActivity.this, LalitKala.class);
                startActivity(lalit_kala_intent);
            }
        });

        mahan_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mahan_intent = new Intent(MainActivity.this, MahanGuruShishya.class);
                startActivity(mahan_intent);
            }
        });


        aboutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(about_intent);
            }
        });
    }

    public void shareApp(View view) throws ActivityNotFoundException {
        try {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, "Know India - Religion n Cultures \n" +
                    "https://play.google.com/store/apps/details?id=com.hindustaniandroidapps.anuptiwari.bharatkojano.knowindia_goddessesandgods \n" +
                    "\n" +
                    "Download from Google Play Store! ");
            sendIntent.setType("text/plain");
            sendIntent.setPackage("com.whatsapp");
            startActivity(sendIntent);
        }catch (ActivityNotFoundException notFoundExecption){
            Log.v("MainActivity", notFoundExecption.getMessage());
            final Toast toast = Toast.makeText(MainActivity.this, "Sorry! WhatsApp not available on this phone! ", Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}
