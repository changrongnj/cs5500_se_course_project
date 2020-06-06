package model.utility;

import model.Constant;
import model.HolidayType;

import java.time.LocalDate;
import java.time.LocalDateTime;

public final class DistributionDeterminer {

    private DistributionDeterminer() {}

    public static int getDailyVolume(LocalDate ld, Constant constant, Util util) {

        int DAILY_VOLUME = 0;

        HolidayType holidayType = HolidayDeterminer.getHolidayInfo(ld);
        switch (holidayType) {
            case IS_HOLIDAY:
                DAILY_VOLUME = constant.getAmountOfCustomers().get("Holiday");
            case DAY_BEFORE_HOLIDAY:
                DAILY_VOLUME = constant.getAmountOfCustomers().get("DayBeforeHoliday");
            case WEEK_TO_HOLIDAY:
                switch (ld.getDayOfWeek()) {
                    case MONDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("MondayBeforeHoliday");
                    case TUESDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("TuesdayBeforeHoliday");
                    case WEDNESDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("WednesdayBeforeHoliday");
                    case THURSDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("ThursdayBeforeHoliday");
                    case FRIDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("FridayBeforeHoliday");
                    case SATURDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("SaturdayBeforeHoliday");
                    case SUNDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("SundayBeforeHoliday");
                }
            case NON_HOLIDAY:
                switch (ld.getDayOfWeek()) {
                    case MONDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("Monday");
                    case TUESDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("Tuesday");
                    case WEDNESDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("Wednesday");
                    case THURSDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("Thursday");
                    case FRIDAY:
                        DAILY_VOLUME = constant.getAmountOfCustomers().get("Friday");
                    case SATURDAY:
                        // TODO: I use the weather at 12am to represent the whole day's weather(there could be some better idea)
                        if(util.findWeather(ld.atTime(12, 0)).getWasNiceWeather()) {
                            DAILY_VOLUME = constant.getAmountOfCustomers().get("NiceWeekend");
                        } else {
                            DAILY_VOLUME = constant.getAmountOfCustomers().get("Saturday");
                        }
                    case SUNDAY:
                        if(util.findWeather(ld.atTime(12, 0)).getWasNiceWeather()) {
                            DAILY_VOLUME = constant.getAmountOfCustomers().get("NiceWeekend");
                        } else {
                            DAILY_VOLUME = constant.getAmountOfCustomers().get("Sunday");
                        }
                }
        }

        return DAILY_VOLUME;
    }
}
