package com.example.meditationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment


class TimerFragment : Fragment() {


    lateinit var numberPickerMin: NumberPicker
    lateinit var numberPickerSec: NumberPicker
    lateinit var buttonSet: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {


        val view =  inflater.inflate(R.layout.fragment_timer, container, false)
        val meditationFragment = MeditationFragment()


        numberPickerMin = view.findViewById(R.id.numPickerMin)
        numberPickerSec = view.findViewById(R.id.numPickerSec)
        buttonSet = view.findViewById(R.id.button_set)


        numberPickerMin.minValue = 0
        numberPickerMin.maxValue = 99

        numberPickerSec.minValue = 0
        numberPickerSec.maxValue = 59


        buttonSet.setOnClickListener {
            meditationFragment.setNewTimer(numberPickerMin.value.toLong(),
                numberPickerSec.value.toLong())

            Toast.makeText(view.context,"Новый таймер установлен", Toast.LENGTH_SHORT).show()
        }

        return view
    }



}