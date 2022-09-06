package ru.gb.makulin.repository.datasource

interface DataSource<T> {

    suspend fun fetchData(word: String): T
}