package com.project.application.activities

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.project.application.MainActivity
import com.project.application.NganuActivity
import com.project.application.R
import com.project.application.entity.News
import com.project.application.helper.DBHelper
import kotlinx.android.synthetic.main.activity_create_news.*
import java.text.SimpleDateFormat
import java.util.*

class CreateActivity : AppCompatActivity() {
    private val db = DBHelper(this)

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_news)

        val klik = findViewById<Button>(R.id.btn_cancel)
        klik.setOnClickListener{
            val gas = Intent(this, NganuActivity::class.java)
            startActivity(gas)
        }

        if(intent.getIntExtra("id-extra", -1) == -1){
            btn_insert.setOnClickListener {

                insert()
                Toast.makeText(this, "Success Insert Data", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
            }
        } else {

            input_title.setText(intent.getStringExtra("title-extra"))
            input_body.setText(intent.getStringExtra("body-extra"))
            input_date.setText(intent.getStringExtra("date-extra"))

            btn_insert.setOnClickListener {
                update()
                val intent = Intent(this, HomeActivity::class.java)
                Toast.makeText(this, "Success Update Data", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            }
        }
    }

    fun insert(){
        val news = News(input_title.text.toString(), input_body.text.toString(), input_date.text.toString())
        db.insertNews(news)
    }

    private fun update(){
        val news = News(input_title.text.toString(), input_body.text.toString(), input_date.text.toString())
        db.updateNews(news, intent.getIntExtra("id-extra", -1))
    }



}