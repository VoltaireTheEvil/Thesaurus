package ru.gb.makulin.core.usecases

import ru.gb.makulin.core.domainmodel.DataModel
import ru.gb.makulin.core.uistates.DefinitionsScreenUiState

class GetDataModelFromRemoteUseCase(
    private val repository: Repository<DataModel>
) {
    suspend fun execute(word: String): DefinitionsScreenUiState {
        return DefinitionsScreenUiState.Success(repository.fetchData(word))
    }
}