package com.example.pj0412;

import android.content.Context;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JSONParser {
    private Context context;

    public JSONParser(Context context, ListView listView) {
        this.context = context;
        this.listView = listView;
    }

    private ListView listView;
    public void parsing(String json, int type, boolean flag){
        List<Language> languages = new ArrayList<>();
        try {
            JSONObject root = new JSONObject(json);
            JSONArray array = root.getJSONArray((String) root.names().get(0));
            for(int i = 0; i < array.length(); i++) {
                JSONObject object = array.getJSONObject(i);
                String name = object.getString((String) object.names().get(0));
                String imageurl = object.getString((String) object.names().get(1));
                String desc = object.getString((String) object.names().get(2));
                Language language = new Language(name, imageurl, desc);
                languages.add(language);
            }
            JSONAdapter adapter = new JSONAdapter(context, languages, type, flag);
            listView.setAdapter(adapter);
        } catch (JSONException e) {
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();;
        }
    }
}
