package com.example.simplejsonparser.api

import com.example.simplejsonparser.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetroFitInstance {

    private val retrofit : Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService :  SimpleApi by lazy{
        retrofit.create(SimpleApi::class.java)
    }


}




