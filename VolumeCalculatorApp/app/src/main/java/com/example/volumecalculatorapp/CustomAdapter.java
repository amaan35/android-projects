package com.example.volumecalculatorapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapes;
    Context context;

    public CustomAdapter(ArrayList<Shape> shapes, Context context1) {
        super(context1, R.layout.item_gridview, shapes);
        this.shapes = shapes;
        this.context = context1;
    }

    private static class ViewHolder{
        TextView shapeName;
        ImageView shapeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shape = getItem(position);
        ViewHolder viewHolder;
        if(convertView==null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_gridview, parent, false);
            viewHolder.shapeName = (TextView) convertView.findViewById(R.id.id_shapeName);
            viewHolder.shapeImage = (ImageView) convertView.findViewById(R.id.id_shape);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.shapeName.setText(shape.getShapeName());
        viewHolder.shapeImage.setImageResource(shape.getShapeImage());
        return convertView;
    }
}

