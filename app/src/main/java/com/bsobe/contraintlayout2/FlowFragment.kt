package com.bsobe.contraintlayout2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.constraintlayout.helper.widget.Flow
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager

class FlowFragment : Fragment(R.layout.fragment_flow) {

    lateinit var flow: Flow
    lateinit var buttonChangeFlowType: Button
    private var currentWrapMode: Int = Flow.WRAP_NONE

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        requireNotNull(view)
        flow = view.findViewById(R.id.flow)
        buttonChangeFlowType = view.findViewById(R.id.buttonChangeFlowType)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        flow.setWrapMode(currentWrapMode)

        buttonChangeFlowType.setOnClickListener {
            currentWrapMode = decideWrapMode()
            /**
             * TransitionManager adds awesome animation between two view states when try to change view bounds
             * Call TransitionManager.beginDelayedTransition(animatedView.parent) before change view bounds
             */
            TransitionManager.beginDelayedTransition(view as ViewGroup)
            flow.setWrapMode(currentWrapMode)
        }
    }

    private fun decideWrapMode(): Int {
        return when (currentWrapMode) {
            Flow.WRAP_NONE -> Flow.WRAP_CHAIN
            Flow.WRAP_CHAIN -> Flow.WRAP_ALIGNED
            Flow.WRAP_ALIGNED -> Flow.WRAP_NONE
            else -> throw IllegalArgumentException()
        }
    }

}