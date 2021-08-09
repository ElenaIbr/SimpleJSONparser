package com.example.simplejsonparser.api

import com.example.simplejsonparser.models.Post
import retrofit2.http.GET

interface SimpleApi {

    @GET("posts/1")
    suspend fun getPost() : Post

}