package com.hotel.utils;

import java.util.Calendar;

public class DatetimeUtils {

    public String addMonths(int months){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, months);
        return calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)) + "/" + calendar.get(Calendar.YEAR);
    }

    public String addMonthAndDays(int months, int days){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, months);
        calendar.add(Calendar.DATE, days);
        return calendar.get(Calendar.DATE) + "/" + (calendar.get(Calendar.MONTH)) + "/" + calendar.get(Calendar.YEAR);
    }
}
