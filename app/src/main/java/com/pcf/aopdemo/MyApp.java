package com.pcf.aopdemo;

import android.content.Context;

public class MyApp {

    static Context context;

    public static Context getContext(){
        return context;
    }

    public static void init(Context text){
       context = text;
    }
}
