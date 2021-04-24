package com.bsobe.contraintlayout2.features

import android.animation.ValueAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.bsobe.contraintlayout2.R

class PositionPropertiesFragment : Fragment(R.layout.fragment_position_properties) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        requireNotNull(view)
        animateCircleAngle(view.findViewById<View>(R.id.orangeCircle))
        return view
    }

    private fun animateCircleAngle(view: View) {
        (view.layoutParams as? ConstraintLayout.LayoutParams)?.let { layoutParams ->
            val animator = ValueAnimator.ofFloat(0F, 360F)
            animator.addUpdateListener {
                layoutParams.circleAngle = it.animatedValue as Float
                view.layoutParams = layoutParams
            }
            animator.duration = 2400
            animator.repeatMode = ValueAnimator.RESTART
            animator.repeatCount = ValueAnimator.INFINITE
            animator.start()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}