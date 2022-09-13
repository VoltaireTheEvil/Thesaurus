package ru.gb.makulin.definitionsfeature.di

import ru.gb.makulin.core.usecases.GetDataModelFromRemoteUseCase

interface DefinitionsDeps {

    val getDataModelFromRemoteUseCase: GetDataModelFromRemoteUseCase
}