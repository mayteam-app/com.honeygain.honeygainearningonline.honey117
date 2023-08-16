package com.honeygaincash.honeygaincase117;


import static com.honeygaincash.honeygaincase117.honeygaincase117_SplashActivity.dialogbox1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;



public class honeygaincase117_MainActivity2 extends AppCompatActivity {

    Button btn1;
    public String TAG = String.valueOf(getClass());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honeygaincase117_main2);

        dialogbox1(this);


        btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(honeygaincase117_MainActivity2.this, honeygaincase117_Continue_Next.class);
                startActivity(i);
            }
        });


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

    }

    public void onBackPressed() {
        super.onBackPressed();
    }

}

