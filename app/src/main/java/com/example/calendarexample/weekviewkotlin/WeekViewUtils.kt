package com.example.calendarexample.weekviewkotlin

import java.util.*

/**
 * COPYRIGHT ZYYX. ALL RIGHTS RESERVED,2020
 */
object WeekViewUtils {
    /////////////////////////////////////////////////////////////////
    //
    //      Helper methods.
    //
    /////////////////////////////////////////////////////////////////

    /////////////////////////////////////////////////////////////////
    //
    //      Helper methods.
    //
    /////////////////////////////////////////////////////////////////
    /**
     * Checks if two times are on the same day.
     * @param dayOne The first day.
     * @param dayTwo The second day.
     * @return Whether the times are on the same day.
     */
    fun isSameDay(dayOne: Calendar?, dayTwo: Calendar?): Boolean {
        if (dayTwo == null || dayOne == null) return false
        return dayOne[Calendar.YEAR] == dayTwo[Calendar.YEAR] && dayOne[Calendar.DAY_OF_YEAR] == dayTwo[Calendar.DAY_OF_YEAR]
    }

    /**
     * Returns a calendar instance at the start of this day
     * @return the calendar instance
     */
    fun today(): Calendar {
        val today = Calendar.getInstance()
        today[Calendar.HOUR_OF_DAY] = 0
        today[Calendar.MINUTE] = 0
        today[Calendar.SECOND] = 0
        today[Calendar.MILLISECOND] = 0
        return today
    }

    fun todayHour(): Int{
        return Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    }

    fun todayMinutes(): Int{
        return Calendar.getInstance().get(Calendar.MINUTE)
    }

}