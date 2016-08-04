package com.android.jamalludin.uadapps4student;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView perwalian,simeru,tentang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        perwalian = (ImageView) findViewById(R.id.img_perwalian);
        perwalian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(MainActivity.this, Perwalian.class);
                startActivity(in);
            }
        });

        simeru = (ImageView)findViewById(R.id.img_simeru);
        simeru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sim = new Intent(MainActivity.this, Simeru.class);
                startActivity(sim);
            }
        });
        tentang = (ImageView)findViewById(R.id.img_tentang);
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ten = new Intent(MainActivity.this, TentangAplikasi.class);
                startActivity(ten);
            }
        });
    }
}
