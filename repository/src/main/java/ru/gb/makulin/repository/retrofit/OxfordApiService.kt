package ru.gb.makulin.repository.retrofit

import retrofit2.http.GET
import retrofit2.http.Query
import ru.gb.makulin.core.API_REQUEST_WORD_NAME
import ru.gb.makulin.core.API_URL_ENDPOINT_WORDS
import ru.gb.makulin.core.domainmodel.DataModel


interface OxfordApiService {

    @GET(API_URL_ENDPOINT_WORDS)
    suspend fun getWordDefinitions(
        @Query(API_REQUEST_WORD_NAME) requestWord: String
    ): DataModel
}

