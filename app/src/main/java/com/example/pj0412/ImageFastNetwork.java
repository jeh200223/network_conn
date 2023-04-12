package com.example.pj0412;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.BitmapRequestListener;

public class ImageFastNetwork {
    private Context context;

    public ImageFastNetwork(Context context) {
        this.context = context;
    }
    public void request(String page, ImageView imageView) {
        AndroidNetworking.initialize(context);
        AndroidNetworking.get(page).build().getAsBitmap(new BitmapRequestListener() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }

            @Override
            public void onError(ANError anError) {
                Toast.makeText(context, "통신 오류", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
