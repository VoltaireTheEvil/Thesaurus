package ru.gb.makulin.core.uistates

import ru.gb.makulin.core.domainmodel.DataModel

sealed class DefinitionsScreenUiState {
    data class Success(val dataModel: DataModel) : DefinitionsScreenUiState()
    data class Error(val error: Throwable) : DefinitionsScreenUiState()
}
