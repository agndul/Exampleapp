package com.example.agdu.exampleapp.api

import android.os.Environment
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit


/**
 * @author Agnieszka Dulęba <agnieszka.duleba@ailleron.pl>
 * @since 2017-05-25
 */
class WeatherApi {


    companion object {
        val cacheSize: Long = 200 * 1024 * 1024
        val gson: Gson = GsonBuilder().create()
        val cache = Cache(getCacheDir("cacheData"), cacheSize)

        var retrofit: Retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(getOkHttpClient())
                .baseUrl("http://samples.openweathermap.org/")
                .build()

        fun weatherApiInstance() = retrofit


        fun getOkHttpClient(): OkHttpClient {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val okHttpClient = OkHttpClient.Builder()
                    .cache(cache)
                    .connectTimeout(6L, TimeUnit.SECONDS)
                    .writeTimeout(6L, TimeUnit.SECONDS)
                    .readTimeout(6L, TimeUnit.SECONDS)
                    .addInterceptor(loggingInterceptor)
                    .addInterceptor { chain ->
                        val originalResponse = chain.proceed(chain.request())
                        originalResponse.newBuilder()
                                .header("Cache-Control", String.format("max-age=%d, only-if-cached, max-stale=%d", 120, 0))
                                .build()
                    }.build()

            return okHttpClient
        }

        fun getCacheDir(name: String): File? {
            try {
                Log.i("Root created: ", "true")
                val root = File(Environment.getExternalStorageDirectory(), "/Android/data/com.example.agdu/cache/" + name)
                if (!root.exists()) {
                    root.mkdirs()
                }
                return root
            } catch (e: Exception) {
                Log.i("Exception occured: ", e.toString())
                return null
            }
        }
    }
}