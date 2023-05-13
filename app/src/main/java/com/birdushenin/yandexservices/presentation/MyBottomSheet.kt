package com.birdushenin.yandexservices.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.birdushenin.yandexservices.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.my_bottom_sheet_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val rootContainer: FrameLayout by lazy {
//            val resId = com.google.android.material.R.id.design_bottom_sheet
//            (dialog as BottomSheetDialog).findViewById(resId)!!
//        }
//        rootContainer.setBackgroundColor(Color.TRANSPARENT)
    }
}