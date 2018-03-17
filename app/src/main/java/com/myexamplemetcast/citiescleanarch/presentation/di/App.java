package com.myexamplemetcast.citiescleanarch.presentation.di;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import com.myexamplemetcast.citiescleanarch.presentation.di.modules.DatabaseModule;
import com.myexamplemetcast.citiescleanarch.presentation.di.modules.NetInspectorModule;
import com.myexamplemetcast.citiescleanarch.presentation.di.modules.ServiceModule;


public class App extends Application {


    private static AppComponent appComponent;

    public static AppComponent getAppComponent() {
        return appComponent;
    }


    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .serviceModule(new ServiceModule())
                .databaseModule(new DatabaseModule(this))
                .netInspectorModule(new NetInspectorModule(this))
                .build();
    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        MultiDex.install(this);
    }

}
