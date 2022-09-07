package ru.gb.makulin.core.dispatchers

import kotlinx.coroutines.CoroutineDispatcher

interface DispatchersProvider {
    fun ui(): CoroutineDispatcher

    fun io(): CoroutineDispatcher
}