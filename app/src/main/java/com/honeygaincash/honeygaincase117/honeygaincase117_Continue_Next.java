package com.honeygaincash.honeygaincase117;

import static com.honeygaincash.honeygaincase117.honeygaincase117_SplashActivity.url_passing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;


import java.util.ArrayList;
import java.util.List;

public class honeygaincase117_Continue_Next extends AppCompatActivity {
    CardView i1, i2, i3, i4, i5, i6, i7, i8, i9, i10, i11, i12, i13, i14, i15;
    private SharedPreferences sharedPreferences;
    ImageView Q_1, Q_2;
    NativeBannerAd nativeBannerAd;
    FrameLayout nativeBannerContainer;
    private com.facebook.ads.AdView bannerAdContainer;
    LinearLayout adView1, L1, L2;
    FrameLayout nativeAdContainer;
    FrameLayout frameLayout;
    NativeAd nativeAd1;
    InterstitialAd interstitialAd;
    ProgressDialog progressDialog;
    public String TAG = String.valueOf(getClass());
    CardView A1;
    FrameLayout A2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.honeygaincase117_continue_next);

        A2 = findViewById(R.id.fl_b);


        loadfbNativeAd();
        showfbNativeBanner();
        showfbNativeBanner1();
        showfbNativeBanner2();

        ShowFullAds();


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


        ShowFullAds();


    }

    public static void inflateAd(NativeAd nativeAd, View adView, final Context context) {
        MediaView nativeAdIcon = (MediaView) adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = (TextView) adView.findViewById(R.id.native_ad_title);
        TextView nativeAdBody = (TextView) adView.findViewById(R.id.native_ad_body);
        MediaView nativeAdMedia = (MediaView) adView.findViewById(R.id.native_ad_media);
        TextView sponsoredLabel = (TextView) adView.findViewById(R.id.native_ad_sponsored_label);

        nativeAdMedia.setListener(new MediaViewListener() {
            @Override
            public void onVolumeChange(MediaView mediaView, float volume) {
                Log.e(honeygaincase117_SplashActivity.class.toString(), "MediaViewEvent: Volume " + volume);
            }

            @Override
            public void onPause(MediaView mediaView) {
                Log.e(honeygaincase117_SplashActivity.class.toString(), "MediaViewEvent: Paused");
            }

            @Override
            public void onPlay(MediaView mediaView) {
                Log.e(honeygaincase117_SplashActivity.class.toString(), "MediaViewEvent: Play");
            }

            @Override
            public void onFullscreenBackground(MediaView mediaView) {
                Log.e(honeygaincase117_SplashActivity.class.toString(), "MediaViewEvent: FullscreenBackground");
            }

            @Override
            public void onFullscreenForeground(MediaView mediaView) {
                Log.e(honeygaincase117_SplashActivity.class.toString(), "MediaViewEvent: FullscreenForeground");
            }

            @Override
            public void onExitFullscreen(MediaView mediaView) {
                Log.e(honeygaincase117_SplashActivity.class.toString(), "MediaViewEvent: ExitFullscreen");
            }

            @Override
            public void onEnterFullscreen(MediaView mediaView) {
                Log.e(honeygaincase117_SplashActivity.class.toString(), "MediaViewEvent: EnterFullscreen");
            }

            @Override
            public void onComplete(MediaView mediaView) {
                Log.e(honeygaincase117_SplashActivity.class.toString(), "MediaViewEvent: Completed");
            }
        });

        TextView nativeAdSocialContext = (TextView) adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdCallToAction = (TextView) adView.findViewById(R.id.native_ad_call_to_action);
        LinearLayout L1 = (LinearLayout) adView.findViewById(R.id.L1);
        L1.setVisibility(View.VISIBLE);

        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        List< View > clickableViews = new ArrayList<>();

        clickableViews.add(nativeAdCallToAction);
        clickableViews.add(L1);
        nativeAd.registerViewForInteraction(adView, nativeAdMedia, nativeAdIcon, clickableViews);

        NativeAdBase.NativeComponentTag.tagView(nativeAdIcon, NativeAdBase.NativeComponentTag.AD_ICON);
        NativeAdBase.NativeComponentTag.tagView(nativeAdTitle, NativeAdBase.NativeComponentTag.AD_TITLE);
        NativeAdBase.NativeComponentTag.tagView(nativeAdBody, NativeAdBase.NativeComponentTag.AD_BODY);
        NativeAdBase.NativeComponentTag.tagView(nativeAdSocialContext, NativeAdBase.NativeComponentTag.AD_SOCIAL_CONTEXT);
        NativeAdBase.NativeComponentTag.tagView(nativeAdCallToAction, NativeAdBase.NativeComponentTag.AD_CALL_TO_ACTION);
    }

    public void loadfbNativeAd() {
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String nativeid = sharedPreferences.getString("nativeid", null);

        Log.e(TAG, "fbnative1 " + nativeid);
        nativeAdContainer = findViewById(R.id.fl_adplaceholder);
        LayoutInflater inflater = this.getLayoutInflater();
        adView1 = (LinearLayout) inflater.inflate(R.layout.honeygaincase117_native_ad_layout2, nativeAdContainer, false);
        nativeAdContainer.addView(adView1);
        nativeAd1 = new NativeAd(getApplicationContext(), nativeid);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                Log.e("fbnative1==>", "onMediaDownloaded: ");

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                //  nativeAdContainer.setVisibility(View.GONE);
                Log.e("fbnative1==>", adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.e("fbnative1==>", "onAdLoaded: ");
                if (nativeAd1 == null || nativeAd1 != ad) {

                    return;
                }


                inflateAd(nativeAd1, adView1, getApplicationContext());
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.e("fbnative1==>", "onAdClicked: ");


            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.e("fbnative1==>", "onLoggingImpression: ");

            }
        };

        nativeAd1.loadAd(
                nativeAd1.buildLoadAdConfig()
                        .withAdListener(nativeAdListener)
                        .build());


    }

   public void showfbNativeBanner() {

        if (honeygaincase117_SplashActivity.nativeBannerAd.isAdLoaded()) {
            
            View adView = NativeBannerAdView.render(this, honeygaincase117_SplashActivity.nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
            nativeBannerContainer = (FrameLayout) findViewById(R.id.fl_b);
            // Add the Native Banner Ad View to your ad container
            nativeBannerContainer.addView(adView);
        } else {
            
            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String Bannerid = sharedPreferences.getString("Bannerid", null);
            nativeBannerContainer = (FrameLayout) findViewById(R.id.fl_b);
            nativeBannerAd = new NativeBannerAd(this, Bannerid);
            Log.e(TAG, "fbnativebanner16 " + Bannerid);
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {

                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e(TAG, "fbnativebanner 16 " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {
                    
                    Log.e(TAG, "Native ad is loaded and ready to be displayed!");
                    View adView = NativeBannerAdView.render(getApplicationContext(), nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
                    // Add the Native Banner Ad View to your ad container
                    nativeBannerContainer.addView(adView);
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
    }
   public void showfbNativeBanner1() {

        if (honeygaincase117_SplashActivity.nativeBannerAd.isAdLoaded()) {

            View adView = NativeBannerAdView.render(this, honeygaincase117_SplashActivity.nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
            nativeBannerContainer = (FrameLayout) findViewById(R.id.flb_1);
            // Add the Native Banner Ad View to your ad container
            nativeBannerContainer.addView(adView);
        } else {

            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String Bannerid = sharedPreferences.getString("Bannerid", null);
            nativeBannerContainer = (FrameLayout) findViewById(R.id.flb_1);
            nativeBannerAd = new NativeBannerAd(this, Bannerid);
            Log.e(TAG, "fbnativebanner16 " + Bannerid);
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {

                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e(TAG, "fbnativebanner 16 " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {

                    Log.e(TAG, "Native ad is loaded and ready to be displayed!");
                    View adView = NativeBannerAdView.render(getApplicationContext(), nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
                    // Add the Native Banner Ad View to your ad container
                    nativeBannerContainer.addView(adView);
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
    }
   public void showfbNativeBanner2() {

        if (honeygaincase117_SplashActivity.nativeBannerAd.isAdLoaded()) {

            View adView = NativeBannerAdView.render(this, honeygaincase117_SplashActivity.nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
            nativeBannerContainer = (FrameLayout) findViewById(R.id.flb_2);
            // Add the Native Banner Ad View to your ad container
            nativeBannerContainer.addView(adView);
        } else {

            sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
            String Bannerid = sharedPreferences.getString("Bannerid", null);
            nativeBannerContainer = (FrameLayout) findViewById(R.id.flb_2);
            nativeBannerAd = new NativeBannerAd(this, Bannerid);
            Log.e(TAG, "fbnativebanner16 " + Bannerid);
            NativeAdListener nativeAdListener = new NativeAdListener() {
                @Override
                public void onMediaDownloaded(Ad ad) {

                }

                @Override
                public void onError(Ad ad, AdError adError) {
                    Log.e(TAG, "fbnativebanner 16 " + adError.getErrorMessage());
                }

                @Override
                public void onAdLoaded(Ad ad) {

                    Log.e(TAG, "Native ad is loaded and ready to be displayed!");
                    View adView = NativeBannerAdView.render(getApplicationContext(), nativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
                    // Add the Native Banner Ad View to your ad container
                    nativeBannerContainer.addView(adView);
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
    }

  
    public void ShowFullAds() {
        sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String full = sharedPreferences.getString("full", null);
        Log.e(TAG, "fbfull2 " + full);
        try {
            if (honeygaincase117_SplashActivity.interstitialAd1 != null && honeygaincase117_SplashActivity.interstitialAd1.isAdLoaded()) {
                honeygaincase117_SplashActivity.interstitialAd1.show();

            } else if (honeygaincase117_SplashActivity.interstitialAd2 != null && honeygaincase117_SplashActivity.interstitialAd2.isAdLoaded()) {
                honeygaincase117_SplashActivity.interstitialAd2.show();
                honeygaincase117_SplashActivity.interstitialAd1.loadAd();
            } else {
                honeygaincase117_SplashActivity.interstitialAd1.loadAd();
                honeygaincase117_SplashActivity.interstitialAd2.loadAd();
                interstitialAd = new InterstitialAd(this, full);
                InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {


                    @Override
                    public void onInterstitialDisplayed(Ad ad) {

                    }

                    @Override
                    public void onInterstitialDismissed(Ad ad) {
                        // Interstitial dismissed callback
                        Log.e(TAG, "fbfull2 " + "Interstitial ad dismissed.");
                    }

                    @Override
                    public void onError(Ad ad, AdError adError) {
                        // Ad error callback
                        Log.e(TAG, "fbfull2" + adError.getErrorMessage());

                    }

                    @Override
                    public void onAdLoaded(Ad ad) {
                        Log.d(TAG, "fbfull2 " + "Interstitial ad is loaded and ready to be diSplash_screenlayed!");
                        if (interstitialAd != null && interstitialAd.isAdLoaded())
                            interstitialAd.show();
                    }

                    @Override
                    public void onAdClicked(Ad ad) {
                        // Ad clicked callback
                        Log.d(TAG, "fbfull2 " + "Interstitial ad clicked!");
                    }

                    @Override
                    public void onLoggingImpression(Ad ad) {
                        // Ad impression logged callback
                        Log.d(TAG, "fbfull2 " + "Interstitial ad impression logged!");
                    }
                };

                interstitialAd.loadAd(
                        interstitialAd.buildLoadAdConfig()
                                .withAdListener(interstitialAdListener)
                                .build());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        url_passing(this);
    }

}