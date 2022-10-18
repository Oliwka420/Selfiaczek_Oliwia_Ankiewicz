package com.example.selfiaczek_oliwia_ankiewicz;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    ImageView Imageview;
    Button btn, przejdz_edycja;
    byte[] byteArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        przejdz_edycja = findViewById(R.id.btn2);
        przejdz_edycja.setBackgroundColor(Color.parseColor("#808080"));
        przejdz_edycja.setEnabled(false);
        Imageview = findViewById(R.id.img);
        btn = findViewById(R.id.btn);

        if(ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                Manifest.permission.CAMERA
            },100);
        }
        btn.setOnClickListener(view -> {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 100);
            btn.setHint("ZROB PHOTO PONOWNIE");
        });
        przejdz_edycja.setOnClickListener(view -> {
            Intent i = new Intent(view.getContext(), MainActivity2.class);
            i.putExtra("image",byteArray);
            startActivity(i);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 100){
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            Imageview.setImageBitmap(bitmap);

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byteArray = stream.toByteArray();

            przejdz_edycja.setBackgroundColor(Color.parseColor("#000000"));
            przejdz_edycja.setEnabled(true);
        }
    }
}