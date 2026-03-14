package com.byd.ordero2.ui.fragments.chatfragment.chatting

data class ChatMessage (
    val id: Long,
    val text: String,
    val isIncoming: Boolean,
    val time: String
)