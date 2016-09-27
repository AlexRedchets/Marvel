package com.azvk.marvel.marvel.build;

import com.azvk.marvel.MarvelInterface;

import dagger.Module;
import dagger.Provides;

@Module
public class MarvelModule {

    private MarvelInterface.View view;

    public MarvelModule(MarvelInterface.View view) {
        this.view = view;
    }

    @Provides
    @CustomScope
    MarvelInterface.View getView(){
        return view;
    }
}
