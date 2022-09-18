package ru.gb.makulin.thesaurus.di.modules

import dagger.Binds
import dagger.Module
import ru.gb.makulin.core.domainmodel.DataModel
import ru.gb.makulin.core.usecases.Repository
import ru.gb.makulin.repository.datasource.DataSource
import ru.gb.makulin.repository.datasource.DataSourceRetrofitImpl
import ru.gb.makulin.repository.repository.RepositoryImpl
import ru.gb.makulin.thesaurus.di.annotations.AppScope

@Module
interface RepositoryModule {

    @[AppScope Binds]
    fun bindsRepository(implementation: RepositoryImpl): Repository<DataModel>

    @[AppScope Binds]
    fun bindsDataSource(implementation: DataSourceRetrofitImpl): DataSource<DataModel>
}