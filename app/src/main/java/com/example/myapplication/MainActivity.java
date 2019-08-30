package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edHeight;
    private EditText edWeight;
    private Button bHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
//        bHelp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
    }

    private void findViews() {
        edHeight = (EditText) findViewById(R.id.edHeight);
        edWeight = (EditText) findViewById(R.id.edWeight);
        bHelp = (Button) findViewById(R.id.bHelp);
    }

    public void calculateBmi(View v){
        double height = Float.parseFloat(edHeight.getText().toString());
        double weight = Float.parseFloat(edWeight.getText().toString());
        double bmi = weight / (height * height);
        Log.d("BMI", String.valueOf(bmi));
        Toast.makeText(this, String.valueOf(bmi), Toast.LENGTH_LONG).show();

    }
    public void showHelp(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("unit of height must be meter.");
        builder.setPositiveButton("oK", null);
        builder.show();
    }

    public void startScanner(View v){
        Intent intent = new Intent(this, ScannerActivity.class);
        startActivity(intent);
    }

    public void startWebService(View v){
        Intent intent = new Intent(this, WebServiceTest.class);
        startActivity(intent);
    }
}
