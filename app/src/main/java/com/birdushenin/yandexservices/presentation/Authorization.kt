package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.data.PasswordBase
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
        binding.buttonCome.setOnClickListener{
            homeStart()
        }

        activity?.window?.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.yellow4)

        return binding.root
    }

    private fun backToStartFragment(){
        findNavController().navigate(R.id.action_authorization_to_startScreen3)
    }

    private fun homeStart() {
        val binding = FragmentAuthorizationBinding.bind(requireView())
        val email = binding.editTextTextEmailAddress.text.toString()
        val password = binding.TextPassword.text.toString()

        when (email) {
            PasswordBase.USERID1 -> {
                if (password == PasswordBase.USERID1_PASSWORD) {
                    findNavController().navigate(R.id.action_authorization_to_home6)
                } else {
                    binding.errorPassword.text = "Неверный пароль"
                }
            }
            else -> {
                binding.errorPassword.visibility = View.VISIBLE
                binding.errorPassword.text = "Введите свой логин и пароль"
            }
        }
    }
}


