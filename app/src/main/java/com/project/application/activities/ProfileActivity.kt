package com.project.application.activities

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.project.application.MainActivity
import com.project.application.R
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity: AppCompatActivity() {

    val PRIVATE_MODE = 0
    val PREF_NAME = "bitlabs"
    var sharedPrefs : SharedPreferences? = null

    override fun onCreate(savedInstanceState : Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        sharedPrefs = this.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        user_profile_name.setText(sharedPrefs!!.getString("userName", ""))
        user_profile_email.setText(sharedPrefs!!.getString("userEmail", ""))

        val klik = findViewById<Button>(R.id.balikregis)
        klik.setOnClickListener{
            val gas = Intent(this, MainActivity::class.java)
            startActivity(gas)
        }

    }
}
