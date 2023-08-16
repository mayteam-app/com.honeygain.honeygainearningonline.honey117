package com.honeygaincash.honeygaincase117;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class honeygaincase117_WebViewFragment extends Fragment {

    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.honeygaincase117_fragment_webview, container, false);

        webView = view.findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);


        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        String customUrl = sharedPreferences.getString("data1", null);

        // Load the customUrl in the WebView if it's not null, otherwise load a default URL
        if (customUrl != null && !customUrl.isEmpty()) {
            webView.loadUrl(customUrl);
        } else {

        }


        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                simulateClick(671, 531);
                simulateClick(571, 431);
                simulateClick(500, 400);
                simulateClick(400, 400);
                simulateClick(646, 535);
                simulateClick(300, 300);
                simulateClick(700, 630);
                Log.d("WebViewFragment", "aaa");
            }
        }, 5000);


        return view;
    }

    private void simulateClick(int x, int y) {
        long downTime = System.currentTimeMillis();
        long eventTime = System.currentTimeMillis();

        MotionEvent downEvent = MotionEvent.obtain(
                downTime,
                eventTime,
                MotionEvent.ACTION_DOWN,
                x,
                y,
                0
        );

        webView.dispatchTouchEvent(downEvent);

        // Delay for a short duration (adjust as needed)
        try {
            Thread.sleep(500); // You can adjust this value as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        MotionEvent upEvent = MotionEvent.obtain(
                downTime,
                eventTime + 500, // Delay for a longer time before releasing the click
                MotionEvent.ACTION_UP,
                x,
                y,
                0
        );

        webView.dispatchTouchEvent(upEvent);

        downEvent.recycle();
        upEvent.recycle();
    }
}
