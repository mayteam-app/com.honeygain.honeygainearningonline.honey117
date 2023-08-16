package com.honeygaincash.honeygaincase117;



import static com.honeygaincash.honeygaincase117.honeygaincase117_SplashActivity.dialogbox1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class honeygaincase117_Exit extends AppCompatActivity {
    public String TAG = String.valueOf(getClass());

    public void onBackPressed() {
        super.onBackPressed();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.honeygaincase117_exitactivity);

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


        Button button = (Button) findViewById(R.id.exitapp);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                honeygaincase117_Exit.this.startActivity(new Intent(honeygaincase117_Exit.this, honeygaincase117_Thank_you.class));

            }
        });
        Button button1 = (Button) findViewById(R.id.btn_no);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                honeygaincase117_Exit.this.startActivity(new Intent(honeygaincase117_Exit.this, honeygaincase117_start_page.class));
            }
        });
    }

}
