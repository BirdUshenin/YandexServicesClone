package com.birdushenin.yandexservices.presentation

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentStartScreenBinding
import kotlinx.android.synthetic.main.fragment_prompt.*
import kotlinx.android.synthetic.main.fragment_start_screen.*


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
        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.yellow4)
        return binding.root
    }

    private fun launchAuthorization(){
        findNavController().navigate(R.id.action_startScreen_to_authorization)
    }
}