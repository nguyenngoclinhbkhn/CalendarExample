package com.example.calendarexample

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alamkanak.weekview.MonthLoader
import com.alamkanak.weekview.WeekViewEvent
import kotlinx.android.synthetic.main.activity_library.*
import java.util.*
import kotlin.collections.ArrayList

class LibraryActivity : AppCompatActivity(), MonthLoader.MonthChangeListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_library)

        weekView.setMonthChangeListener(this)
    }

    override fun onBackPressed() {
        finish()
    }

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
        event.setColor(resources.getColor(R.color.event_color_01))
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
        event.setColor(resources.getColor(R.color.event_color_02))
        events.add(event)

        startTime = Calendar.getInstance()
        startTime.set(Calendar.HOUR_OF_DAY, 3)
        startTime.set(Calendar.MINUTE, 50)
        startTime.set(Calendar.MONTH, newMonth - 1)
        startTime.set(Calendar.YEAR, newYear)
        endTime = startTime.clone() as Calendar
        endTime.set(Calendar.HOUR_OF_DAY, 5)
        endTime.set(Calendar.MINUTE, 0)
        event = WeekViewEvent(10, "hehhe", startTime, endTime)
        event.setColor(resources.getColor(R.color.event_color_03))
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
        event.setColor(resources.getColor(R.color.event_color_02))
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
        event.setColor(resources.getColor(R.color.event_color_03))
        events.add(event)

        startTime = Calendar.getInstance()
        startTime.set(Calendar.DAY_OF_MONTH, 15)
        startTime.set(Calendar.HOUR_OF_DAY, 3)
        startTime.set(Calendar.MINUTE, 0)
        startTime.set(Calendar.MONTH, newMonth - 1)
        startTime.set(Calendar.YEAR, newYear)
        endTime = startTime.clone() as Calendar
        endTime.add(Calendar.HOUR_OF_DAY, 3)
        event = WeekViewEvent(4, "getEventTitle(startTime)", startTime, endTime)
        event.setColor(resources.getColor(R.color.event_color_04))
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
        event.setColor(resources.getColor(R.color.event_color_01))
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
        event.setColor(resources.getColor(R.color.event_color_02))
        events.add(event)

        //AllDay event

        //AllDay event
//        startTime = Calendar.getInstance()
//        startTime.set(Calendar.HOUR_OF_DAY, 0)
//        startTime.set(Calendar.MINUTE, 0)
//        startTime.set(Calendar.MONTH, newMonth - 1)
//        startTime.set(Calendar.YEAR, newYear)
//        endTime = startTime.clone() as Calendar
//        endTime.add(Calendar.HOUR_OF_DAY, 23)
//        event = WeekViewEvent(7, "getEventTitle(startTime)", null, startTime, endTime, true)
//        event.setColor(resources.getColor(R.color.event_color_04))
//        events.add(event)
//        events.add(event)


        // All day event until 00:00 next day

//        // All day event until 00:00 next day
//        startTime = Calendar.getInstance()
//        startTime.set(Calendar.DAY_OF_MONTH, 10)
//        startTime.set(Calendar.HOUR_OF_DAY, 0)
//        startTime.set(Calendar.MINUTE, 0)
//        startTime.set(Calendar.SECOND, 0)
//        startTime.set(Calendar.MILLISECOND, 0)
//        startTime.set(Calendar.MONTH, newMonth - 1)
//        startTime.set(Calendar.YEAR, newYear)
//        endTime = startTime.clone() as Calendar
//        endTime.set(Calendar.DAY_OF_MONTH, 11)
//        event = WeekViewEvent(8, "getEventTitle(startTime)", null, startTime, endTime, true)
//        event.setColor(resources.getColor(R.color.event_color_01))
//        events.add(event)
        return events
    }

}