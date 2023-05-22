package com.example.meditationapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler

class LoadScreen: Activity() {
    private val SPLASH_DISPLAY = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.load_screen)
        Handler().postDelayed({
            val mainIntent = Intent(this, MainActivity::class.java)
            this.startActivity(mainIntent)
            this.finish()
        }, SPLASH_DISPLAY.toLong())
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}
