package com.example.junaid.apitestcopy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.junaid.apitestcopy.R;

public class NICUinformation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nicuinformation);
    }

    public void openNICUList(View view){
        Intent intent = new Intent(NICUinformation.this, NICUActivity.class);
        startActivity(intent);
    }
}
