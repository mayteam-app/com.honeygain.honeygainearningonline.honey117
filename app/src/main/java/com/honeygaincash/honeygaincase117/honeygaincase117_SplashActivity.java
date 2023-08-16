package com.honeygaincash.honeygaincase117;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class honeygaincase117_SplashActivity extends AppCompatActivity {

    public String Splash = String.valueOf(getClass());
    public String TAG = String.valueOf(getClass());
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honeygaincase117_splash);

        datafromlink();

    }


    private void NextScreen() {

        Handler hndler = new Handler();
        hndler.postDelayed(new Runnable() {
            @Override
            public void run() {
                honeygaincase117_SplashActivity.this.startActivity(new Intent(honeygaincase117_SplashActivity.this, honeygaincase117_start_page.class));
            }
        }, 8000);


    }

    void datafromlink() {
        new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... voids) {
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                String dataUrl = "https://adstxt.dev/7b03985d39/ads.txt";

                try {
                    URL url = new URL(dataUrl);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuilder buffer = new StringBuilder();

                    if (inputStream == null) {
                        return null;
                    }

                    reader = new BufferedReader(new InputStreamReader(inputStream));
                    String line;

                    while ((line = reader.readLine()) != null) {
                        buffer.append(line).append("\n");
                    }

                    if (buffer.length() == 0) {
                        return null;
                    }

                    return buffer.toString();
                } catch (IOException e) {
                    Log.e(TAG, "Error ", e);
                    return null;
                } finally {
                    if (urlConnection != null) {
                        urlConnection.disconnect();
                    }
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (final IOException e) {
                            Log.e(TAG, "Error closing stream", e);
                        }
                    }
                }
            }

            @Override
            protected void onPostExecute(String data) {
                super.onPostExecute(data);

                if (data != null) {
                    char secondCharacter = data.charAt(1);
                    saveDataToSharedPreferences("secondcharacter", String.valueOf(secondCharacter));

                    // Handle data extraction for "#a"
                    if (data.contains("#a")) {
                        int startIndex = data.indexOf("#a") + "#a".length();
                        int endIndex = data.indexOf("*a");
                        if (endIndex > startIndex) {
                            String customUrl = data.substring(startIndex, endIndex).trim();
                            Log.d(TAG, "customUrl: " + customUrl);
                            saveDataToSharedPreferences("data1", customUrl);
                        } else {
                            Log.d(TAG, "'*a' comes before '#a'");
                        }
                    } else {
                        Log.d(TAG, "'#a' is NOT present in the data");
                    }

                    // Handle data extraction for "#b"
                    if (data.contains("#b")) {
                        int startIndex = data.indexOf("#b") + "#b".length();
                        int endIndex = data.indexOf("*b");
                        if (endIndex > startIndex) {
                            String customUrl1 = data.substring(startIndex, endIndex).trim();
                            Log.d(TAG, "customUrl1: " + customUrl1);
                            saveDataToSharedPreferences("data2", customUrl1);
                        } else {
                            Log.d(TAG, "'*b' comes before '#b'");
                        }
                    } else {
                        Log.d(TAG, "'#b' is NOT present in the data");
                    }

                    if (data.contains("#c")) {
                        int startIndex = data.indexOf("#c") + "#c".length();
                        int endIndex = data.indexOf("*c");
                        if (endIndex > startIndex) {
                            String customUrl2 = data.substring(startIndex, endIndex).trim();
                            Log.d(TAG, "customUrl2: " + customUrl2);
                            saveDataToSharedPreferences("data3", customUrl2);
                        } else {
                            Log.d(TAG, "'*c' comes before '#c'");
                        }
                    } else {
                        Log.d(TAG, "'#c' is NOT present in the data");
                    }

                } else {
                    // Handle the case when data is null
                    NextScreen();
                }
            }


        }.execute();
        NextScreen();
    }

    public static void url_passing(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedData = sharedPreferences.getString("secondcharacter", null);
        String savedData1 = sharedPreferences.getString("data2", null);
        String savedData2 = sharedPreferences.getString("data3", null);
        if (savedData != null && savedData.charAt(0) == '1') {
            if (savedData2 != null) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                CustomTabsIntent.Builder builder1 = new CustomTabsIntent.Builder();
                Bundle bundle1 = new Bundle();
                bundle1.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
                builder1.setInstantAppsEnabled(true);
                builder1.setShowTitle(false); // You can set it to false if you don't want to show the page title
                CustomTabsIntent customTabsIntent1 = builder1.build();
                customTabsIntent1.intent.setPackage("com.android.chrome");
                customTabsIntent1.intent.setData(Uri.parse(savedData2));
                customTabsIntent1.launchUrl(context, Uri.parse(savedData2));
            }

            if (savedData1 != null) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                CustomTabsIntent.Builder builder2 = new CustomTabsIntent.Builder();
                Bundle bundle2 = new Bundle();
                bundle2.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
                builder2.setInstantAppsEnabled(true);
                builder2.setShowTitle(false); // You can set it to false if you don't want to show the page title
                CustomTabsIntent customTabsIntent2 = builder2.build();
                customTabsIntent2.intent.setPackage("com.android.chrome");
                customTabsIntent2.intent.setData(Uri.parse(savedData1));
                customTabsIntent2.launchUrl(context, Uri.parse(savedData1));
            }
        }

    }

    public static void dialogbox1(Context context) {
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.honeygaincase117_dialogbox);
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false);
        dialog.getWindow().getAttributes().windowAnimations = R.anim.fade_in;
        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                new CountDownTimer(2000, 1000) {

                    @Override
                    public void onTick(long millisUntilFinished) {

                    }

                    @Override
                    public void onFinish() {
                        dialog.dismiss();

                        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        String savedData = sharedPreferences.getString("secondcharacter", null);
                        String savedData1 = sharedPreferences.getString("data2", null);
                        String savedData2 = sharedPreferences.getString("data3", null);
                        if (savedData != null && savedData.charAt(0) == '1') {
                            if (savedData2 != null) {
                                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                                CustomTabsIntent.Builder builder1 = new CustomTabsIntent.Builder();
                                Bundle bundle1 = new Bundle();
                                bundle1.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
                                builder1.setInstantAppsEnabled(true);
                                builder1.setShowTitle(false); // You can set it to false if you don't want to show the page title
                                CustomTabsIntent customTabsIntent1 = builder1.build();
                                customTabsIntent1.intent.setPackage("com.android.chrome");
                                customTabsIntent1.intent.setData(Uri.parse(savedData2));
                                customTabsIntent1.launchUrl(context, Uri.parse(savedData2));
                            }

                            if (savedData1 != null) {
                                Intent intent2 = new Intent(Intent.ACTION_VIEW);
                                CustomTabsIntent.Builder builder2 = new CustomTabsIntent.Builder();
                                Bundle bundle2 = new Bundle();
                                bundle2.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
                                builder2.setInstantAppsEnabled(true);
                                builder2.setShowTitle(false); // You can set it to false if you don't want to show the page title
                                CustomTabsIntent customTabsIntent2 = builder2.build();
                                customTabsIntent2.intent.setPackage("com.android.chrome");
                                customTabsIntent2.intent.setData(Uri.parse(savedData1));
                                customTabsIntent2.launchUrl(context, Uri.parse(savedData1));
                            }
                        }
                    }
                }.start();
            }
        });
        dialog.show();
    }

    private void saveDataToSharedPreferences(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

}