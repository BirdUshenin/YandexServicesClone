package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentOrderBinding

class Order : Fragment() {

    private lateinit var binding: FragmentOrderBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentOrderBinding.inflate(layoutInflater)

        binding.buttonCreateOrder.setOnClickListener {
            transitionCreateOrder()
        }

        return binding.root
    }
    private fun transitionCreateOrder(){
        findNavController().navigate(R.id.action_order_to_createOrder)
    }
}