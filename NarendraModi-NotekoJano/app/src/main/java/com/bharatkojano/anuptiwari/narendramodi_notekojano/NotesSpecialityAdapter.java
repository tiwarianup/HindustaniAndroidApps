package com.bharatkojano.anuptiwari.narendramodi_notekojano;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.R.attr.start;
import static android.R.id.message;

/**
 * Created by anuptiwari on 11/26/2016.
 */

public class NotesSpecialityAdapter extends ArrayAdapter<SpecialitiesNotes> {

    private Context mContext;

    public NotesSpecialityAdapter(Context context, ArrayList<SpecialitiesNotes> specialityNotes){
        super(context, 0, specialityNotes);
        this.mContext = context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent){

        final SpecialitiesNotes currentSpeciality = getItem(position);
        View listView = convertView;
        if (listView == null){
            listView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView text_view = (TextView) listView.findViewById(R.id.list_text);
        text_view.setText(currentSpeciality.getTitleText());

        ImageView image_view = (ImageView) listView.findViewById(R.id.list_image);
        if(currentSpeciality.getImageResId() != 0){
            image_view.setImageResource(currentSpeciality.getImageResId());
            image_view.setVisibility(View.VISIBLE);
        }else{
            image_view.setVisibility(View.GONE);
        }

        listView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View convertView) {
                Intent intent = new Intent(getContext(), SpecialityView.class);
                intent.putExtra("title", currentSpeciality.getTitleText());
                intent.putExtra("image_res", currentSpeciality.getImageResId());
                intent.putExtra("text", currentSpeciality.getTextViewText());
                convertView.getContext().startActivity(intent);
            }
        });

        return listView;
    }


}
