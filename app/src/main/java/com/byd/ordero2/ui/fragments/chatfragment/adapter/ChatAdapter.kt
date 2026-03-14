package com.byd.ordero2.ui.fragments.chatfragment.adapter

import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.byd.ordero2.databinding.ItemChatBinding
import com.byd.ordero2.ui.utils.BaseAdapter

class ChatAdapter ( private val onClick: (ChatItem) -> Unit = {}): BaseAdapter<ChatItem, ItemChatBinding>(ChatDiffCallback) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): ItemChatBinding {
        return ItemChatBinding.inflate(inflater,parent,false)
    }

    override fun bind(
        binding: ItemChatBinding,
        item: ChatItem,
        position: Int
    ) {
        binding.imgProfile.setImageResource(item.imgProfile)
        binding.txtFullName.text = item.fullName
        binding.txtDateOfMsg.text = item.dateOfMsg
        binding.txtMsgPrev.text = item.msgPrev
        if(item.newMsg){
            binding.cvNewMsg.visibility = View.VISIBLE
            binding.txtMsgPrev.setTypeface(null, Typeface.BOLD)
        }else{
            binding.cvNewMsg.visibility = View.INVISIBLE
            binding.txtMsgPrev.setTypeface(null, Typeface.NORMAL)
        }
        binding.root.setOnClickListener {
            onClick(item)
        }
    }
}

    object ChatDiffCallback: DiffUtil.ItemCallback<ChatItem>() {
        override fun areItemsTheSame(
            oldItem: ChatItem,
            newItem: ChatItem
        ): Boolean {
            return oldItem.id==newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ChatItem,
            newItem: ChatItem
        ): Boolean {
            return oldItem.id==newItem.id
        }
    }