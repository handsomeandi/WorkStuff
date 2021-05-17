package com.example.weatherproj

import retrofit2.Call
import retrofit2.http.GET




interface ServerApi {
    @GET(Urls.WEATHER)
    fun getWeatherData(): Call<Weather?>?
}