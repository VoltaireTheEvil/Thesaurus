package ru.gb.makulin.thesaurus.di.component

import dagger.Component
import ru.gb.makulin.thesaurus.di.AppScope
import ru.gb.makulin.thesaurus.di.modules.AppModule

@[AppScope Component(modules = [AppModule::class])]
class AppComponent {
}





