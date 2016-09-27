package com.azvk.marvel.dependencies;

import com.azvk.marvel.marvel.build.MarvelComponent;
import com.azvk.marvel.marvel.build.MarvelModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    MarvelComponent plus (MarvelModule module);
}
