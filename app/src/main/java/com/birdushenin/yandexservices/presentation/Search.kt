package com.birdushenin.yandexservices.presentation

import android.annotation.SuppressLint
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.*
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.fragment.app.Fragment
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentSearchBinding

class Search : Fragment() {

    private lateinit var binding: FragmentSearchBinding

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(layoutInflater)

        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.adone)
        binding.imageView7.setImageBitmap(bitmap)
        val res = resources
        val roundedDrawable = RoundedBitmapDrawableFactory.create(res, bitmap)
        roundedDrawable.cornerRadius = 155.toFloat()
        binding.imageView7.setImageDrawable(roundedDrawable)

        activity?.window?.statusBarColor = Color.TRANSPARENT
            activity?.window?.setBackgroundDrawableResource(R.drawable.gradient_for_status_bar)

        return binding.root
    }
}