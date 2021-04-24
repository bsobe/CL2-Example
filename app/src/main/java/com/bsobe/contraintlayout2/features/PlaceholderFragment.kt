package com.bsobe.contraintlayout2.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.widget.Placeholder
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.bsobe.contraintlayout2.R

class PlaceholderFragment : Fragment(R.layout.fragment_placeholder) {

    lateinit var buttonChangePlaceholder: Button
    lateinit var placeholderSmall: Placeholder
    lateinit var placeholderBig: Placeholder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        requireNotNull(view)
        buttonChangePlaceholder = view.findViewById(R.id.buttonChangePlaceholder)
        placeholderSmall = view.findViewById(R.id.placeHolderSmall)
        placeholderBig = view.findViewById(R.id.placeHolderBig)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonChangePlaceholder.setOnClickListener {
            var isSwapped : Boolean? = it.tag as? Boolean
            if (isSwapped == null) {
                it.tag = false
                isSwapped = false
            }
            /**
             * TransitionManager adds awesome animation between two view states when try to change view bounds
             * Call TransitionManager.beginDelayedTransition(animatedView.parent) before change view bounds
             */
            TransitionManager.beginDelayedTransition(view as ViewGroup)
            if(isSwapped) {
                showSmallSizeImage()
            } else {
                showBigSizeImage()
            }
            it.tag = isSwapped.not()
        }
    }

    private fun showBigSizeImage() {
        placeholderBig.setContentId(R.id.imageView)
        placeholderSmall.setContentId(-1)
    }

    private fun showSmallSizeImage() {
        placeholderSmall.setContentId(R.id.imageView)
        placeholderBig.setContentId(-1)
    }

}