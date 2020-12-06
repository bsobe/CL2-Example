@file:Suppress("NOTHING_TO_INLINE")

package com.bsobe.contraintlayout2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

internal inline fun Fragment.replaceInternalFragment(fragment: Fragment) {
    requireActivity().replaceInternalFragment(fragment)
}

internal inline fun FragmentActivity.replaceInternalFragment(fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .addToBackStack(fragment.javaClass.simpleName)
        .replace(R.id.fragmentContainer, fragment)
        .commit()
}