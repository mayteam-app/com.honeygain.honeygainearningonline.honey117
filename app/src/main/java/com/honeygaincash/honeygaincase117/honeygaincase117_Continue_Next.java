package com.honeygaincash.honeygaincase117;

import static com.honeygaincash.honeygaincase117.honeygaincase117_SplashActivity.dialogbox1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class honeygaincase117_Continue_Next extends AppCompatActivity {
    CardView i1, i2, i3, i4, i5, i6 ;
    public String TAG = String.valueOf(getClass());

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honeygaincase117_continue_next);

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



        i1 = findViewById(R.id.q1);
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getString(R.string.text1);
                Bundle basket = new Bundle();
                basket.putString("abc", s);
                Intent a = new Intent(honeygaincase117_Continue_Next.this, honeygaincase117_DetailsActivity.class);
                a.putExtras(basket);
                startActivity(a);
            }
        });
        i2 = findViewById(R.id.q2);
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getString(R.string.text2);
                Bundle basket = new Bundle();
                basket.putString("abc", s);
                Intent a = new Intent(honeygaincase117_Continue_Next.this, honeygaincase117_DetailsActivity.class);
                a.putExtras(basket);
                startActivity(a);
            }
        });

        i3 = findViewById(R.id.q3);
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getString(R.string.text3);
                Bundle basket = new Bundle();
                basket.putString("abc", s);
                Intent a = new Intent(honeygaincase117_Continue_Next.this, honeygaincase117_DetailsActivity.class);
                a.putExtras(basket);
                startActivity(a);
            }
        });
        i4 = findViewById(R.id.q4);
        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getString(R.string.text4);
                Bundle basket = new Bundle();
                basket.putString("abc", s);
                Intent a = new Intent(honeygaincase117_Continue_Next.this, honeygaincase117_DetailsActivity.class);
                a.putExtras(basket);
                startActivity(a);
            }
        });
        i5 = findViewById(R.id.q5);
        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getString(R.string.text5);
                Bundle basket = new Bundle();
                basket.putString("abc", s);
                Intent a = new Intent(honeygaincase117_Continue_Next.this, honeygaincase117_DetailsActivity.class);
                a.putExtras(basket);
                startActivity(a);
            }
        });
        i6 = findViewById(R.id.q6);
        i6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = getString(R.string.text6);
                Bundle basket = new Bundle();
                basket.putString("abc", s);
                Intent a = new Intent(honeygaincase117_Continue_Next.this, honeygaincase117_DetailsActivity.class);
                a.putExtras(basket);
                startActivity(a);
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

}