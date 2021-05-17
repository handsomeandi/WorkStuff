package com.example.weatherproj

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory


class NetworkModule{
    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient.Builder): Retrofit? {
        client.connectTimeout(30, TimeUnit.SECONDS)
        client.writeTimeout(60, TimeUnit.SECONDS)
        client.readTimeout(60, TimeUnit.SECONDS)
        return Retrofit.Builder().baseUrl(Urls.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideClient(): OkHttpClient.Builder? {
        return OkHttpClient.Builder()
    }

    @Singleton
    @Provides
    fun provideServerApi(retrofit: Retrofit): ServerApi? {
        return retrofit.create(ServerApi::class.java)
    }
}