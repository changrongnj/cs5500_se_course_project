package model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Util {

    /**
     * a class containing useful functions for instance initialization
     * */

    // self-defined function to calculate DayOfWeekInMonth
    public int calDayOfWeekInMonth(LocalDateTime ldt) {
        LocalDate monthStart = LocalDate.of(ldt.getYear(), ldt.getMonth(), 1);
        DayOfWeek dayOfWeek = monthStart.getDayOfWeek();
        int newStart = 8 - dayOfWeek.getValue();
        return (ldt.getDayOfMonth() - newStart + 7 - 1) / 7 + 1;
    }

    // determine if the day is a holiday
    // there could be some controversy about holidays but we can discuss later
    public boolean isHoliday(LocalDateTime ldt) {

        // I borrow some code from https://gist.github.com/timperez/9555657

        // check if New Year's Day
        if (ldt.getMonth() == Month.JANUARY && ldt.getDayOfMonth() == 1) {
            return true;
        }

        // check if Christmas
        if (ldt.getMonth() == Month.DECEMBER && ldt.getDayOfMonth() == 25) {
            return true;
        }

        // check if 4th of July
        if (ldt.getMonth() == Month.JULY && ldt.getDayOfMonth() == 4) {
            return true;
        }

        // check Thanksgiving (4th Thursday of November)
        if (ldt.getMonth() == Month.NOVEMBER
                && ldt.getDayOfWeek() == DayOfWeek.THURSDAY
                && calDayOfWeekInMonth(ldt) == 4) {
            return true;
        }

        // check Memorial Day (last Monday of May)
        if (ldt.getMonth() == Month.MAY
                && ldt.getDayOfWeek() == DayOfWeek.MONDAY
                && ldt.getDayOfMonth() > (31 - 7) ) {
            return true;
        }

        // check Labor Day (1st Monday of September)
        if (ldt.getMonth() == Month.SEPTEMBER
                && calDayOfWeekInMonth(ldt) == 1
                && ldt.getDayOfWeek() == DayOfWeek.MONDAY) {
            return true;
        }

        // check President's Day (3rd Monday of February)
        if (ldt.getMonth() == Month.FEBRUARY
                && calDayOfWeekInMonth(ldt) == 3
                && ldt.getDayOfWeek() == DayOfWeek.MONDAY) {
            return true;
        }

        // check Veterans Day (November 11)
        if (ldt.getMonth() == Month.NOVEMBER
                && ldt.getDayOfMonth() == 11) {
            return true;
        }

        // check MLK Day (3rd Monday of January)
        if (ldt.getMonth() == Month.JANUARY
                && calDayOfWeekInMonth(ldt) == 3
                && ldt.getDayOfWeek() == DayOfWeek.MONDAY) {
            return true;
        }

        // IF NOTHING ELSE, IT'S A BUSINESS DAY
        return false;
    }

}
