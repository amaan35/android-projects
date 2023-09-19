package com.example.databindingapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

public class ClickHandler {
    Context context;
    public ClickHandler(Context context) {
        this.context = context;
    }
    public void onButtonClicked(View view){
        Toast.makeText(context, "First Button is clicked", Toast.LENGTH_SHORT).show();
    }
}
