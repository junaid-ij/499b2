package com.example.junaid.apitestcopy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import com.example.junaid.apitestcopy.R;
import com.example.junaid.apitestcopy.app.AppConfig;
import com.example.junaid.apitestcopy.app.AppController;
import com.example.junaid.apitestcopy.helper.SQLiteHandler;
import com.example.junaid.apitestcopy.helper.SessionManager;


import com.example.junaid.apitestcopy.activity.MainActivity;

public class ApplicationForm extends AppCompatActivity {

    private SQLiteHandler db;
    private SessionManager session;

    private static final String TAG = ApplicationForm.class.getSimpleName();

    EditText p_name,p_age,p_gender,p_bg,p_address,p_phn,p_ephn,p_occupation,p_email,
            p_refby,p_disease, p_disduration,p_reason;

    Button form_submit;

    static String forhospital;
    static String careunit;
    //static String pname;

    private ProgressDialog pDialog;

    public static void getinfo(String hos, String unit){
        forhospital=hos;
        careunit=unit;
       // pname=pname;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_form);


        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);


        p_name=(EditText)findViewById(R.id.p_name_input);
        p_age=(EditText)findViewById(R.id.p_age_input);
        p_gender=(EditText)findViewById(R.id.p_gender_input);
        p_bg=(EditText)findViewById(R.id.p_bg_input);
        p_address=(EditText)findViewById(R.id.p_address_input);
        p_phn=(EditText)findViewById(R.id.p_phn_input);
        p_ephn=(EditText)findViewById(R.id.p_ephn_input);
        p_occupation=(EditText)findViewById(R.id.p_occupation_input);
        p_email=(EditText)findViewById(R.id.p_email_input);
        p_refby=(EditText)findViewById(R.id.p_refby_input);
        p_disease=(EditText)findViewById(R.id.p_disease_input);
        p_disduration=(EditText)findViewById(R.id.p_disduration_input);
        p_reason=(EditText)findViewById(R.id.p_reason_input);
        form_submit=(Button)findViewById(R.id.form_submit);

        //get user information

         final String fromuseremail= MainActivity.giveemail();




        //get hospital name and care unit name


        form_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String url = "https://icubd.000webhostapp.com/api/insertform.php";


                StringRequest sq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String > getParams(){
                        Map<String, String> parr = new HashMap<String, String>();

                        parr.put("name", p_name.getText().toString());
                        parr.put("age", p_age.getText().toString());
                        parr.put("gender", p_gender.getText().toString());
                        parr.put("bg", p_bg.getText().toString());
                        parr.put("address", p_address.getText().toString());
                        parr.put("phone", p_phn.getText().toString());
                        parr.put("ephone", p_ephn.getText().toString());
                        parr.put("occupation", p_occupation.getText().toString());
                        parr.put("email", p_email.getText().toString());
                        parr.put("refby", p_refby.getText().toString());
                        parr.put("disease", p_disease.getText().toString());
                        parr.put("duration", p_disduration.getText().toString());
                        parr.put("reason", p_reason.getText().toString());
                        //parr.put("fromuseremail", MainActivity.giveemail());
                        parr.put("forhospital", forhospital);
                        parr.put("careunit", careunit);



                        return parr;

                    }

                };

                //if (){}



                AppController.getInstance().addToRequestQueue(sq);
                Toast.makeText(getApplicationContext(), "form submitted", Toast.LENGTH_LONG).show();

                //send email work
                Intent m=new Intent(ApplicationForm.this,MainActivity.class);
                startActivity(m);


            }

        });









}
}
