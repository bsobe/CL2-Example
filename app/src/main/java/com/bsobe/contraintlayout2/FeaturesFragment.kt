package com.bsobe.contraintlayout2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.helper.widget.Flow
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager

class FeaturesFragment : Fragment(R.layout.fragment_features) {

    lateinit var buttonLayer: Button
    lateinit var buttonFlow: Button
    lateinit var buttonPlaceholder: Button
    lateinit var buttonImageFilter: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        requireNotNull(view)
        buttonLayer = view.findViewById(R.id.buttonLayer)
        buttonFlow = view.findViewById(R.id.buttonFlow)
        buttonPlaceholder = view.findViewById(R.id.buttonPlaceholder)
        buttonImageFilter = view.findViewById(R.id.buttonImageFilter)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonLayer.setOnClickListener { replaceInternalFragment(LayerFragment()) }
        buttonFlow.setOnClickListener { replaceInternalFragment(FlowFragment()) }
        buttonPlaceholder.setOnClickListener { replaceInternalFragment(PlaceholderFragment()) }
        buttonImageFilter.setOnClickListener { replaceInternalFragment(ImageFilterFragment()) }
    }

}