package com.example.pj0412;

import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class JSONVolly {
    private Context context;

    public JSONVolly(Context context) {
        this.context = context;
    }

    public void request(String page, ListView listView, int type, boolean flag) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        StringRequest request = new StringRequest(Request.Method.GET, page, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONParser parser = new JSONParser(context, listView);
                parser.parsing(response, type, flag);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "통신 오류", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(request);
    }
}
