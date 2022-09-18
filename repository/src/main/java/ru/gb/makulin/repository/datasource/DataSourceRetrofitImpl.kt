package ru.gb.makulin.repository.datasource

import kotlinx.coroutines.withContext
import ru.gb.makulin.core.dispatchers.DispatchersProvider
import ru.gb.makulin.core.dispatchers.DispatchersProviderImpl
import ru.gb.makulin.core.domainmodel.DataModel
import ru.gb.makulin.repository.retrofit.OxfordApiService
import javax.inject.Inject

class DataSourceRetrofitImpl @Inject constructor(
    private val oxfordApiService: OxfordApiService,
    private val dispatchersProvider: DispatchersProvider
) : DataSource<DataModel> {

    override suspend fun fetchData(word: String): DataModel {
        return withContext(dispatchersProvider.io()) {
            oxfordApiService.getWordDefinitions(word)
        }
    }
}