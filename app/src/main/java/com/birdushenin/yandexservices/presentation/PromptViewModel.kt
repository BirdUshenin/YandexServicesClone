package com.birdushenin.yandexservices.presentation

import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class PromptViewModel : ViewModel() {

    fun handleScroll(constraintLayout: ConstraintLayout, scrollY: Float, constraintLayoutOriginalY: Float) {
        if (scrollY >= constraintLayoutOriginalY) {
            constraintLayout.y = scrollY
        } else {
            constraintLayout.y = constraintLayoutOriginalY
        }
    }

    fun startSearch(navController: NavController, actionId: Int) {
        navController.navigate(actionId)
    }
}
