package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.birdushenin.yandexservices.databinding.FragmentTest2Binding

class TestTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTest2Binding.inflate(inflater, container, false)

        val scrollView = binding.scrollView
        val constraintLayout = binding.ConstraintLayout2

        val constraintLayoutOriginalY = constraintLayout.y

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY = scrollView.scrollY.toFloat()

            if (scrollY >= constraintLayoutOriginalY) {
                constraintLayout.y = scrollY

            } else {
                constraintLayout.y = constraintLayoutOriginalY
            }
        }

        return binding.root
    }

}



