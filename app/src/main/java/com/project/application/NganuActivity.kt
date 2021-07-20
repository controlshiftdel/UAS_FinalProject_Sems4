package com.project.application

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.project.application.activities.CreateActivity
import com.project.application.activities.HomeActivity
import com.project.application.activities.ProfileActivity

class NganuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nganu2)

        val pencet = findViewById<ImageView>(R.id.iv_create)
        pencet.setOnClickListener {
            val intent = Intent(this, CreateActivity::class.java)
            startActivity(intent)
        }
        val klik = findViewById<ImageView>(R.id.iv_profile)
        klik.setOnClickListener {
            val gas = Intent(this, ProfileActivity::class.java)
            startActivity(gas)
        }

        val lgout = findViewById<ImageView>(R.id.iv_logout)
        lgout.setOnClickListener {
            val outs = Intent(this, MainActivity::class.java)
            startActivity(outs)
        }

        val histori = findViewById<ImageView>(R.id.history)
        histori.setOnClickListener {
            val gas = Intent(this, HomeActivity::class.java)
            startActivity(gas)
        }
        val sumary = findViewById<ImageView>(R.id.summary)
        sumary.setOnClickListener {
            val gas = Intent(this, PengeluaranActivity::class.java)
            startActivity(gas)
        }

        val eksport = findViewById<ImageView>(R.id.export)
        eksport.setOnClickListener {
            val gas = Intent(this, NganuActivity::class.java)
            startActivity(gas)
            Toast.makeText(this, "Default_File.pdf tersimpan", Toast.LENGTH_SHORT).show()
        }
    }


}