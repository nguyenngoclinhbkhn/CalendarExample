package com.example.calendarexample.weekviewkotlin

import java.util.*

/**
 * COPYRIGHT ZYYX. ALL RIGHTS RESERVED,2020
 */
class WeekViewEvent {
    var eventStartTime: Calendar
    var eventEndTime: Calendar
    var eventName: String? = null
    var eventLocation: String? = null
    var eventId: Long = 0
    var eventColor = 0

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
        this.eventId = id
        this.eventStartTime = Calendar.getInstance()
        this.eventStartTime.set(Calendar.YEAR, startYear)
        this.eventStartTime.set(Calendar.MONTH, startMonth - 1)
        this.eventStartTime.set(Calendar.DAY_OF_MONTH, startDay)
        this.eventStartTime.set(Calendar.HOUR_OF_DAY, startHour)
        this.eventStartTime.set(Calendar.MINUTE, startMinute)
        this.eventEndTime = Calendar.getInstance()
        this.eventEndTime.set(Calendar.YEAR, endYear)
        this.eventEndTime.set(Calendar.MONTH, endMonth - 1)
        this.eventEndTime.set(Calendar.DAY_OF_MONTH, endDay)
        this.eventEndTime.set(Calendar.HOUR_OF_DAY, endHour)
        this.eventEndTime.set(Calendar.MINUTE, endMinute)
        this.eventName = name
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
        this.eventId = id
        this.eventName = name
        this.eventLocation = location
        this.eventStartTime = startTime
        this.eventEndTime = endTime
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
        this.eventId = id
        this.eventName = name
        this.eventLocation = null
        this.eventStartTime = startTime
        this.eventEndTime = endTime
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
        this.eventId = id
        this.eventName = name
        this.eventLocation = location
        this.eventStartTime = startTime
        this.eventEndTime = endTime
        this.mAllDay = allDay
    }


    override fun equals(o: Any?): Boolean {
        if (this == o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that =
            o as WeekViewEvent
        return eventId == that.eventId
    }

    fun splitWeekViewEvents(): List<WeekViewEvent>? {
        //This function splits the WeekViewEvent in WeekViewEvents by day
        val events: MutableList<WeekViewEvent> =
            ArrayList()
        // The first millisecond of the next day is still the same day. (no need to split events for this).
        var endTime = this.eventEndTime.clone() as Calendar
        endTime.add(Calendar.MILLISECOND, -1)
        if (!WeekViewUtils.isSameDay(this.eventStartTime, endTime)) {
            endTime = this.eventStartTime.clone() as Calendar
            endTime[Calendar.HOUR_OF_DAY] = 23
            endTime[Calendar.MINUTE] = 59
            val event1 =
                WeekViewEvent(
                    this.eventId,
                    this.eventName,
                    this.eventLocation,
                    this.eventStartTime,
                    endTime,
                    this.mAllDay
                )
            event1.eventColor = eventColor
            events.add(event1)

            // Add other days.
            val otherDay = this.eventStartTime.clone() as Calendar
            otherDay.add(Calendar.DATE, 1)
            while (!WeekViewUtils.isSameDay(otherDay, this.eventEndTime)) {
                val overDay = otherDay.clone() as Calendar
                overDay[Calendar.HOUR_OF_DAY] = 0
                overDay[Calendar.MINUTE] = 0
                val endOfOverDay = overDay.clone() as Calendar
                endOfOverDay[Calendar.HOUR_OF_DAY] = 23
                endOfOverDay[Calendar.MINUTE] = 59
                val eventMore =
                    WeekViewEvent(
                        this.eventId,
                        this.eventName,
                        null,
                        overDay,
                        endOfOverDay,
                        this.mAllDay
                    )
                eventMore.eventColor = eventColor
                events.add(eventMore)

                // Add next day.
                otherDay.add(Calendar.DATE, 1)
            }

            // Add last day.
            val startTime = this.eventEndTime.clone() as Calendar
            startTime[Calendar.HOUR_OF_DAY] = 0
            startTime[Calendar.MINUTE] = 0
            val event2 =
                WeekViewEvent(
                    this.eventId,
                    this.eventName,
                    this.eventLocation,
                    startTime,
                    this.eventEndTime,
                    this.mAllDay
                )
            event2.eventColor = eventColor
            events.add(event2)
        } else {
            events.add(this)
        }
        return events
    }

    override fun hashCode(): Int {
        return (eventId xor (eventId ushr 32)).toInt()
    }
}