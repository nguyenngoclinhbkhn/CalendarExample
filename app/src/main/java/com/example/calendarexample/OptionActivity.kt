package com.example.calendarexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_option.*

class OptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_option)

        btnCustomCalendar.setOnClickListener {
            startActivity(Intent(this, SevenDayActivity::class.java))
        }


        btnLibraryCalendar.setOnClickListener {
            startActivity(Intent(this, LibraryActivity::class.java))
        }
    }
}