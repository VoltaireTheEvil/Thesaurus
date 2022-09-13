package ru.gb.makulin.repository.repository

import ru.gb.makulin.core.domainmodel.DataModel
import ru.gb.makulin.core.usecases.Repository
import ru.gb.makulin.repository.datasource.DataSource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataSource: DataSource<DataModel>
    ) : Repository<DataModel> {

    override suspend fun fetchData(word: String): DataModel {
        return dataSource.fetchData(word)
    }
}