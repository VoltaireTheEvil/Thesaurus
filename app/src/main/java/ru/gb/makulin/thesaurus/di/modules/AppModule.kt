package ru.gb.makulin.thesaurus.di.modules

import dagger.Module
import dagger.Provides
import ru.gb.makulin.core.domainmodel.DataModel
import ru.gb.makulin.core.usecases.GetDataModelFromRemoteUseCase
import ru.gb.makulin.core.usecases.Repository
import ru.gb.makulin.thesaurus.di.annotations.AppScope

@Module(includes = [NetworkModule::class, RepositoryModule::class, DispatchersModule::class])
class AppModule {

    @[Provides AppScope]
    fun providesGetDataModelUseCase(repository: Repository<DataModel>) =
        GetDataModelFromRemoteUseCase(repository)
}