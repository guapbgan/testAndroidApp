package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class ScannerActivity extends AppCompatActivity {

    TextView tContent;
    TextView tFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scanner);
        findViews();
    }

    private void findViews(){
        this.tContent = (TextView) findViewById(R.id.tContent);
        this.tFormat = (TextView) findViewById(R.id.tFormat);
    }

    public void scan(View v){
        IntentIntegrator scanIntegrator = new IntentIntegrator(this);
        scanIntegrator.setCameraId(0);
        scanIntegrator.initiateScan();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent){
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if(scanningResult != null){
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            this.tContent.setText(scanContent);
            this.tFormat.setText(scanFormat);
        }
        else{
            Toast.makeText(this, "nothing", Toast.LENGTH_LONG).show();
        }
    }
}
