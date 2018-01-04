package com.example.xdd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 智彪 on 2017/6/27.
 */



public class TripAdapter extends ArrayAdapter<Trip> {
    private int resourceId;
    public TripAdapter(Context context, int textViewResourceId, List<Trip> objects){
        super(context,textViewResourceId,objects);
        resourceId=textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        Trip trip=getItem(position);
      /*  View view;

        ViewHolder viewHolder;
        if(convertView==null){
            view=LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.tripImage=(ImageView)view.findViewById(R.id.trip_image);
            viewHolder.tripName=(TextView)view.findViewById(R.id.trip_name);
            view.setTag(viewHolder);
            }
        else {view=convertView;
               viewHolder=(ViewHolder)view.getTag();}
        viewHolder.tripImage.setImageResource(trip.getImageId());
        viewHolder.tripName.setText(trip.getName());*/
        View view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        ImageView timeImage=(ImageView)view.findViewById(R.id.trip_image);
        TextView timeName=(TextView)view.findViewById(R.id.trip_name);
        TextView detail=(TextView)view.findViewById(R.id.trip_message);
        detail.setText(trip.getDetail());
        timeImage.setImageResource(trip.getImageId());
        timeName.setText(trip.getName());
        return  view;
    }
    // class ViewHolder{
    //   ImageView tripImage;
    //     TextView tripName;
    //}
}
