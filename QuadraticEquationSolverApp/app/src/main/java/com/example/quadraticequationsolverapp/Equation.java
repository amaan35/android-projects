package com.example.quadraticequationsolverapp;

import android.view.View;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.example.quadraticequationsolverapp.databinding.ActivityMainBinding;

public class Equation extends BaseObservable {

    String a, b, c;
    ActivityMainBinding activityMainBinding;

    public Equation() {
    }

    public Equation(ActivityMainBinding activityMainBinding) {
        this.activityMainBinding = activityMainBinding;
    }

    @Bindable
    public String getA() {
        return a;
    }
    public void setA(String a) {
        this.a = a;
    }

    @Bindable
    public String getB() {
        return b;
    }
    public void setB(String b) {
        this.b = b;
    }

    @Bindable
    public String getC() {
        return c;
    }
    public void setC(String c) {
        this.c = c;
    }

    public void solve(View view){
        int a = Integer.parseInt(getA());
        int b = Integer.parseInt(getB());
        int c = Integer.parseInt(getC());

        double d = b*b - 4*a*c;

        double x, y;
        if(d>0){
            x = (-b+Math.sqrt(d))/(2*a);
            y = (-b-Math.sqrt(d))/(2*a);

            activityMainBinding.idSolution.setText("x = "+x+" y = "+y);
        } else if (d<0) {
            activityMainBinding.idSolution.setText("No real solutions");
        }else{
            x = -b/(2*a);

            activityMainBinding.idSolution.setText("x = "+x+" y = "+x);
        }
    }
}
