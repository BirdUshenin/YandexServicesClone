package com.birdushenin.yandexservices.presentation

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentStartScreenBinding


class StartScreen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentStartScreenBinding.inflate(layoutInflater)
        binding.LoginSpecialist.setOnClickListener{
            launchAuthorization()
        }
        return binding.root
    }

    private fun launchAuthorization(){
        findNavController().navigate(R.id.action_startScreen_to_authorization)
    }
}