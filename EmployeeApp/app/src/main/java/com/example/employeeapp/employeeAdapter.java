package com.example.employeeapp;

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

public class employeeAdapter extends ArrayAdapter<Employee> {

    private ArrayList<Employee> employeeArrayList;
    Context context;

    public employeeAdapter(ArrayList<Employee> employeeArrayList, Context context1) {
        super(context1, R.layout.item_listview, employeeArrayList);
        this.employeeArrayList = employeeArrayList;
        this.context = context1;
    }

    private static class MyViewHolder{
        TextView employeeName;
        TextView employeeID;
        ImageView employeeImage;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Employee employee = getItem(position);
        MyViewHolder myViewHolder;
        final View view;
        if(convertView==null){
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(
                    R.layout.item_listview,
                    parent,
                    false
            );
            myViewHolder.employeeName = (TextView) convertView.findViewById(R.id.id_employeeName);
            myViewHolder.employeeID = (TextView) convertView.findViewById(R.id.id_employeeID);
            myViewHolder.employeeImage = (ImageView) convertView.findViewById(R.id.id_employeeProfilePic);
            view = convertView;
            convertView.setTag(myViewHolder);
        }else {
            myViewHolder = (MyViewHolder) convertView.getTag();
            view = convertView;
        }
        myViewHolder.employeeName.setText(employee.getEmployeeName());
        myViewHolder.employeeID.setText(employee.getEmployeeID());
        myViewHolder.employeeImage.setImageResource(employee.getEmployeeImage());

        return view;
    }
}
