package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentCreateOrderBinding
import kotlinx.android.synthetic.main.fragment_create_order.*


class CreateOrder : Fragment() {

    private lateinit var binding: FragmentCreateOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCreateOrderBinding.inflate(layoutInflater)

        binding.textView33.setOnClickListener{
            backOrder()
        }
        binding.imageView12.setOnClickListener{
            backOrder()
        }

        binding.switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.textView35.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.textView34.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
                binding.textView35.text = "Исполнители видят ваш номер телефона и могут звонить вам сами"

            } else {
                binding.textView35.text = "Исполнители не видят ваш номер телефона и не могут звонить вам сами"
                binding.textView35.setTextColor(ContextCompat.getColor(requireContext(), R.color.create_order_b))
                binding.textView34.setTextColor(ContextCompat.getColor(requireContext(), R.color.create_order_b))
            }
        }
        return binding.root
    }

    private fun backOrder(){
        findNavController().navigate(R.id.action_createOrder_to_order)
    }
}