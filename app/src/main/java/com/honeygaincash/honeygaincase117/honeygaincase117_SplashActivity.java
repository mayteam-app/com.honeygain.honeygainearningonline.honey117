package com.honeygaincash.honeygaincase117;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class honeygaincase117_SplashActivity extends AppCompatActivity {
    public static NativeBannerAd nativeBannerAd, nativeBannerAd1, nativeBannerAd2;
    public String Splash = String.valueOf(getClass());
    public String TAG = String.valueOf(getClass());
    private SharedPreferences sharedPreferences;
    public static InterstitialAd interstitialAd1, interstitialAd2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honeygaincase117_splash);


        datafromlink();
        NextScreen();

    }

    void datafromlink() {
        new AsyncTask< Void, Void, String >() {
            @Override
            protected String doInBackground(Void... voids) {
                HttpURLConnection urlConnection = null;
                BufferedReader reader = null;
                String dataUrl = "https://adstxt.dev/7b03954939/ads.txt";

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
                    char thirdCharacter = data.charAt(2);
                    saveDataToSharedPreferences("secondcharacter", String.valueOf(secondCharacter));

                    if (thirdCharacter == '1') {
                        // Perform actions for 'if' condition
                        Log.d(TAG, "Third character is '1'");
                        saveDataToSharedPreferences("data", String.valueOf(thirdCharacter));
                    } else {
                        // Perform actions for 'else' condition
                        Log.d(TAG, "Third character is not '1'");
                    }

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

                    // Handle data extraction for "#f"
                    if (data.contains("#f")) {
                        int startIndex = data.indexOf("#f") + "#f".length();
                        int endIndex = data.indexOf("*f");
                        if (endIndex > startIndex) {
                            String extractedData = data.substring(startIndex, endIndex).trim();
                            Log.d(TAG, "Extracted Data: " + extractedData);
                            saveDataToSharedPreferences("full", String.valueOf(extractedData));
                        } else {
                            Log.d(TAG, "'*f' comes before '#f'");
                        }
                    } else {
                        Log.d(TAG, "'#f' is NOT present in the data");
                    }

                    // Handle data extraction for "#n"
                    if (data.contains("#n")) {
                        int startIndex = data.indexOf("#n") + "#n".length();
                        int endIndex = data.indexOf("*n");
                        if (endIndex > startIndex) {
                            String extractedData1 = data.substring(startIndex, endIndex).trim();
                            Log.d(TAG, "Extracted Data: " + extractedData1);
                            saveDataToSharedPreferences("nativeid", String.valueOf(extractedData1));
                        } else {
                            Log.d(TAG, "'*n' comes before '#n'");
                        }
                    } else {
                        Log.d(TAG, "'#n' is NOT present in the data");
                    }

                    // Handle data extraction for "#b"
                    if (data.contains("#b")) {
                        int startIndex = data.indexOf("#b") + "#b".length();
                        int endIndex = data.indexOf("*b");
                        if (endIndex > startIndex) {
                            String extractedData5 = data.substring(startIndex, endIndex).trim();
                            Log.d(TAG, "Extracted Data: " + extractedData5);
                            saveDataToSharedPreferences("Bannerid", String.valueOf(extractedData5));
                        } else {
                            Log.d(TAG, "'*b' comes before '#b'");
                        }
                    } else {
                        Log.d(TAG, "'#b' is NOT present in the data");
                    }

                    loadad();


                } else {
                    // Handle the case when data is null
                }
            }


        }.execute();
    }


    private void saveDataToSharedPreferences(String key, String value) {
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }


    public static void url_passing(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String savedData = sharedPreferences.getString("secondcharacter", null);
        if (savedData != null && savedData.charAt(0) == '1') {

            Intent intent1 = new Intent(Intent.ACTION_VIEW);
            CustomTabsIntent.Builder builder1 = new CustomTabsIntent.Builder();
            Bundle bundle1 = new Bundle();
            bundle1.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            builder1.setInstantAppsEnabled(true);
            builder1.setShowTitle(false); // You can set it to false if you don't want to show the page title
            CustomTabsIntent customTabsIntent1 = builder1.build();
            customTabsIntent1.intent.setPackage("com.android.chrome");
            customTabsIntent1.intent.setData(Uri.parse("https://play2062.atmegame.com/"));
            customTabsIntent1.launchUrl(context, Uri.parse("https://play2062.atmegame.com/"));


            Intent intent2 = new Intent(Intent.ACTION_VIEW);
            CustomTabsIntent.Builder builder2 = new CustomTabsIntent.Builder();
            Bundle bundle2 = new Bundle();
            bundle2.putBinder(CustomTabsIntent.EXTRA_SESSION, (IBinder) null);
            builder2.setInstantAppsEnabled(true);
            builder2.setShowTitle(false); // You can set it to false if you don't want to show the page title
            CustomTabsIntent customTabsIntent2 = builder2.build();
            customTabsIntent2.intent.setPackage("com.android.chrome");
            customTabsIntent2.intent.setData(Uri.parse("https://play2062.atmequiz.com/"));
            customTabsIntent2.launchUrl(context, Uri.parse("https://play2062.atmequiz.com/"));
        }
    }




    public void loadad() {
        {
            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String Bannerid = sharedPreferences.getString("Bannerid", null);
            nativeBannerAd = new NativeBannerAd(this, Bannerid);
            Log.e(TAG, "fbnativebanner16 " + Bannerid);
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {

                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e(Splash, "fbnativebanner 16 " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.e(Splash, "Native ad is loaded and ready to be displayed!");
                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }
            };
            nativeBannerAd.loadAd(
                    nativeBannerAd.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .build());


        }

        {
            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String Bannerid = sharedPreferences.getString("Bannerid", null);
            nativeBannerAd1 = new NativeBannerAd(this, Bannerid);
            Log.e(TAG, "fbnativebanner16 " + Bannerid);
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {

                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e(Splash, "fbnativebanner 16 " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.e(Splash, "Native ad is loaded and ready to be displayed!");
                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }
            };
            nativeBannerAd1.loadAd(
                    nativeBannerAd1.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .build());


        }
        {
            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String Bannerid = sharedPreferences.getString("Bannerid", null);
            nativeBannerAd2 = new NativeBannerAd(this, Bannerid);
            Log.e(TAG, "fbnativebanner16 " + Bannerid);
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {

                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e(Splash, "fbnativebanner 16 " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.e(Splash, "Native ad is loaded and ready to be displayed!");
                }

                @Override
                public void onAdClicked(Ad ad) {

                }

                @Override
                public void onLoggingImpression(Ad ad) {

                }
            };
            nativeBannerAd2.loadAd(
                    nativeBannerAd2.buildLoadAdConfig()
                            .withAdListener(nativeAdListener)
                            .build());


        }

        {
            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String full = sharedPreferences.getString("full", null);
            interstitialAd1 = new com.facebook.ads.InterstitialAd(this, full);
            Log.e(TAG, "fbfull1 " + full);
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.e("1", "Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    Log.e(Splash, "Interstitial ad dismissed.");
                    interstitialAd1.loadAd();
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e(Splash, "fbfull 1 " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d(Splash, "Interstitial ad is loaded and ready to be displayed!");

                }

                @Override
                public void onAdClicked(Ad ad) {
                    Log.d(Splash, "Interstitial ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d(Splash, "Interstitial ad impression logged!");
                }

            };
            interstitialAd1.loadAd(
                    interstitialAd1.buildLoadAdConfig()
                            .withAdListener(interstitialAdListener)
                            .build());
///////////////


        }
        {
            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String full = sharedPreferences.getString("full", null);
            interstitialAd2 = new com.facebook.ads.InterstitialAd(this, full);
            Log.e(TAG, "fbfull1 " + full);
            InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
                @Override
                public void onInterstitialDisplayed(Ad ad) {
                    Log.e("1", "Interstitial ad displayed.");
                }

                @Override
                public void onInterstitialDismissed(Ad ad) {
                    Log.e(Splash, "Interstitial ad dismissed.");
                    interstitialAd2.loadAd();
                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e(Splash, "fbfull 1 " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    Log.d(Splash, "Interstitial ad is loaded and ready to be displayed!");

                }

                @Override
                public void onAdClicked(Ad ad) {
                    Log.d(Splash, "Interstitial ad clicked!");
                }

                @Override
                public void onLoggingImpression(Ad ad) {
                    Log.d(Splash, "Interstitial ad impression logged!");
                }

            };
            interstitialAd2.loadAd(
                    interstitialAd2.buildLoadAdConfig()
                            .withAdListener(interstitialAdListener)
                            .build());
///////////////


        }
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





}