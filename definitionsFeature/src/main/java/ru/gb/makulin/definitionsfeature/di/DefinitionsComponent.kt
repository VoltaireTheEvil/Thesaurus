package ru.gb.makulin.definitionsfeature.di

import dagger.Component
import ru.gb.makulin.core.FeatureScope
import ru.gb.makulin.definitionsfeature.ui.definitions.DefinitionsFragment

@[FeatureScope Component(dependencies = [DefinitionsDeps::class])]
internal interface DefinitionsComponent {

    fun inject(fragment: DefinitionsFragment)

    @Component.Builder
    interface Builder {

        fun deps(definitionsDeps: DefinitionsDeps): Builder

        fun build(): DefinitionsComponent
    }


}