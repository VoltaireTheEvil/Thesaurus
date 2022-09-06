package ru.gb.makulin.thesaurus.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.gb.makulin.thesaurus.di.annotations.AppScope
import ru.gb.makulin.thesaurus.di.annotations.OxfordApiAppIdQualifier
import ru.gb.makulin.thesaurus.di.annotations.OxfordApiAppKeyQualifier
import ru.gb.makulin.thesaurus.di.modules.AppModule

@[AppScope Component(modules = [AppModule::class])]
interface AppComponent {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        @BindsInstance
        fun appKey(@OxfordApiAppKeyQualifier appKey: String): Builder

        @BindsInstance
        fun appId(@OxfordApiAppIdQualifier appId: String): Builder

        fun build(): AppComponent

    }
}





