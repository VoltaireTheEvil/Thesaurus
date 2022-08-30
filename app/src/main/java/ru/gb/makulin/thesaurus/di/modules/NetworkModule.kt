package ru.gb.makulin.thesaurus.di.modules

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.gb.makulin.core.OXFORD_API_BASE_URL
import ru.gb.makulin.repository.retrofit.OxfordApiService
import ru.gb.makulin.thesaurus.di.AppScope

@Module
class NetworkModule {

    @[AppScope Provides]
    fun providesOxfordApiService(retrofit: Retrofit): OxfordApiService = retrofit.create()

    @[AppScope Provides]
    private fun providesGson(): Gson =
        GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .create()

    @[AppScope Provides]
    private fun providesRetrofit(gson: Gson): Retrofit =
        Retrofit.Builder()
            .baseUrl(OXFORD_API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
}