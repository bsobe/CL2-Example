package com.bsobe.contraintlayout2.features

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import com.bsobe.contraintlayout2.R

class VirtualHelpersFragment : Fragment(R.layout.fragment_virtual_helpers) {

    lateinit var group: Group
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        requireNotNull(view)
        view.findViewById<View>(R.id.cardViewGroup).setOnClickListener { onClickVisibilityChange() }
        group = view.findViewById(R.id.group)
        return view
    }

    private fun onClickVisibilityChange() {
        group.visibility = if (group.visibility == View.VISIBLE) {
            View.GONE
        } else {
            View.VISIBLE
        }
    }

}