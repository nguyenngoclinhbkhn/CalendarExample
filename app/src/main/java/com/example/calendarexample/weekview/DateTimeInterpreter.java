package com.example.calendarexample.weekview;

import java.util.Calendar;

/**
 * COPYRIGHT ZYYX. ALL RIGHTS RESERVED,2020
 */
public interface DateTimeInterpreter {
    String interpretDate(Calendar date);
    String interpretTime(int hour);
}