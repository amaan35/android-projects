package com.example.employeeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<Employee> employeeArrayList;
    private static employeeAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.id_listEmployee);
        employeeArrayList = new ArrayList<>();
        Employee employee1 = new Employee("Carl", "123", R.drawable.carl);
        Employee employee2 = new Employee("Bale", "111", R.drawable.bale);
        Employee employee3 = new Employee("Bruce", "154", R.drawable.bruce);
        Employee employee4 = new Employee("Earl", "124", R.drawable.earl);
        Employee employee5 = new Employee("Jack", "126", R.drawable.jack);
        Employee employee6 = new Employee("Iniesta", "766", R.drawable.iniesta);
        Employee employee7 = new Employee("Mbappe", "105", R.drawable.mbappe);
        Employee employee8 = new Employee("Messi", "101", R.drawable.messi);
        Employee employee9 = new Employee("Salah", "167", R.drawable.mo_salah);
        Employee employee10 = new Employee("Modric", "121", R.drawable.modric);
        Employee employee11 = new Employee("Neymar", "168", R.drawable.neymar);
        Employee employee12 = new Employee("Rick", "122", R.drawable.rick);
        Employee employee13 = new Employee("Ronaldo", "754", R.drawable.ronaldo);
        Employee employee14 = new Employee("Suarez", "954", R.drawable.suarez);
        employeeArrayList.add(employee1);
        employeeArrayList.add(employee2);
        employeeArrayList.add(employee3);
        employeeArrayList.add(employee4);
        employeeArrayList.add(employee5);
        employeeArrayList.add(employee6);
        employeeArrayList.add(employee7);
        employeeArrayList.add(employee8);
        employeeArrayList.add(employee9);
        employeeArrayList.add(employee10);
        employeeArrayList.add(employee11);
        employeeArrayList.add(employee12);
        employeeArrayList.add(employee13);
        employeeArrayList.add(employee14);

        adapter = new employeeAdapter(employeeArrayList, getApplicationContext());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Employee "+adapter.getItem(i).getEmployeeName()+" clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}