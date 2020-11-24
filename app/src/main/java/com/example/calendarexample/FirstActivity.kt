package com.example.calendarexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btnOneDay.setOnClickListener {
            startActivity(Intent(this, OneDayActivity::class.java))
        }

        btnSevenDay.setOnClickListener {
            startActivity(Intent(this, SevenDayActivity::class.java))
        }
    }
}