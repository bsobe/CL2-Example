package com.bsobe.contraintlayout2.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.helper.widget.Flow
import androidx.fragment.app.Fragment
import androidx.transition.TransitionManager
import com.bsobe.contraintlayout2.R

class FlowFragment : Fragment(R.layout.fragment_flow) {

    lateinit var flow: Flow
    lateinit var textViewFlowType: TextView
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
        textViewFlowType = view.findViewById(R.id.textViewFlowType)
        buttonChangeFlowType = view.findViewById(R.id.buttonChangeFlowType)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonChangeFlowType.setOnClickListener { changeFlowType() }
        changeFlowType() // setInitialState
    }

    private fun changeFlowType() {
        val wrapModePair: Pair<Int, String> = decideWrapMode(currentWrapMode)
        currentWrapMode = wrapModePair.first
        textViewFlowType.text = requireContext().getString(R.string.flow_type, wrapModePair.second)
        /**
         * TransitionManager adds awesome animation between two view states when try to change view bounds
         * Call TransitionManager.beginDelayedTransition(animatedView.parent) before change view bounds
         */
        TransitionManager.beginDelayedTransition(view as ViewGroup)
        flow.setWrapMode(currentWrapMode)
    }

    private fun decideWrapMode(currentWrapMode : Int): Pair<Int, String> {
        return when (currentWrapMode) {
            Flow.WRAP_NONE -> Flow.WRAP_CHAIN to "CHAIN"
            Flow.WRAP_CHAIN -> Flow.WRAP_ALIGNED to "ALIGNED"
            Flow.WRAP_ALIGNED -> Flow.WRAP_NONE to "NONE"
            else -> throw IllegalArgumentException()
        }
    }

}