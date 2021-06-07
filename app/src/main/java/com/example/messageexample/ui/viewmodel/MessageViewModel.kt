package com.example.messageexample.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.messageexample.data.model.MessageModel
import com.example.messageexample.domain.GetMessageUseCase
import kotlinx.coroutines.launch

class MessageViewModel : ViewModel(){

    val messageModel = MutableLiveData<List<MessageModel>>()
    val isLoading = MutableLiveData<Boolean>()

    var getMessageUseCase = GetMessageUseCase()

    fun onCreate(){
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getMessageUseCase()
            if (!result.isNullOrEmpty()){
                messageModel.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

}