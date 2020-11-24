package com.example.calendarexample.weekviewkotlin

import java.util.*

/**
 * COPYRIGHT ZYYX. ALL RIGHTS RESERVED,2020
 */
interface WeekViewLoader {
    fun toWeekViewPeriodIndex(instance: Calendar?): Double
    fun onLoad(periodIndex: Int): List<WeekViewEvent>?
}