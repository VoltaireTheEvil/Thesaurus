package ru.gb.makulin.core.usecases

interface Repository<T> {

    suspend fun fetchData(word: String): T
}