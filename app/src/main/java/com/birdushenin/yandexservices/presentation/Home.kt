package com.birdushenin.yandexservices.presentation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentHomeBinding

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val isPromptShownKey = "isPromptShown"
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moreButton = binding.bottomNavView.menu.findItem(R.id.more)

        sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        val isPromptShown = sharedPreferences.getBoolean(isPromptShownKey, false)
        if (!isPromptShown) {
            // Подсказка не была показана (Prompt управление)
            findNavController().navigate(R.id.action_home6_to_prompt)

            // Информация о том, что подсказка была показана
            sharedPreferences.edit().putBoolean(isPromptShownKey, true).apply()
        }

        moreButton.setOnMenuItemClickListener {
            val bottomSheet = MyBottomSheet()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
            true
        }

        val navController = (childFragmentManager.findFragmentById(R.id.fragment_container_view_tag) as NavHostFragment).navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}