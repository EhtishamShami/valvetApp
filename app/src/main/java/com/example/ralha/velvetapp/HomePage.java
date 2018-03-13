package com.example.ralha.velvetapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;


public class HomePage extends AppCompatActivity {

    // DEFIND ATT
    public ImageView imageView2;

    TabLayout mTablayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
        imageView2 = findViewById(R.id.imageView2);


        mTablayout=(TabLayout)findViewById(R.id.filter);

        mTablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                switch (tab.getPosition())
                {
                    case 0:


                        break;
                    case 1:
                        Intent intent=new Intent(HomePage.this,Fill_leanding.class);
                        startActivity(intent);
                        break;

                    case 2:
                        break;

                    case 3:
                        break;
                    default:
                        break;
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }


        });


    }// CLOSE ONcREATE METHOD

    public void onClick(ImageView imgView) {
        if (imgView == imageView2) {
           startActivity(new Intent(getApplicationContext(), Fill_leanding.class));
         }

    }// CLOSE ONCLICK METHOD
}
