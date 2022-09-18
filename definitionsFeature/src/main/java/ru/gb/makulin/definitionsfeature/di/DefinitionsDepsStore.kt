package ru.gb.makulin.definitionsfeature.di

import kotlin.properties.Delegates.notNull

object DefinitionsDepsStore : DefinitionsDepsProvider {

    override var deps: DefinitionsDeps by notNull()

}