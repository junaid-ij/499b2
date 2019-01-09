package com.example.junaid.apitestcopy.activity;

import android.app.Activity;
import android.icu.util.ICUUncheckedIOException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.junaid.apitestcopy.helper.SQLiteHandler;
import com.example.junaid.apitestcopy.helper.SessionManager;
import com.example.junaid.apitestcopy.app.AppConfig;
import com.example.junaid.apitestcopy.app.AppController;


import java.util.HashMap;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.junaid.apitestcopy.R;

public class MainActivity extends AppCompatActivity {

    public   TextView txtName;
    public static TextView txtEmail;
    private Button btnLogout,btnAbout;

    private SQLiteHandler db;
    private SessionManager session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = (TextView) findViewById(R.id.name);
        txtEmail = (TextView) findViewById(R.id.email);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        btnAbout = (Button) findViewById(R.id.btnAbout);

        // SqLite database handler
        db = new SQLiteHandler(getApplicationContext());

        // session manager
        session = new SessionManager(getApplicationContext());

        if (!session.isLoggedIn()) {
            logoutUser();
        }

        // Fetching user details from sqlite
        HashMap<String, String> user = db.getUserDetails();

        String currentusername = user.get("name");
        String currentemail = user.get("email");

        // Displaying the user details on the screen
        txtName.setText(currentusername);
        txtEmail.setText(currentemail);

        // Logout button click event
        btnLogout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logoutUser();
            }
        });

        //about
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }

    public static String giveemail(){
        return txtEmail.toString();
    }

    /**
     * Logging out the user. Will set isLoggedIn flag to false in shared
     * preferences Clears the user data from sqlite users table
     * */
    private void logoutUser() {
        session.setLogin(false);

        db.deleteUsers();

        // Launching the login activity
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void openICUActivity(View view){
        Intent intent = new Intent(MainActivity.this, ICUinformation.class);
        startActivity(intent);
    }

    public void openCCUActivity(View view){
        Intent intent = new Intent(MainActivity.this, CCUinformation.class);
        startActivity(intent);
    }

    public void openNICUActivity(View view){
        Intent intent = new Intent(MainActivity.this, NICUinformation.class);
        startActivity(intent);
    }

    public void openNotifications(View view){
        Intent intent=new Intent(MainActivity.this,Notification.class);
    }
}
