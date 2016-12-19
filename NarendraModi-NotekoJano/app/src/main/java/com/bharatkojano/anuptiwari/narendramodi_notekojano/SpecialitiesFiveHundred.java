package com.bharatkojano.anuptiwari.narendramodi_notekojano;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.util.ArrayList;

/**
 * Created by anuptiwari on 11/26/2016.
 */

public class SpecialitiesFiveHundred extends AppCompatActivity {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        ArrayList<SpecialitiesNotes> specialNotes = new ArrayList<SpecialitiesNotes>();
        specialNotes.add(new SpecialitiesNotes("पहली विशेषता", "500 अंक रजिस्टर के माध्यम से दिखेगा", R.drawable.one5));
        specialNotes.add(new SpecialitiesNotes("दूसरी विशेषता ", "नोट को झुकाकर छोर से देखने से 500 अंक की छवि नज़र आती है", R.drawable.two5));
        specialNotes.add(new SpecialitiesNotes("तीसरी विशेषता", "देवनागरी लिपि में 500 अंक पाया जा सकता है", R.drawable.three5));
        specialNotes.add(new SpecialitiesNotes("चौथी विशेषता ", "महात्मा गांधी के चित्र का उन्मुखीकरण और स्थान बदल गया है", R.drawable.four5));
        specialNotes.add(new SpecialitiesNotes("पांचवी विशेषता ", "नोट को झुकाने पर सुरक्षा धागा हरे से नीले रंग में बदलता हुआ प्रतीत होता है", R.drawable.five5));
        specialNotes.add(new SpecialitiesNotes("छठी विशेषता ", "गारंटी खंड, प्रीमियम खंड और भारतीय रिजर्व बैंक के प्रतीक के साथ राज्यपाल के हस्ताक्षर दायीं दिशा में झुका हुआ प्रतीत होगा", R.drawable.six5));
        specialNotes.add(new SpecialitiesNotes("साँतवी विशेषता", "इलेक्ट्रोटाइप और पोर्ट्रेट वॉटरमार्क का उपलब्ध होना नोट के सही होने की पहचान है", R.drawable.seven5));
        specialNotes.add(new SpecialitiesNotes("आठवी विशेषता ", "नंबर पैनल जिसपे छोटे से बड़े अक्षरो में अंक, ऊपरी बायीं और नीचे दायीं ओर उपलब्ध है", R.drawable.eight5));
        specialNotes.add(new SpecialitiesNotes("नौंवी विशेषता ", "नीचे दायीं ओर 500 अंक और रुपये का प्रतीक अपना रंग हरे से हलके रंग में बदलता हुआ", R.drawable.nine5));
        specialNotes.add(new SpecialitiesNotes("दसवी विशेषता ", "अशोक स्तंभ प्रतीक दायीं ओर देखा जा सकता है", R.drawable.ten5));
        specialNotes.add(new SpecialitiesNotes("ग्यारहवी विशेषता ", "500 अंक तथा काले गोलाकार का गाढ़ी स्याही से छपा होना", R.drawable.eleven5));
        specialNotes.add(new SpecialitiesNotes("बारहवी विशेषता ", "नोट के दायीं तथा बाईं ओर 5 रेखाओं का उपलब्ध होना ", R.drawable.twelve5));
        specialNotes.add(new SpecialitiesNotes("तेरहवी विशेषता ", "नोट के छपाई के वर्ष का उपलब्ध होना", R.drawable.thirteen5));
        specialNotes.add(new SpecialitiesNotes("चौदहवी विशेषता ", "स्वछ भारत के नारे तथा लोगो का उपलब्ध होना", R.drawable.fourteen5));
        specialNotes.add(new SpecialitiesNotes("पंद्रहवही विशेषता  ", "नए 500 के नोट में भाषा पैनल का मध्य की ओर स्थित होना ", R.drawable.fifteen5));
        specialNotes.add(new SpecialitiesNotes("सोल्वही विशेषता ", "लाल किले का भारत के झंडे के साथ चित्र ", R.drawable.sixteen5));
        specialNotes.add(new SpecialitiesNotes("सत्रहवी विशेषता ", "देवनागरी लिपि में 500 अंक का ऊपरी दायीं ओर स्थित होना ", R.drawable.seventeen5));



        NotesSpecialityAdapter specialNotesAdaper = new NotesSpecialityAdapter(this, specialNotes);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(specialNotesAdaper);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
