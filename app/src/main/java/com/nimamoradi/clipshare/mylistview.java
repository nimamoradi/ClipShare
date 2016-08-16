package com.nimamoradi.clipshare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by nima on 8/10/2016.
 * extend from array_adpter in order to make customized list
 */
public class mylistview extends ArrayAdapter<adoptor_compoment> {
    LayoutInflater layoutInflater;
    Context context;


    public mylistview(Context context, int resource) {
        super(context, resource);
        this.context = context;

     layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = layoutInflater.inflate(R.layout.customlistveiewcomoment,null);

        TextView title = (TextView) view.findViewById(R.id.movie_name);
        title.setText(getItem(position).movie_name);

        TextView dateTextView = (TextView) view.findViewById(R.id.release_date);
        dateTextView.setText(getItem(position).movie_relese_date.toString());

        ImageView myImageView  = (ImageView) view.findViewById(R.id.list_image);
        Picasso.with(context)
                .load(getItem(position).vedioImageurl)
                .noFade().into(myImageView);

        myImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(getItem(position));
            }
        });

        return view;
    }
}
