package com.example.calendarexample.weekviewkotlin

import java.util.*

/**
 * COPYRIGHT ZYYX. ALL RIGHTS RESERVED,2020
 */
interface DateTimeInterpreter {
    fun interpretDate(date: Calendar?): String?
    fun interpretTime(hour: Int): String?
}