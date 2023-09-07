package com.example.volumecalculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class cubeActivity extends AppCompatActivity {

    EditText cubeEdit;
    Button calCube;
    TextView resultCube;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cube);

        cubeEdit = findViewById(R.id.id_cubeID);
        calCube = findViewById(R.id.id_calCube);
        resultCube = findViewById(R.id.id_resultCube);

        calCube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = cubeEdit.getText().toString();
                int result = Integer.parseInt(input);
                resultCube.setText("Volume = "+result*result*result+" m^3");
            }
        });
    }
}