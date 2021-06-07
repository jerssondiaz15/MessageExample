package com.example.messageexample.data

import com.example.messageexample.data.model.MessageModel
import com.example.messageexample.data.model.MessageProvider
import com.example.messageexample.data.network.MessageService

class MessageRepository {

    private val api = MessageService()

    suspend fun getAllQuotes() : List<MessageModel>{
        val response : List<MessageModel> = api.getQuotes()
        MessageProvider.message = response
        return response
    }
}