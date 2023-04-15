package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentAuthorizationBinding

class Authorization : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentAuthorizationBinding.inflate(layoutInflater)
        binding.back.setOnClickListener{
            backToStartFragment()
        }
        return binding.root
    }

    private fun backToStartFragment(){
        findNavController().navigate(R.id.action_authorization_to_startScreen3)
    }
}


