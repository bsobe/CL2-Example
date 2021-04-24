package com.bsobe.contraintlayout2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bsobe.contraintlayout2.features.*

class FeaturesFragment : Fragment(R.layout.fragment_features) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        requireNotNull(view)
        with(view) {
            findViewById<View>(R.id.buttonSizeProperties)
                .setOnClickListener { replaceInternalFragment(SizePropertiesFragment()) }
            findViewById<View>(R.id.buttonPositionProperties)
                .setOnClickListener { replaceInternalFragment(PositionPropertiesFragment()) }
            findViewById<View>(R.id.buttonVirtualHelpers)
                .setOnClickListener { replaceInternalFragment(VirtualHelpersFragment()) }
            findViewById<View>(R.id.buttonLayer)
                .setOnClickListener { replaceInternalFragment(LayerFragment()) }
            findViewById<View>(R.id.buttonFlow)
                .setOnClickListener { replaceInternalFragment(FlowFragment()) }
            findViewById<View>(R.id.buttonPlaceholder)
                .setOnClickListener { replaceInternalFragment(PlaceholderFragment()) }
            findViewById<View>(R.id.buttonImageFilter)
                .setOnClickListener { replaceInternalFragment(ImageFilterFragment()) }
        }
        return view
    }

}