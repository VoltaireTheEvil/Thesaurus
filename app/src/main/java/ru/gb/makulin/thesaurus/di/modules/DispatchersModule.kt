package ru.gb.makulin.thesaurus.di.modules

import dagger.Binds
import dagger.Module
import dagger.Provides
import ru.gb.makulin.core.dispatchers.DispatchersProvider
import ru.gb.makulin.core.dispatchers.DispatchersProviderImpl
import ru.gb.makulin.thesaurus.di.annotations.AppScope

@Module()
interface DispatchersModule {

    @[AppScope Binds]
    fun bindsDispatchersProvider(implementation: DispatchersProviderImpl): DispatchersProvider
}