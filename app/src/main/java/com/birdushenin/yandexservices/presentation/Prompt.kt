package com.birdushenin.yandexservices.presentation

import android.content.Context
import android.content.res.Resources
import android.graphics.Rect
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.marginTop
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentPromptBinding
import com.birdushenin.yandexservices.presentation.adapter.RecyclerViewHorizontal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import pl.droidsonroids.gif.GifDrawable

class Prompt : Fragment() {

    private lateinit var binding: FragmentPromptBinding

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecyclerViewHorizontal

    private lateinit var gifImageView: ImageView




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPromptBinding.inflate(layoutInflater)

        val scrollView = binding.scrollView // Идентификатор вашего ScrollView из XML
        val constraintLayout = binding.constraint3


        val constraintLayoutOriginalY = constraintLayout.y

        scrollView.viewTreeObserver.addOnScrollChangedListener {
            val scrollY = scrollView.scrollY.toFloat()

            if (scrollY >= constraintLayoutOriginalY) {
                constraintLayout.y = scrollY

            } else {
                constraintLayout.y = constraintLayoutOriginalY
            }
        }

        gifImageView = binding.imageView34

        recyclerView = binding.recyclerView





        adapter = RecyclerViewHorizontal()
        recyclerView.layoutManager =
            LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            delay(2000)
            (gifImageView.drawable as GifDrawable).stop()
        }
    }
}

