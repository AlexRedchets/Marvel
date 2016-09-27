package com.azvk.marvel.marvel.build;

import com.azvk.marvel.marvel.MarvelFragment;

import dagger.Subcomponent;

@CustomScope
@Subcomponent(modules = MarvelModule.class)
public interface MarvelComponent {
    MarvelFragment inject(MarvelFragment activity);
}
