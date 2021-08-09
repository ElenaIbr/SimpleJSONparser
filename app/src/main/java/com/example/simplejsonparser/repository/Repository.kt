package com.example.simplejsonparser.repository

import com.example.simplejsonparser.api.RetroFitInstance
import com.example.simplejsonparser.models.Post

class Repository {
    suspend fun getPost() : Post {
        return RetroFitInstance.apiService.getPost()
    }
}