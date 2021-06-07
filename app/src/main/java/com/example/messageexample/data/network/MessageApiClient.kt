package com.example.messageexample.data.network

import com.example.messageexample.data.model.MessageModel
import retrofit2.Response
import retrofit2.http.GET

interface MessageApiClient {
    @GET("/posts")
    suspend fun getAllQuotes() : Response<List<MessageModel>>
}