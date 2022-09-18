package ru.gb.makulin.thesaurus.di.modules

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.gb.makulin.core.API_HEADER_APP_ID
import ru.gb.makulin.core.API_HEADER_APP_KEY
import ru.gb.makulin.core.OXFORD_API_BASE_URL
import ru.gb.makulin.repository.retrofit.OxfordApiService
import ru.gb.makulin.thesaurus.di.annotations.AppScope
import ru.gb.makulin.thesaurus.di.annotations.OxfordApiAppIdQualifier
import ru.gb.makulin.thesaurus.di.annotations.OxfordApiAppKeyQualifier

@Module
class NetworkModule {

    @[AppScope Provides]
    fun providesOxfordApiService(retrofit: Retrofit): OxfordApiService = retrofit.create()

    @[AppScope Provides]
    fun providesGson(): Gson =
        GsonBuilder()
            .create()

    @[AppScope Provides]
    fun providesOkHttpClient(
        @OxfordApiAppKeyQualifier appKey: String, @OxfordApiAppIdQualifier
        appId: String
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor { chain ->
                val authorizedRequest = chain.request().newBuilder()
                    .addHeader(API_HEADER_APP_KEY, appKey)
                    .addHeader(API_HEADER_APP_ID, appId)
                    .build()
                chain.proceed(authorizedRequest)
            }
            .build()

    @[AppScope Provides]
    fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(OXFORD_API_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}