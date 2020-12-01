package com.example.calendarexample

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendarexample.weekviewkotlin.MonthLoader
import com.example.calendarexample.weekviewkotlin.WeekViewEvent
import kotlinx.android.synthetic.main.activity_seven_day.*
import java.util.*
import kotlin.collections.ArrayList

class SevenDayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seven_day)

        btnModeDay.setOnClickListener {
            weekViewSeven.setNumberOfVisibleDays(1)

        }

        btnModeWeek.setOnClickListener {
            weekViewSeven.setNumberOfVisibleDays(7)
        }

        weekViewSeven.setMonthChangeListener(object: MonthLoader.MonthChangeListener{
            override fun onMonthChange(newYear: Int, newMonth: Int): List<WeekViewEvent>? {
                val events: MutableList<WeekViewEvent> = ArrayList()

                var startTime: Calendar = Calendar.getInstance()
                startTime.set(Calendar.HOUR_OF_DAY, 3)
                startTime.set(Calendar.MINUTE, 0)
                startTime.set(Calendar.MONTH, newMonth - 1)
                startTime.set(Calendar.YEAR, newYear)
                var endTime: Calendar = startTime.clone() as Calendar
                endTime.add(Calendar.HOUR, 1)
                endTime.set(Calendar.MONTH, newMonth - 1)
                var event = WeekViewEvent(1, "Hello", startTime, endTime)
                event.eventColor = Color.BLACK
                events.add(event)

                startTime = Calendar.getInstance()
                startTime.set(Calendar.HOUR_OF_DAY, 3)
                startTime.set(Calendar.MINUTE, 30)
                startTime.set(Calendar.MONTH, newMonth - 1)
                startTime.set(Calendar.YEAR, newYear)
                endTime = startTime.clone() as Calendar
                endTime.set(Calendar.HOUR_OF_DAY, 4)
                endTime.set(Calendar.MINUTE, 30)
                endTime.set(Calendar.MONTH, newMonth - 1)
                event = WeekViewEvent(10, "Hello 2", startTime, endTime)
                event.eventColor = Color.BLACK
                events.add(event)

                startTime = Calendar.getInstance()
                startTime.set(Calendar.HOUR_OF_DAY, 4)
                startTime.set(Calendar.MINUTE, 20)
                startTime.set(Calendar.MONTH, newMonth - 1)
                startTime.set(Calendar.YEAR, newYear)
                endTime = startTime.clone() as Calendar
                endTime.set(Calendar.HOUR_OF_DAY, 5)
                endTime.set(Calendar.MINUTE, 0)
                event = WeekViewEvent(10, "hehhe", startTime, endTime)
                event.eventColor = Color.BLACK
                events.add(event)

                startTime = Calendar.getInstance()
                startTime.set(Calendar.HOUR_OF_DAY, 5)
                startTime.set(Calendar.MINUTE, 30)
                startTime.set(Calendar.MONTH, newMonth - 1)
                startTime.set(Calendar.YEAR, newYear)
                endTime = startTime.clone() as Calendar
                endTime.add(Calendar.HOUR_OF_DAY, 2)
                endTime.set(Calendar.MONTH, newMonth - 1)
                event = WeekViewEvent(2, "hihi", startTime, endTime)
                event.eventColor = Color.BLACK
                events.add(event)

                startTime = Calendar.getInstance()
                startTime.set(Calendar.HOUR_OF_DAY, 5)
                startTime.set(Calendar.MINUTE, 0)
                startTime.set(Calendar.MONTH, newMonth - 1)
                startTime.set(Calendar.YEAR, newYear)
                startTime.add(Calendar.DATE, 1)
                endTime = startTime.clone() as Calendar
                endTime.add(Calendar.HOUR_OF_DAY, 3)
                endTime.set(Calendar.MONTH, newMonth - 1)
                event = WeekViewEvent(3, "getEventTitle(startTime)", startTime, endTime)
                event.eventColor = Color.BLACK
                events.add(event)


                startTime = Calendar.getInstance()
                startTime.set(Calendar.DAY_OF_MONTH, 1)
                startTime.set(Calendar.HOUR_OF_DAY, 3)
                startTime.set(Calendar.MINUTE, 0)
                startTime.set(Calendar.MONTH, newMonth - 1)
                startTime.set(Calendar.YEAR, newYear)
                endTime = startTime.clone() as Calendar
                endTime.add(Calendar.HOUR_OF_DAY, 3)
                event = WeekViewEvent(5, "getEventTitle(startTime)", startTime, endTime)
                event.eventColor = Color.BLACK
                events.add(event)

                startTime = Calendar.getInstance()
                startTime.set(Calendar.DAY_OF_MONTH, startTime.getActualMaximum(Calendar.DAY_OF_MONTH))
                startTime.set(Calendar.HOUR_OF_DAY, 15)
                startTime.set(Calendar.MINUTE, 0)
                startTime.set(Calendar.MONTH, newMonth - 1)
                startTime.set(Calendar.YEAR, newYear)
                endTime = startTime.clone() as Calendar
                endTime.add(Calendar.HOUR_OF_DAY, 3)
                event = WeekViewEvent(5, "getEventTitle(startTime)", startTime, endTime)
                event.eventColor = Color.BLACK
                events.add(event)
                return events
            }

        })
    }

    override fun onBackPressed() {
        finish()
    }
}