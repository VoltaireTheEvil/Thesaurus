package ru.gb.makulin.definitionsfeature.di

import androidx.lifecycle.ViewModel

internal class DefinitionsComponentViewModel : ViewModel() {

    val newDefinitionsComponent =
        DaggerDefinitionsComponent.builder().deps(DefinitionsDepsProvider.deps).build()
}