package com.birdushenin.yandexservices.presentation

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.birdushenin.yandexservices.R
import com.birdushenin.yandexservices.databinding.FragmentHomeBinding
import com.birdushenin.yandexservices.databinding.FragmentSearchBinding

class Search : Fragment() {

    private lateinit var binding: FragmentSearchBinding

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

        return binding.root
    }

}