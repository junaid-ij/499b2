package com.example.junaid.apitestcopy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.junaid.apitestcopy.R;

public class ICUinformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icuinformation);
    }

    public void openICUList(View view){
        Intent intent = new Intent(ICUinformation.this, ICUActivity.class);
        startActivity(intent);
    }

}
