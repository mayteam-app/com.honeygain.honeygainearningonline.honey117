package com.honeygaincash.honeygaincase117;

import static com.honeygaincash.honeygaincase117.honeygaincase117_SplashActivity.url_passing;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class honeygaincase117_start_page extends AppCompatActivity {
    Button start;
    public String TAG = String.valueOf(getClass());
    private CountDownTimer countDownTimer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honeygaincase117_start_page);


        dialgbox();

        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.fragmentContainer, new honeygaincase117_WebViewFragment());
            fragmentTransaction.commit();
        }

        this.start = (Button) findViewById(R.id.start);

        this.start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                honeygaincase117_start_page.this.startActivity(new Intent(honeygaincase117_start_page.this, honeygaincase117_Next.class));

            }
        });
    }

    public void onBackPressed() {

        honeygaincase117_start_page.this.startActivity(new Intent(honeygaincase117_start_page.this, honeygaincase117_Exit.class));

    }

    private void startCountdown() {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedData = sharedPreferences.getString("secondcharacter", null);
        if (savedData != null && savedData.charAt(0) == '1') {
            countDownTimer = new CountDownTimer(10000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long secondsLeft = millisUntilFinished / 1000;
                    start.setText("Start (" + secondsLeft + ")");
                    start.setEnabled(false); // Disable the button during countdown
                }

                @Override
                public void onFinish() {
                    start.setText("Start");
                    start.setEnabled(true); // Enable the button after countdown completes
                }
            };

            countDownTimer.start();
        } else {
            countDownTimer = new CountDownTimer(5000, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long secondsLeft = millisUntilFinished / 1000;
                    start.setText("Start (" + secondsLeft + ")");
                    start.setEnabled(false); // Disable the button during countdown
                }

                @Override
                public void onFinish() {
                    start.setText("Start");
                    start.setEnabled(true); // Enable the button after countdown completes
                }
            };

            countDownTimer.start();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    private void dialgbox() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.honeygaincase117_dialogbox);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                new CountDownTimer(5000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        dialog.dismiss();
                        url_passing(honeygaincase117_start_page.this);
                        startCountdown();
                    }
                }.start();
            }
        });
        dialog.show();
    }



}