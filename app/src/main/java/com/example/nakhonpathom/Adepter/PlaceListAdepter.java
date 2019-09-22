package com.example.nakhonpathom.Adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.nakhonpathom.R;
import com.example.nakhonpathom.model.Place;

import java.util.List;

public class PlaceListAdepter extends ArrayAdapter<Place> {

    private Context mContext;
    private int mResource;
    private List<Place> mPlacesList;

    public PlaceListAdepter(@NonNull Context context, int resource, @NonNull List<Place> placeList) {
        super(context, resource, placeList);
        this.mContext=context;
        this.mResource=resource;
        this.mPlacesList=placeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater.inflate(mResource,parent,false);

        Place place=mPlacesList.get(position); // เก็บสถานที่

        //กำหนดชื่อสถานที่ลงในTextView (place_name_textView)
        TextView placeNameTextView=v.findViewById(R.id.place_name_textView);
        placeNameTextView.setText(place.name);

        //กำหนดชื่ออำเภอลงในTextView(didtrict_tex_tView)
        TextView districTextView=v.findViewById(R.id.didtrict_tex_tView);
        districTextView.setText(place.district);

        return v;
    }
}
