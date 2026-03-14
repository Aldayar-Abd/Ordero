package com.byd.ordero2.ui.fragments.chatfragment.adapter

data class ChatItem (
    val id: Int,
    var imgProfile: Int,
    var fullName: String,
    var dateOfMsg: String,
    var msgPrev: String,
    var newMsg: Boolean
)