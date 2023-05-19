package com.birdushenin.yandexservices.presentation

import android.graphics.Rect
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ScrollView
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.birdushenin.yandexservices.R

class Test : Fragment() {
    private lateinit var scrollView: ScrollView
    private lateinit var textView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_test, container, false)
        scrollView = view.findViewById(R.id.scroll_view)
        textView = view.findViewById(R.id.text_view)

        scrollView.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            val textViewRect = Rect()
            textView.getGlobalVisibleRect(textViewRect)

            val screenCenterY = scrollView.height / 2
            val textCenterY = (textViewRect.top + textViewRect.bottom) / 2

            val threshold = 100 // Установите здесь пороговое значение для диапазона изменения цвета

            if (Math.abs(textCenterY - screenCenterY) <= threshold) {
                // Текст находится где-нибудь на середине экрана
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.your_desired_color))
            } else {
                // Текст не находится на середине экрана
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.default_text_color))
            }
        }

        return view
    }
}