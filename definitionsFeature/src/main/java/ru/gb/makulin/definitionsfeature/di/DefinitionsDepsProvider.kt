package ru.gb.makulin.definitionsfeature.di

import androidx.annotation.RestrictTo


interface DefinitionsDepsProvider {

    @get:RestrictTo(RestrictTo.Scope.LIBRARY)
    val deps: DefinitionsDeps

    companion object : DefinitionsDepsProvider by DefinitionsDepsStore

}

