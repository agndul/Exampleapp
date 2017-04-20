package com.example.agdu.exampleapp.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by agdu on 2017-04-19.
 */


class RestApi {
    companion object {

        val gson: Gson = GsonBuilder().create()
        var retrofit : Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl("https://api.stackexchange.com/")
                .build()
        fun retrofitInstance() = retrofit

    }
}
