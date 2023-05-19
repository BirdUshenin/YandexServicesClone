package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.birdushenin.yandexservices.databinding.FragmentPromptBinding
import com.birdushenin.yandexservices.presentation.adapter.RecyclerViewHorizontal
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
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

        val scrollView = binding.scrollView
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

