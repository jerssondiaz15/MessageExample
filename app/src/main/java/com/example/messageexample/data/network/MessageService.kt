package com.example.messageexample.data.network

import com.example.messageexample.core.RetrofitHelper
import com.example.messageexample.data.model.MessageModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class MessageService {

    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getQuotes() : List<MessageModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(MessageApiClient::class.java).getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}