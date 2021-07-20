package com.project.application.viewholder

import android.animation.ObjectAnimator
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.project.application.MainActivity
import com.project.application.R
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
            finish()
        }, 4000)

        progressBar2.setProgressTintList(ColorStateList.valueOf(Color.DKGRAY))
        progressBar2.max = 1000
        val currentProgress = 1000

        ObjectAnimator.ofInt(progressBar2,"progress", currentProgress)
            .setDuration(3800)
            .start()
    }
}