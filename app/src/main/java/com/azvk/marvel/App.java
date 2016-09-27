package com.azvk.marvel;

import android.app.Application;

import com.azvk.marvel.dependencies.AppModule;
import com.azvk.marvel.dependencies.DaggerNetComponent;
import com.azvk.marvel.dependencies.NetComponent;
import com.azvk.marvel.dependencies.NetModule;
import com.azvk.marvel.marvel.build.MarvelComponent;
import com.azvk.marvel.marvel.build.MarvelModule;

public class App extends Application {

    private NetComponent netComponent;
    private MarvelComponent marvelComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://api.github.com/users/"))
                .build();

        //initRealmConfiguration();
    }

    public MarvelComponent getMarvelComponent(MarvelInterface.View view){
        marvelComponent = netComponent.plus(new MarvelModule(view));
        return marvelComponent;
    }

    public void releaseGitHubComponent(){
        marvelComponent = null;
    }

    /*private void initRealmConfiguration() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }*/

    public NetComponent getNetComponent(){
        return netComponent;
    }
}
