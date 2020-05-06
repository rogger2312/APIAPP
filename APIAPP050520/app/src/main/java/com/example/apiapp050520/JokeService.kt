package com.example.apiapp050520

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface JokeService {
    @GET("api")
    fun getJoke(@Query("format") format:String) : Call<Joke>

    @Headers("Accept: application/json")
    @GET("/")
    fun getJoke2() : Call<Joke2>
}