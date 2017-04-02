package com.att.tsa;

import android.app.Application;

import com.tsengvn.typekit.Typekit;


/**
 * @author Rajesh Pattanaik
 */

public class MainApp extends Application {
    private static MainApp sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;

        // Typekit Configuration
        Typekit.getInstance()
                .addNormal(Typekit.createFromAsset(this, "fonts/Roboto-Regular.ttf"))
                .addItalic(Typekit.createFromAsset(this, "fonts/Roboto-Italic.ttf"))
                .addBold(Typekit.createFromAsset(this, "fonts/Roboto-Bold.ttf"))
                .addBoldItalic(Typekit.createFromAsset(this, "fonts/Roboto-BoldItalic.ttf"));
    }

    public static MainApp getsInstance() {
        return sInstance;
    }
}
