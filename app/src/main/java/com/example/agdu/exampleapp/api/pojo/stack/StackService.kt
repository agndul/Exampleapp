package com.example.agdu.exampleapp.api.pojo.stack

import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by agdu on 2017-04-19.
 */
interface StackService{
    @GET("2.2/answers?order=desc&sort=activity&site=stackoverflow")
    fun getAnswers(): Observable<ExampleResponse>
}
