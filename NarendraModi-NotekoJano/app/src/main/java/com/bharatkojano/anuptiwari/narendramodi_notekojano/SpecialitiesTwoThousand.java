package com.bharatkojano.anuptiwari.narendramodi_notekojano;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * Created by anuptiwari on 11/26/2016.
 */

public class SpecialitiesTwoThousand extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        ArrayList<SpecialitiesNotes> specialNotes = new ArrayList<SpecialitiesNotes>();
        specialNotes.add(new SpecialitiesNotes("पहली विशेषता", "2000 अंक रजिस्टर के माध्यम से दिखेगा ", R.drawable.one));
        specialNotes.add(new SpecialitiesNotes("दूसरी विशेषता ", "नोट को झुकाकर छोर से देखने से 2000 अंक की छवि नज़र आती है ", R.drawable.two));
        specialNotes.add(new SpecialitiesNotes("तीसरी विशेषता", "देवनागरी लिपि में 2000 अंक पाया जा सकता है", R.drawable.three));
        specialNotes.add(new SpecialitiesNotes("चौथी विशेषता ", "महात्मा गांधी का चित्र बीच में स्थित है ", R.drawable.four));
        specialNotes.add(new SpecialitiesNotes("पांचवी विशेषता ", "RBI और 2000 का बहुत ही छोटे अक्षरो में छपा होना ", R.drawable.five));
        specialNotes.add(new SpecialitiesNotes("छठी विशेषता ", "विंडोड सुरक्षा धागा 2000 , RBI और 'भारत' छपे होने के साथ साथ देखने के दिशानुसार रंग बदलता है ", R.drawable.six));
        specialNotes.add(new SpecialitiesNotes("साँतवी विशेषता", "गारंटी खंड, प्रीमियम खंड और भारतीय रिजर्व बैंक के प्रतीक के साथ राज्यपाल के हस्ताक्षर अशोक स्तम्भ के साथ दायीं दिशा में उपस्थित ", R.drawable.seven));
        specialNotes.add(new SpecialitiesNotes("आठवी विशेषता ", "महात्मा गांधी के चित्र और इलेक्ट्रोटाइप (2000) वॉटरमार्क का उपलब्ध होना ", R.drawable.eight));
        specialNotes.add(new SpecialitiesNotes("नौंवी विशेषता ", "नंबर पैनल जिसपे छोटे से बड़े अक्षरो में अंक, ऊपरी बायीं और नीचे दायीं ओर उपलब्ध है ", R.drawable.nine));
        specialNotes.add(new SpecialitiesNotes("दसवी विशेषता ", "नीचे दायीं ओर 2000 अंक और रुपये का प्रतीक अपना रंग हरे से हलके रंग में बदलता हुआ ", R.drawable.ten));
        specialNotes.add(new SpecialitiesNotes("ग्यारहवी विशेषता ", "अशोक स्तंभ प्रतीक दायीं ओर देखा जा सकता है। महात्मा गाँधी का चित्र, अशोक स्तम्भ तथा नोट के दायीं तथा बाईं ओर रेखाओ का गाढ़ी स्याही से छपा होना इस नोट के सही होने का सबूत है ", R.drawable.eleven));
        specialNotes.add(new SpecialitiesNotes("बारहवी विशेषता ", "चकोर आकर में तथा 2000 गाढ़े शब्दों में छपा होना ", R.drawable.twelve));
        specialNotes.add(new SpecialitiesNotes("तेरहवी विशेषता ", "नोट के दोनों ओर 7 रेखाओं का गाढ़ी स्याही से छपा होना ", R.drawable.thirteen));
        specialNotes.add(new SpecialitiesNotes("चौदहवी विशेषता ", "नोट के छपाई के वर्ष का उपलब्ध होना ", R.drawable.fourteen));
        specialNotes.add(new SpecialitiesNotes("पंद्रहवही विशेषता  ", "स्वछ भारत के नारे तथा लोगो का उपलब्ध होना ", R.drawable.fifteen));
        specialNotes.add(new SpecialitiesNotes("सोल्वही विशेषता ", "नए 2000 के नोट में भाषा पैनल का मध्य की ओर स्थित होना ", R.drawable.sixteen));
        specialNotes.add(new SpecialitiesNotes("सत्रहवी विशेषता ", "मंगलयान का रूपांकन ", R.drawable.seventeen));


        NotesSpecialityAdapter specialNotesAdaper = new NotesSpecialityAdapter(this, specialNotes);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(specialNotesAdaper);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
