package com.example.agdu.exampleapp.api.pojo.stack

import com.example.agdu.exampleapp.api.pojo.weather.WeatherResponse
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by agdu on 2017-04-19.
 */
interface WeatherService {

    @GET("data/2.5/weather") //b1b15e88fa797225412429c1c50c122a1
    fun getWeather(@Query("q") q: String, @Query("appid") apiKey: String): Observable<Response<WeatherResponse>>
}
