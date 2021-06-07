package com.example.messageexample.domain

import com.example.messageexample.data.MessageRepository
import com.example.messageexample.data.model.MessageModel
import com.example.messageexample.data.model.MessageProvider

class GetMessageUseCase {

    private val repository = MessageRepository()

    suspend operator fun invoke() = repository.getAllQuotes()
}