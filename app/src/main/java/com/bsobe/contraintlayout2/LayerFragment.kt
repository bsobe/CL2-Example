package com.bsobe.contraintlayout2

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.helper.widget.Layer
import androidx.fragment.app.Fragment

class LayerFragment : Fragment(R.layout.fragment_layer) {

    lateinit var layer: Layer
    lateinit var buttonAnimateLayer: Button
    lateinit var buttonAnimateLayerCounter: Button
    private val animator = ValueAnimator.ofFloat(0F, 360F).apply {
        addUpdateListener {
            layer.rotation = it.animatedValue as Float
        }
        duration = 2000
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        requireNotNull(view)
        layer = view.findViewById(R.id.layer)
        buttonAnimateLayer = view.findViewById(R.id.buttonAnimateLayer)
        buttonAnimateLayerCounter = view.findViewById(R.id.buttonAnimateLayerCounter)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonAnimateLayer.setOnClickListener {
            if (animator.isRunning.not()) {
                animator.start()
            }
        }
        buttonAnimateLayerCounter.setOnClickListener {
            if (animator.isRunning.not()) {
                animator.reverse()
            }
        }
    }

}