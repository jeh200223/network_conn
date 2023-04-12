package com.example.pj0412;

import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;

public class JSONFastNetwork{
    private Context context;

    public JSONFastNetwork(Context context) {
        this.context = context;
    }

    public void request(String page, ListView listView, int type, boolean flag) {
        AndroidNetworking.initialize(context);
        AndroidNetworking.get(page).build().getAsString(new StringRequestListener() {
            @Override
            public void onResponse(String response) {
                JSONParser parser = new JSONParser(context, listView);
                parser.parsing(response, type, flag);
            }

            @Override
            public void onError(ANError anError) {
                Toast.makeText(context, "통신 오류", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
