package com.bsobe.contraintlayout2

import android.animation.ValueAnimator
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.helper.widget.Layer
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.core.text.bold
import androidx.fragment.app.Fragment

class ImageFilterFragment : Fragment(R.layout.fragment_image_filter) {

    lateinit var imageView: ImageFilterView
    lateinit var textViewSaturationTitle: TextView
    lateinit var seekBarSaturation: SeekBar
    lateinit var textViewBrightnessTitle: TextView
    lateinit var seekBarBrightness: SeekBar
    lateinit var textViewContrastTitle: TextView
    lateinit var seekBarContrast: SeekBar
    lateinit var textViewRoundTitle: TextView
    lateinit var seekBarRound: SeekBar

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        requireNotNull(view)
        imageView = view.findViewById(R.id.imageFilterView)
        textViewSaturationTitle = view.findViewById(R.id.textViewSaturationTitle)
        seekBarSaturation = view.findViewById(R.id.seekBarSaturation)
        textViewBrightnessTitle = view.findViewById(R.id.textViewBrightnessTitle)
        seekBarBrightness = view.findViewById(R.id.seekBarBrightness)
        textViewContrastTitle = view.findViewById(R.id.textViewContrastTitle)
        seekBarContrast = view.findViewById(R.id.seekBarContrast)
        textViewRoundTitle = view.findViewById(R.id.textViewRoundTitle)
        seekBarRound = view.findViewById(R.id.seekBarRound)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        seekBarSaturation.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val value = (progress / 100.0f) + 1
                onChangedSaturationPercent(value)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        seekBarBrightness.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val value = (progress / 100.0f) + 1
                onChangedBrightnessPercent(value)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        seekBarContrast.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                val value = (progress / 100.0f) + 1
                onChangedContrastPercent(value)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        seekBarRound.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                onChangedRoundPercent(progress / 100F)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })

        onChangedSaturationPercent(1F) // setInitialValue
        onChangedContrastPercent(1F) // setInitialValue
        onChangedBrightnessPercent(1F) // setInitialValue
        onChangedRoundPercent(0F) // setInitialValue
    }

    private fun onChangedSaturationPercent(value: Float) {
        imageView.saturation = value
        textViewSaturationTitle.text = SpannableStringBuilder().apply {
            append(requireContext().getString(R.string.saturation))
            bold { append(" ${"%.2f".format(value)}") }
        }
    }

    private fun onChangedBrightnessPercent(value: Float) {
        imageView.brightness = value
        textViewBrightnessTitle.text = SpannableStringBuilder().apply {
            append(requireContext().getString(R.string.brightness))
            bold { append(" ${"%.2f".format(value)}") }
        }
    }

    private fun onChangedContrastPercent(value: Float) {
        imageView.contrast = value
        textViewContrastTitle.text = SpannableStringBuilder().apply {
            append(requireContext().getString(R.string.contrast))
            bold { append(" ${"%.2f".format(value)}") }
        }
    }

    private fun onChangedRoundPercent(value: Float) {
        imageView.roundPercent = value
        textViewRoundTitle.text = SpannableStringBuilder().apply {
            append(requireContext().getString(R.string.round))
            bold { append(" $value") }
        }
    }

}