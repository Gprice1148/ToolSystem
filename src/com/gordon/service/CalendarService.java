package com.gordon.service;

import com.gordon.model.ToolCharges;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_MONTH;
import static java.util.Calendar.getInstance;

/**
 * Worker class for Calendar
 *
 * @author Gordon Price
 */
public class CalendarService {
    private static final int NUM_TO_INCREASE_DAY_BY = 1;
    /**
     * Calculates how many days between the (exclusive) checkout date and (inclusive) the due date
     * we are able to charge for renting the tool
     *
     * @param checkoutDate Date object containing the checkout date
     * @param rentalDays how many days the tool is being rented for
     * @param toolCharge ToolCharges object containing daily charge information
     * @return int how many days we can charge for
     */
    public static int calculateChargeableDays(Date checkoutDate, int rentalDays, ToolCharges toolCharge){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(checkoutDate);
        int chargeableDays = 0;
        for (int i = 0; i < rentalDays; i++) {
            calendar.add(Calendar.DAY_OF_MONTH, NUM_TO_INCREASE_DAY_BY);
            if (CalendarService.isDayHoliday(calendar) && !toolCharge.isHolidayCharge()){
                continue;
            }else if (CalendarService.isDayWeekend(calendar) && !toolCharge.isWeekendCharge()) {
                continue;
            }else if (CalendarService.isDayWeekDay(calendar) && !toolCharge.isWeekDayCharge()) {
                continue;
            }
            chargeableDays++;
        }
        return chargeableDays;
    }

    /**
     *Calculates the date the tool should be returned on
     *
     * @param checkoutDate Date object containing the checkout date
     * @param rentalDays how many days the tool is being rented for
     * @return Date object containing the due date
     */
    public static Date calculateDueDate(Date checkoutDate, int rentalDays){
        Calendar calendar = getInstance();
        calendar.setTime(checkoutDate);
        calendar.add(DAY_OF_MONTH, rentalDays);
        return calendar.getTime();
    }

    /**
     * Finds out if a day is a holiday or not
     *
     * @param calendar that must contain the date in question
     * @return True if the day is a holiday, false if not a holiday
     */
    public static boolean isDayHoliday(Calendar calendar) {
        if (calendar.get(Calendar.MONTH) == Calendar.SEPTEMBER && calendar.get(Calendar.WEEK_OF_MONTH) == 1 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
            return true;
            /** July 4th is a weekday || If July 3rd is a Friday || July 5th is a Monday ||  **/
        } else if (calendar.get(Calendar.MONTH) == Calendar.JULY &&
                (calendar.get(Calendar.DAY_OF_MONTH) == 4 && isDayWeekDay(calendar)) ||
                (calendar.get(Calendar.DAY_OF_MONTH) == 3 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) ||
                (calendar.get(Calendar.DAY_OF_MONTH) == 5 && calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Finds out if day is weekend day or not
     *
     * @param calendar that must contain the date in question
     * @return True if it is a weekend day, false if not a weekend day
     */
    public static boolean isDayWeekend(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY;
    }

    /**
     * Finds out if the day is a week day or not
     *
     * @param calendar that must contain the date in question
     * @return True if it is a week day, false if not a week day
     */
    public static boolean isDayWeekDay(Calendar calendar) {
        return calendar.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY || calendar.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY ||
                calendar.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY;
    }
}
