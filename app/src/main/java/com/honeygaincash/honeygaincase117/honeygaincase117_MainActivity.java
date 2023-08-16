package com.honeygaincash.honeygaincase117;

import static com.honeygaincash.honeygaincase117.honeygaincase117_SplashActivity.dialogbox1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class honeygaincase117_MainActivity extends AppCompatActivity {
    Button btnStart, btnShare, btnRate;

    public String TAG = String.valueOf(getClass());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honeygaincase117_main);

        dialogbox1(this);

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainer1, new honeygaincase117_WebViewFragment1());
            fragmentTransaction.add(R.id.fragmentContainer2, new honeygaincase117_WebViewFragment1());
            fragmentTransaction.add(R.id.fragmentContainer3, new honeygaincase117_WebViewFragment1());
            fragmentTransaction.add(R.id.fragmentContainer4, new honeygaincase117_WebViewFragment1());
            fragmentTransaction.add(R.id.fragmentContainer5, new honeygaincase117_WebViewFragment1());
            fragmentTransaction.commit();
        }


        btnStart = findViewById(R.id.btnStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(honeygaincase117_MainActivity.this, honeygaincase117_MainActivity2.class);
                startActivity(i);
            }
        });

        btnShare = findViewById(R.id.btnShare);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    String shareMessage = "Download Honey Gain\n\n";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + getPackageName();
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch (Exception e) {
                }
            }
        });



        btnRate = findViewById(R.id.btnrate);
        btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("market://details?id=" + getPackageName());
                Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    startActivity(myAppLinkToMarket);
                } catch (ActivityNotFoundException e) {
                }
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();

    }




}