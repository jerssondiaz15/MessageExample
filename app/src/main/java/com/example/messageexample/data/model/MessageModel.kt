package com.example.messageexample.data.model

import com.google.gson.annotations.SerializedName

data class MessageModel(
    @SerializedName("userId")
    val userId : Int,

    @SerializedName("id")
    val id : Int,

    @SerializedName("title")
    val title : String,

    @SerializedName("body")
    val body : String,

    val isRead : Boolean = false,

    val isFavorite : Boolean = false
)