package com.ruizpatricio.oscar.filters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Oscar on 27/06/2017.
 */

public class SeriesAdapter extends BaseAdapter {

    private ViewHolder viewHolder;
    private LayoutInflater inflater;
    private ArrayList<Serie> series;
    private Context context;

    public SeriesAdapter(ArrayList<Serie> series, Context context) {
        this.series = series;
        this.context = context;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return series.size();
    }

    @Override
    public Object getItem(int position) {
        return series.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //if view is not created
        if (convertView == null) {
            //create view
            convertView = inflater.inflate(R.layout.item_listview, parent, false);

            //set up the ViewHolder
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView)convertView.findViewById(R.id.name);
            viewHolder.year = (TextView)convertView.findViewById(R.id.year);
            viewHolder.genre = (TextView)convertView.findViewById(R.id.genre);

            // store the holder with the view.
            convertView.setTag(viewHolder);
        } else {
            //get holder
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //set view values
        viewHolder.name.setText(series.get(position).getName());
        viewHolder.genre.setText(series.get(position).getGenre());
        viewHolder.year.setText(String.valueOf(series.get(position).getYear()));

        //return view
        return convertView;
    }

public class ViewHolder {
    //set all view elements
        private TextView name;
        private TextView year;
        private TextView genre;
    }

}

