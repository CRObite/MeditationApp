package com.example.meditationapp

import android.content.ClipData.Item
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity


import com.google.android.material.bottomnavigation.BottomNavigationView






class CoreMedPage : AppCompatActivity() {


    private lateinit var navigationBar: BottomNavigationView
    private lateinit var meditationFragment : MeditationFragment
    private lateinit var musicFragment: MusicFragment
    private lateinit var timerFragment: TimerFragment
    companion object{
        private var personeImgInt = 0

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.core_page_meditation)

        navigationBar = findViewById(R.id.navbar)
        navigationBar.menu.getItem(1).isChecked = true


        meditationFragment = MeditationFragment()
        musicFragment = MusicFragment()
        timerFragment = TimerFragment()



        val arguments = intent.extras
        if (arguments != null) {
            personeImgInt = arguments.getInt("persone")
            meditationFragment = MeditationFragment.newInstance(arguments.getInt("persone"))
        }

        supportFragmentManager.beginTransaction().replace(R.id.frame_container, meditationFragment).commit()
        navigationBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.persone ->{ supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, meditationFragment).commit()
                    navigationBar.menu.getItem(0).isChecked = false
                    navigationBar.menu.getItem(2).isChecked = false
                    navigationBar.menu.getItem(1).isChecked = true}
                R.id.timer ->{ supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, timerFragment).commit()
                    navigationBar.menu.getItem(1).isChecked = false
                    navigationBar.menu.getItem(2).isChecked = false
                    navigationBar.menu.getItem(0).isChecked = true}
                R.id.music ->{ supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_container, musicFragment).commit()
                    navigationBar.menu.getItem(0).isChecked = false
                    navigationBar.menu.getItem(1).isChecked = false
                    navigationBar.menu.getItem(2).isChecked = true}
            }

            false
        }


    }

}