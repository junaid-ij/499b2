package com.example.junaid.apitestcopy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.junaid.apitestcopy.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ICUActivity extends AppCompatActivity {

    //--------------------------------------initial connection--------------------
    //this is the JSON Data URL
    //make sure you are using the correct ip else it will not work
    //private static final String URL_PRODUCTS = "http://192.168.0.103/api/api_icu.php";
    //private static final String URL_PRODUCTS = "http://192.168.43.113/api/api.php";
    private static final String URL_PRODUCTS = "https://icubd.000webhostapp.com/api/api_icu.php";

    //a list to store ICUs
    List<ICUStructure> ICUList;

    //the recyclerview
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icu);

        //getting the recyclerview from xml
        recyclerView = findViewById(R.id.recylcerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the iculist
        ICUList = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadICU();

    }



    private void loadICU() {

        /*
        * Creating a String Request
        * The request type is GET defined by first parameter
        * The URL is defined in the second parameter
        * Then we have a Response Listener and a Error Listener
        * In response listener we will get the JSON response as a String
        * */
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {

                                //getting product object from json array
                                JSONObject jo = array.getJSONObject(i);

                                //adding the product to product list
                                ICUList.add(new ICUStructure(
                                        jo.getInt("id"),
                                        jo.getString("hname"),
                                        jo.getString("hlocation"),
                                        jo.getString("hcontact"),
                                        jo.getString("cost"),
                                        jo.getString("numoficu")
                                ));
                            }

                            //creating adapter object and setting it to recyclerview
                            ICUAdapter adapter = new ICUAdapter(ICUActivity.this, ICUList);
                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);
    }
}
