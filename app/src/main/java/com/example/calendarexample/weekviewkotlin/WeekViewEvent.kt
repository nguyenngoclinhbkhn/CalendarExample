package com.example.calendarexample.weekviewkotlin

import java.util.*

/**
 * COPYRIGHT ZYYX. ALL RIGHTS RESERVED,2020
 */
class WeekViewEvent {

    var mStartTime: Calendar
    var mEndTime: Calendar
    var mName: String? = null
    var mLocation: String? = null

    var mId: Long = 0
    var mColor = 0


    /**
     * Initializes the event for week view.
     * @param id The id of the event.
     * @param name Name of the event.
     * @param startYear Year when the event starts.
     * @param startMonth Month when the event starts.
     * @param startDay Day when the event starts.
     * @param startHour Hour (in 24-hour format) when the event starts.
     * @param startMinute Minute when the event starts.
     * @param endYear Year when the event ends.
     * @param endMonth Month when the event ends.
     * @param endDay Day when the event ends.
     * @param endHour Hour (in 24-hour format) when the event ends.
     * @param endMinute Minute when the event ends.
     */
    constructor(
        id: Long,
        name: String?,
        startYear: Int,
        startMonth: Int,
        startDay: Int,
        startHour: Int,
        startMinute: Int,
        endYear: Int,
        endMonth: Int,
        endDay: Int,
        endHour: Int,
        endMinute: Int
    ) {
        this.mId = id
        this.mStartTime = Calendar.getInstance()
        this.mStartTime?.set(Calendar.YEAR, startYear)
        this.mStartTime?.set(Calendar.MONTH, startMonth - 1)
        this.mStartTime?.set(Calendar.DAY_OF_MONTH, startDay)
        this.mStartTime?.set(Calendar.HOUR_OF_DAY, startHour)
        this.mStartTime?.set(Calendar.MINUTE, startMinute)
        this.mEndTime = Calendar.getInstance()
        this.mEndTime?.set(Calendar.YEAR, endYear)
        this.mEndTime?.set(Calendar.MONTH, endMonth - 1)
        this.mEndTime?.set(Calendar.DAY_OF_MONTH, endDay)
        this.mEndTime?.set(Calendar.HOUR_OF_DAY, endHour)
        this.mEndTime?.set(Calendar.MINUTE, endMinute)
        this.mName = name
    }

    /**
     * Initializes the event for week view.
     * @param id The id of the event.
     * @param name Name of the event.
     * @param location The location of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     */
    constructor(
        id: Long,
        name: String?,
        location: String?,
        startTime: Calendar,
        endTime: Calendar
    ) {
        this.mId = id
        this.mName = name
        this.mLocation = location
        this.mStartTime = startTime
        this.mEndTime = endTime
    }

    /**
     * Initializes the event for week view.
     * @param id The id of the event.
     * @param name Name of the event.
     * @param startTime The time when the event starts.
     * @param endTime The time when the event ends.
     */
    constructor(
        id: Long,
        name: String?,
        startTime: Calendar,
        endTime: Calendar
    ) {
        this.mId = id
        this.mName = name
        this.mLocation = null
        this.mStartTime = startTime
        this.mEndTime = endTime
    }

    private var mAllDay = false
    constructor(
        id: Long,
        name: String?,
        location: String?,
        startTime: Calendar,
        endTime: Calendar,
        allDay: Boolean
    ) {
        this.mId = id
        this.mName = name
        this.mLocation = location
        this.mStartTime = startTime
        this.mEndTime = endTime
        this.mAllDay = allDay
    }



    override fun equals(o: Any?): Boolean {
        if (this == o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that =
            o as WeekViewEvent
        return mId == that.mId
    }

    fun splitWeekViewEvents(): List<WeekViewEvent>? {
        //This function splits the WeekViewEvent in WeekViewEvents by day
        val events: MutableList<WeekViewEvent> =
            ArrayList()
        // The first millisecond of the next day is still the same day. (no need to split events for this).
        var endTime = this.mEndTime?.clone() as Calendar
        endTime.add(Calendar.MILLISECOND, -1)
        if (!WeekViewUtils.isSameDay(this.mStartTime, endTime)) {
            endTime = this.mStartTime?.clone() as Calendar
            endTime[Calendar.HOUR_OF_DAY] = 23
            endTime[Calendar.MINUTE] = 59
            val event1 =
                WeekViewEvent(
                    this.mId,
                    this.mName,
                    this.mLocation,
                    this.mStartTime,
                    endTime,
                    this.mAllDay
                )
            event1.mColor = mColor
            events.add(event1)

            // Add other days.
            val otherDay = this.mStartTime?.clone() as Calendar
            otherDay.add(Calendar.DATE, 1)
            while (!WeekViewUtils.isSameDay(otherDay, this.mEndTime)) {
                val overDay = otherDay.clone() as Calendar
                overDay[Calendar.HOUR_OF_DAY] = 0
                overDay[Calendar.MINUTE] = 0
                val endOfOverDay = overDay.clone() as Calendar
                endOfOverDay[Calendar.HOUR_OF_DAY] = 23
                endOfOverDay[Calendar.MINUTE] = 59
                val eventMore =
                    WeekViewEvent(
                        this.mId,
                        this.mName,
                        null,
                        overDay,
                        endOfOverDay,
                        this.mAllDay
                    )
                eventMore.mColor = mColor
                events.add(eventMore)

                // Add next day.
                otherDay.add(Calendar.DATE, 1)
            }

            // Add last day.
            val startTime = this.mEndTime?.clone() as Calendar
            startTime[Calendar.HOUR_OF_DAY] = 0
            startTime[Calendar.MINUTE] = 0
            val event2 =
                WeekViewEvent(
                    this.mId,
                    this.mName,
                    this.mLocation,
                    startTime,
                    this.mEndTime,
                    this.mAllDay
                )
            event2.mColor = mColor
            events.add(event2)
        } else {
            events.add(this)
        }
        return events
    }

    override fun hashCode(): Int {
        return (mId xor (mId ushr 32)).toInt()
    }
}