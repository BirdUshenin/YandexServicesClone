package com.birdushenin.yandexservices.presentation

import android.content.ClipData
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentTest2Binding
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fragment_test_2.*

class TestTwo : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentTest2Binding.inflate(inflater, container, false)

        val scrollView = binding.scrollView // Идентификатор вашего ScrollView из XML
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



