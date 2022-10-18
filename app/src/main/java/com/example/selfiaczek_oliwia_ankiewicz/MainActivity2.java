package com.example.selfiaczek_oliwia_ankiewicz;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.google.android.material.animation.DrawableAlphaProperty;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        byte[] byteArray = getIntent().getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView img = findViewById(R.id.img);
        img.setImageBitmap(bmp);
        SeekBar rotate1 = findViewById(R.id.rotateX);
        SeekBar rotate2 = findViewById(R.id.rotateY);
        SeekBar rotate = findViewById(R.id.rotate);
        SeekBar opacity = findViewById(R.id.Opacity);
        SeekBar r = findViewById(R.id.red);
        SeekBar g = findViewById(R.id.green);
        SeekBar b = findViewById(R.id.blue);
        ImageView zielony = findViewById(R.id.zielony);
        ImageView czerwony = findViewById(R.id.czerwony);
        ImageView niebieski = findViewById(R.id.niebieski);
        czerwony.setVisibility(View.INVISIBLE);
        niebieski.setVisibility(View.INVISIBLE);
        zielony.setVisibility(View.INVISIBLE);
        opacity.setProgress(255);
        //ROTACJA ZDJECIA
        rotate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {img.setRotation(seekBar.getProgress());}
        });
        //ROTACJA KĄT NACHYLENIA X
        rotate1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {img.setRotationX(seekBar.getProgress());}
        });
        //ROTACJA KĄT NACHYLENIA Y
        rotate2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {img.setRotationY(seekBar.getProgress());}
        });
        //PRZEZROCZYSTOSC
        opacity.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {img.setAlpha(seekBar.getProgress());}
        });
        r.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                czerwony.setVisibility(View.VISIBLE);
                czerwony.setAlpha(seekBar.getProgress());}
        });
        g.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {zielony.setVisibility(View.VISIBLE);
            zielony.setAlpha(seekBar.getProgress());}
        });
        b.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                niebieski.setVisibility(View.VISIBLE);
                niebieski.setAlpha(seekBar.getProgress());
                }
        });
    }
}