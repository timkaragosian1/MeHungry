package com.example.mehungry

import android.os.Bundle
import android.content.Intent
import android.os.Handler
import androidx.activity.ComponentActivity

class SplashActivity : ComponentActivity() {
    private val SPLASH_DELAY: Long = 2000 // 2 seconds

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Using a Handler to delay the transition to the main activity
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY)
    }
}