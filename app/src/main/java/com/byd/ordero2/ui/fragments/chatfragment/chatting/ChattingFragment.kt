package com.byd.ordero2.ui.fragments.chatfragment.chatting

import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.byd.ordero2.databinding.FragmentChattingBinding
import com.byd.ordero2.ui.utils.BaseFragment


class ChattingFragment : BaseFragment<FragmentChattingBinding>(FragmentChattingBinding::inflate) {
    override fun setUpUI() {
        clickedBackBtn()
        setUpRv()
        keyboardPB()
    }
    private fun setUpRv(){
        val messages = listOf(
            ChatMessage(1, "Добрый день!", true, "12:30"),
            ChatMessage(2, "Здравствуйте, чем можем помочь?", false, "12:31"),
            ChatMessage(3, "Хочу узнать статус заказа", true, "12:32")
        )
        val adapter = ChattingAdapter(messages)
        binding.rvMasseges.layoutManager = LinearLayoutManager(requireContext())
        binding.rvMasseges.adapter = adapter
    }
    private fun clickedBackBtn(){
        binding.btnBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
    private fun keyboardPB(){
        //КОД С GPT ХЗ как работает, но он поднимает клаву
        val initialBottomPadding = binding.contSend.paddingBottom
        ViewCompat.setOnApplyWindowInsetsListener(binding.contSend) { view, insets ->
            val imeBottom = insets.getInsets(WindowInsetsCompat.Type.ime()).bottom
            val systemBottom = insets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom

            view.setPadding(
                view.paddingLeft,
                view.paddingTop,
                view.paddingRight,
                initialBottomPadding + maxOf(imeBottom, systemBottom)
            )

            insets
        }
    }
}