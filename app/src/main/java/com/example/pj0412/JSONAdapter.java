package com.example.pj0412;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.List;

public class JSONAdapter extends ArrayAdapter<Language> {
    private Context context;
    private List<Language> languages;
    private int type;
    private boolean flag;

    public JSONAdapter(@NonNull Context context, List<Language> languages, int type, boolean flag) {
        super(context, R.layout.item_list, languages);
        this.context = context;
        this.languages = languages;
        this.type = type;
        this.flag = flag;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.item_list, null, true);
        TextView textView = convertView.findViewById(R.id.textview1);
        ImageView imageView = convertView.findViewById(R.id.imageview);
        TextView textView1 = convertView.findViewById(R.id.textview2);
        Language language = languages.get(position);

        textView.setText(language.getName());
        textView1.setText(language.getDesc());
        if(flag) {
            if (type == 1) {
                ImageVolly volly = new ImageVolly(context);
                volly.request(language.getImageUrl(), imageView);
            } else {
                ImageFastNetwork fastNetwork = new ImageFastNetwork(context);
                fastNetwork.request(language.getImageUrl(), imageView);
            }
        }else {
            Glide.with(context)
                    .load(language.getImageUrl())
                    .into(imageView);
        }
        return convertView;
    }
}
