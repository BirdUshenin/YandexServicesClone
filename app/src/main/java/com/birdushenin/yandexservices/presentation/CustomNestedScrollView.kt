package com.birdushenin.yandexservices.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import androidx.core.widget.NestedScrollView

class CustomNestedScrollView(context: Context, attrs: AttributeSet?) : NestedScrollView(context, attrs) {

    private var isScrollEnabled = false

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(ev: MotionEvent): Boolean {
        return if (isScrollEnabled) {
            super.onTouchEvent(ev)
        } else {
            false
        }
    }
}