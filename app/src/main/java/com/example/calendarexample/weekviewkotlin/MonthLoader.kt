package com.example.calendarexample.weekviewkotlin

import java.util.*

/**
 * COPYRIGHT ZYYX. ALL RIGHTS RESERVED,2020
 */
class MonthLoader: WeekViewLoader {
    private var mOnMonthChangeListener: MonthChangeListener? = null

    constructor(listener: MonthChangeListener?) {
        mOnMonthChangeListener = listener
    }

    override fun toWeekViewPeriodIndex(instance: Calendar?): Double {
        return (instance?.get(Calendar.YEAR) ?: WeekViewUtils.today().get(Calendar.YEAR)) * 12 +
                (instance?.get(Calendar.MONTH) ?: WeekViewUtils.today().get(Calendar.MONTH)) +
                ((instance?.get(Calendar.DAY_OF_MONTH) ?:WeekViewUtils.today().get(Calendar.DAY_OF_MONTH) ) - 1) / 30.0
    }

    override fun onLoad(periodIndex: Int): List<WeekViewEvent>? {
        return mOnMonthChangeListener!!.onMonthChange(periodIndex / 12, periodIndex % 12 + 1)
    }

    fun getOnMonthChangeListener(): MonthChangeListener? {
        return mOnMonthChangeListener
    }

    fun setOnMonthChangeListener(onMonthChangeListener: MonthChangeListener?) {
        mOnMonthChangeListener = onMonthChangeListener
    }

    interface MonthChangeListener {
        /**
         * Very important interface, it's the base to load events in the calendar.
         * This method is called three times: once to load the previous month, once to load the next month and once to load the current month.<br></br>
         * **That's why you can have three times the same event at the same place if you mess up with the configuration**
         *
         * @param newYear  : year of the events required by the view.
         * @param newMonth : month of the events required by the view <br></br>**1 based (not like JAVA API) --> January = 1 and December = 12**.
         * @return a list of the events happening **during the specified month**.
         */
        fun onMonthChange(
            newYear: Int,
            newMonth: Int
        ): List<WeekViewEvent>?
    }
}