package com.byd.ordero2.ui.fragments.chatfragment

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.R
import com.byd.ordero2.databinding.FragmentChatBinding
import com.byd.ordero2.ui.fragments.chatfragment.adapter.ChatAdapter
import com.byd.ordero2.ui.fragments.chatfragment.adapter.ChatItem
import com.byd.ordero2.ui.utils.BaseFragment


class ChatFragment : BaseFragment<FragmentChatBinding>(FragmentChatBinding::inflate) {
    private lateinit var adapter: ChatAdapter
    override fun setUpUI() {
        setUpRv()
        setUpItems()
        clickedBackBtn()

    }
    private fun setUpRv(){
        adapter = ChatAdapter{ _->
            findNavController().navigate(R.id.action_chatFragment_to_chattingFragment)
        }
        binding.rvChats.adapter = adapter
        binding.rvChats.layoutManager  = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL,false)
    }
    private fun setUpItems(){
        val chats = listOf(

            ChatItem(
                id = 1,
                R.drawable.ic_prof2,
                "Касым Артыков",
                "12:32",
                "Хочу узнать статус заказа",
                newMsg = false
            ))

        adapter.submitList(chats)
    }
    private fun clickedBackBtn(){
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }


}