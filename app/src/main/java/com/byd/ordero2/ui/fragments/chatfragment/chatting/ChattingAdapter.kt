package com.byd.ordero2.ui.fragments.chatfragment.chatting

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.byd.ordero2.R

class ChattingAdapter(
    private val messages: List<ChatMessage>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_INCOMING = 1
        private const val TYPE_OUTGOING = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (messages[position].isIncoming) TYPE_INCOMING else TYPE_OUTGOING
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return when (viewType) {
            TYPE_INCOMING -> {
                val view = inflater.inflate(R.layout.item_message_incoming, parent, false)
                IncomingViewHolder(view)
            }
            TYPE_OUTGOING -> {
                val view = inflater.inflate(R.layout.item_message_outgoing, parent, false)
                OutgoingViewHolder(view)
            }
            else -> error("Unknown view type")
        }
    }

    override fun getItemCount(): Int = messages.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = messages[position]

        when (holder) {
            is IncomingViewHolder -> holder.bind(item)
            is OutgoingViewHolder -> holder.bind(item)
        }
    }

    class IncomingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtMessage = itemView.findViewById<TextView>(R.id.txt_message)
        private val txtTime = itemView.findViewById<TextView>(R.id.txt_time)

        fun bind(item: ChatMessage) {
            txtMessage.text = item.text
            txtTime.text = item.time
        }
    }

    class OutgoingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtMessage = itemView.findViewById<TextView>(R.id.txt_message)
        private val txtTime = itemView.findViewById<TextView>(R.id.txt_time)

        fun bind(item: ChatMessage) {
            txtMessage.text = item.text
            txtTime.text = item.time
        }
    }
}