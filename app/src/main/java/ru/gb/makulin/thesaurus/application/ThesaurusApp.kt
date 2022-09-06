package ru.gb.makulin.thesaurus.application

import android.app.Application
import ru.gb.makulin.thesaurus.BuildConfig
import ru.gb.makulin.thesaurus.di.component.AppComponent
import ru.gb.makulin.thesaurus.di.component.DaggerAppComponent

class ThesaurusApp : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder()
            .application(this)
            .appKey(BuildConfig.OXFORD_API_KEY)
            .appId(BuildConfig.OXFORD_APP_ID)
            .build()
    }

}