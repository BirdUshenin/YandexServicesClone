package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentHomeBinding

class Home : Fragment() {

    private lateinit var binding: FragmentHomeBinding

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

        moreButton.setOnMenuItemClickListener {
            val bottomSheet = MyBottomSheet()
            bottomSheet.show(childFragmentManager, bottomSheet.tag)
            true
        }

        val navController = (childFragmentManager.findFragmentById(R.id.fragment_container_view_tag) as NavHostFragment).navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}