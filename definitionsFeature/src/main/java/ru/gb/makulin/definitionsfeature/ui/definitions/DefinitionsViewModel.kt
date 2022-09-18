package ru.gb.makulin.definitionsfeature.ui.definitions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import ru.gb.makulin.core.domainmodel.DataModel
import ru.gb.makulin.core.uistates.DefinitionsScreenUiState
import ru.gb.makulin.core.usecases.GetDataModelFromRemoteUseCase
import javax.inject.Inject
import javax.inject.Provider

internal class DefinitionsViewModel(private val getDataUseCase: GetDataModelFromRemoteUseCase) :
    ViewModel
        () {

    private val _uiState: MutableStateFlow<DefinitionsScreenUiState> = MutableStateFlow(
        DefinitionsScreenUiState.Success(
            DataModel(
                emptyList
                    ()
            )
        )
    )
    val uiState: StateFlow<DefinitionsScreenUiState> = _uiState

    fun fetchData(word: String) {
        viewModelScope.launch {
            try {
                _uiState.emit(getDataUseCase.execute(word))
            } catch (e: Exception) {
                _uiState.emit(DefinitionsScreenUiState.Error(e))
            }
        }
    }

    class Factory @Inject constructor(
        private val getDataUseCase: Provider<GetDataModelFromRemoteUseCase>
    ) : ViewModelProvider.Factory {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            require(modelClass == DefinitionsViewModel::class.java)
            return DefinitionsViewModel(getDataUseCase.get()) as T
        }
    }

}