package ru.gb.makulin.repository.retrofit

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import ru.gb.makulin.domainmodel.DataModel

const val API_URL_ENDPOINT_WORDS = "words/en-gb"
const val API_REQUEST_WORD_NAME = "q"
const val API_HEADER_APP_ID = "Application ID: 421e9971"
const val API_HEADER_APP_KEY = "Application Keys: eebfc58761d3d11a4315e8b56f3946f6"

interface OxfordApiService {

    @Headers(
        API_HEADER_APP_ID,
        API_HEADER_APP_KEY
    )
    @GET(API_URL_ENDPOINT_WORDS)
    suspend fun getWordDefinitions(
        @Query(API_REQUEST_WORD_NAME) requestWord: String
    ): DataModel
}

