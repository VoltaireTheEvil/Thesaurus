package ru.gb.makulin.repository.repository

interface Repository<T> {

    suspend fun fetchData(word: String): T
}