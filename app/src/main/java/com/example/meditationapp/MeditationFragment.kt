package com.example.meditationapp

import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*


class MeditationFragment : Fragment() {

    private lateinit var imagePersone: ImageView
    private lateinit var timer : TextView
    private lateinit var buttonStart : TextView
    private lateinit var buttonReset : TextView
    private lateinit var countDownTimer: CountDownTimer
    private var timerIsRunning = false
    private lateinit var mp: MediaPlayer
    companion object {

        private var personeImgInt = 0
        private var currentMusic = R.raw.relaxing1
        private var startTimeInMilis :Long = 300000
        private var timerAgain = startTimeInMilis
        fun newInstance(image: Int):  MeditationFragment
        {
            val args = Bundle()
            args.putInt("image",image)
            val fragment = MeditationFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        val view = inflater.inflate(R.layout.fragment_meditation, container, false)
        personeImgInt = arguments?.getInt("image") as Int
        imagePersone = view.findViewById(R.id.persone_in_main)
        imagePersone.setImageResource(personeImgInt)


        mp = MediaPlayer.create(view.context, currentMusic)
        mp.isLooping = true
        timer = view.findViewById(R.id.timer)
        buttonStart = view.findViewById(R.id.button_start)
        buttonReset = view.findViewById(R.id.button_reset)


        buttonStart.setOnClickListener {
            if (timerIsRunning){
                StopCountTimer()
                mp.pause()
            }else{
                StartCountTimer(view,mp)
                mp.start()
            }
        }
        buttonReset.setOnClickListener {
            ResetCountTimer()

            if(timerIsRunning){
                mp.stop()
            }

            mp.release()
            mp = MediaPlayer.create(view.context, currentMusic)


        }


        updateCountDownText()

        return view
    }

    override fun onPause() {
        super.onPause()
        timerAgain = startTimeInMilis
        updateCountDownText()
        buttonReset.visibility = INVISIBLE
        buttonStart.visibility = VISIBLE

        mp.stop()
        mp.release()

    }

    private fun ResetCountTimer() {
        timerAgain = startTimeInMilis
        updateCountDownText()
        buttonReset.visibility = INVISIBLE
        buttonStart.visibility = VISIBLE
    }

    private fun StartCountTimer(view: View, mp:MediaPlayer) {

        countDownTimer = object: CountDownTimer(timerAgain,1000){
            override fun onTick(p0: Long) {
                timerAgain = p0
                updateCountDownText()
            }

            override fun onFinish() {
                timerIsRunning = false
                buttonStart.text = "Start"
                buttonStart.visibility = INVISIBLE
                buttonReset.visibility = VISIBLE

                mp.stop()

                Toast.makeText( view.context, "Time is out",Toast.LENGTH_SHORT).show()
            }

        }.start()

        timerIsRunning = true
        buttonStart.text = "Stop"
        buttonReset.visibility = INVISIBLE
    }

    private fun StopCountTimer() {
        countDownTimer.cancel()
        timerIsRunning = false
        buttonStart.text = "Start"
        buttonReset.visibility = VISIBLE

    }

    private fun updateCountDownText(){
        var minutes = ((timerAgain /1000)/60).toInt()
        var seconds = ((timerAgain /1000)%60).toInt()

        var timeLeftFormate = String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds)

        timer.text = timeLeftFormate
    }


    fun setNewMusic( newMusic: Int ){
        currentMusic = newMusic
    }
    fun setNewTimer( newTimerMin: Long,newTimerSec: Long ){

        var newTimerInMillis  = (newTimerSec * 1000) + (newTimerMin * 60) * 1000

        startTimeInMilis = newTimerInMillis
        timerAgain  = startTimeInMilis
    }

}