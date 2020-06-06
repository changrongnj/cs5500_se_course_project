package model.utility;

import model.HolidayType;
import model.data.Constant;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;

public final class DistributionDeterminer {

    private DistributionDeterminer() {}

    public static int getDailyVolume(LocalDate ld, Constant constant, Util util) {

        int DAILY_VOLUME = 0;
        // Fixed so that getHolidayInfo accepts LocalDate instead.
        HolidayType holidayType = HolidayDeterminer.getHolidayInfo(ld);
        if(holidayType == HolidayType.IS_HOLIDAY) {
            DAILY_VOLUME = constant.getAmountOfCustomers().get("Holiday");
        } else if(holidayType == HolidayType.DAY_BEFORE_HOLIDAY) {
            DAILY_VOLUME = constant.getAmountOfCustomers().get("DayBeforeHoliday");
        } else if(holidayType == HolidayType.WEEK_TO_HOLIDAY) {
            if(ld.getDayOfWeek() == DayOfWeek.MONDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("MondayBeforeHoliday");
            } else if(ld.getDayOfWeek() == DayOfWeek.TUESDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("TuesdayBeforeHoliday");
            } else if(ld.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("WednesdayBeforeHoliday");
            } else if(ld.getDayOfWeek() == DayOfWeek.THURSDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("ThursdayBeforeHoliday");
            } else if(ld.getDayOfWeek() == DayOfWeek.FRIDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("FridayBeforeHoliday");
            } else if(ld.getDayOfWeek() == DayOfWeek.SATURDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("SaturdayBeforeHoliday");
            } else if(ld.getDayOfWeek() == DayOfWeek.SUNDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("SundayBeforeHoliday");
            } else {
                DAILY_VOLUME = -1;
                System.out.println("unexpected day of week");
            }
        } else if(holidayType == HolidayType.NON_HOLIDAY) {
            if(ld.getDayOfWeek() == DayOfWeek.MONDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("Monday");
            } else if(ld.getDayOfWeek() == DayOfWeek.TUESDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("Tuesday");
            } else if(ld.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("Wednesday");
            } else if(ld.getDayOfWeek() == DayOfWeek.THURSDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("Thursday");
            } else if(ld.getDayOfWeek() == DayOfWeek.FRIDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("Friday");
            } else if(ld.getDayOfWeek() == DayOfWeek.SATURDAY) {
                if(util.findWeather(ld.atTime(12, 0)).getWasNiceWeather()) {
                    DAILY_VOLUME = constant.getAmountOfCustomers().get("NiceWeekend");
                } else {
                    DAILY_VOLUME = constant.getAmountOfCustomers().get("Saturday");
                }
            } else if(ld.getDayOfWeek() == DayOfWeek.SUNDAY) {
                if(util.findWeather(ld.atTime(12, 0)).getWasNiceWeather()) {
                    DAILY_VOLUME = constant.getAmountOfCustomers().get("NiceWeekend");
                } else {
                    DAILY_VOLUME = constant.getAmountOfCustomers().get("Sunday");
                }
            }
        } else {
            System.out.println("unexpected holiday type");
            return -1;
        }
        return DAILY_VOLUME;
    }

    public static LocalDateTime getEntryTime(int i, LocalDate ld, Constant constant, Util util) {
        LocalDateTime ldt = LocalDateTime.now();
        if(ld.getDayOfWeek() == DayOfWeek.MONDAY) {
            ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("Monday"));
        } else if(ld.getDayOfWeek() == DayOfWeek.TUESDAY) {
            ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("Tuesday"));
        } else if(ld.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("Wednesday"));
        } else if(ld.getDayOfWeek() == DayOfWeek.THURSDAY) {
            ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("Thursday"));
        } else if(ld.getDayOfWeek() == DayOfWeek.FRIDAY) {
            ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("Friday"));
        } else if(ld.getDayOfWeek() == DayOfWeek.SATURDAY) {
            ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("Saturday"));
            if(util.findWeather(ldt).getWasNiceWeather()) {
                ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("NiceSaturday"));
            }
        } else if(ld.getDayOfWeek() == DayOfWeek.SUNDAY) {
            ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("Sunday"));
            if(util.findWeather(ldt).getWasNiceWeather()) {
                ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("NiceSunday"));
            }
        }
        return ldt;
    }

    public static double[] getDurationDistribution(LocalDateTime ldt, Constant constant, Util util) {

        double[] durationDist = new double[0];
        if(ldt.getDayOfWeek() == DayOfWeek.MONDAY) {
            if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("6-9").get("Monday");
            } else if(ldt.getHour() < 12) {
                durationDist = constant.getDurationTimeDist().get("10-11").get("Monday");
            } else if(ldt.getHour() < 13) {
                durationDist = constant.getDurationTimeDist().get("12").get("Monday");
            } else if(ldt.getHour() < 17) {
                durationDist = constant.getDurationTimeDist().get("13-16").get("Monday");
            } else if(ldt.getHour() < 19) {
                durationDist = constant.getDurationTimeDist().get("17-18").get("Monday");
            } else {
                durationDist = constant.getDurationTimeDist().get("19-20").get("Monday");
            }
        } else if(ldt.getDayOfWeek() == DayOfWeek.TUESDAY) {
            if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("6-9").get("Tuesday");
            } else if(ldt.getHour() < 12) {
                durationDist = constant.getDurationTimeDist().get("10-11").get("Tuesday");
            } else if(ldt.getHour() < 13) {
                durationDist = constant.getDurationTimeDist().get("12").get("Tuesday");
            } else if(ldt.getHour() < 17) {
                durationDist = constant.getDurationTimeDist().get("13-16").get("Tuesday");
            } else if(ldt.getHour() < 19) {
                durationDist = constant.getDurationTimeDist().get("17-18").get("Tuesday");
            } else {
                durationDist = constant.getDurationTimeDist().get("19-20").get("Tuesday");
            }
        } else if(ldt.getDayOfWeek() == DayOfWeek.WEDNESDAY) {
            if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("6-9").get("Wednesday");
            } else if(ldt.getHour() < 12) {
                durationDist = constant.getDurationTimeDist().get("10-11").get("Wednesday");
            } else if(ldt.getHour() < 13) {
                durationDist = constant.getDurationTimeDist().get("12").get("Wednesday");
            } else if(ldt.getHour() < 17) {
                durationDist = constant.getDurationTimeDist().get("13-16").get("Wednesday");
            } else if(ldt.getHour() < 19) {
                durationDist = constant.getDurationTimeDist().get("17-18").get("Wednesday");
            } else {
                durationDist = constant.getDurationTimeDist().get("19-20").get("Wednesday");
            }
        } else if(ldt.getDayOfWeek() == DayOfWeek.THURSDAY) {
            if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("6-9").get("Thursday");
            } else if(ldt.getHour() < 12) {
                durationDist = constant.getDurationTimeDist().get("10-11").get("Thursday");
            } else if(ldt.getHour() < 13) {
                durationDist = constant.getDurationTimeDist().get("12").get("Thursday");
            } else if(ldt.getHour() < 17) {
                durationDist = constant.getDurationTimeDist().get("13-16").get("Thursday");
            } else if(ldt.getHour() < 19) {
                durationDist = constant.getDurationTimeDist().get("17-18").get("Thursday");
            } else {
                durationDist = constant.getDurationTimeDist().get("19-20").get("Thursday");
            }
        } else if(ldt.getDayOfWeek() == DayOfWeek.FRIDAY) {
            if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("6-9").get("Friday");
            } else if(ldt.getHour() < 12) {
                durationDist = constant.getDurationTimeDist().get("10-11").get("Friday");
            } else if(ldt.getHour() < 13) {
                durationDist = constant.getDurationTimeDist().get("12").get("Friday");
            } else if(ldt.getHour() < 17) {
                durationDist = constant.getDurationTimeDist().get("13-16").get("Friday");
            } else if(ldt.getHour() < 19) {
                durationDist = constant.getDurationTimeDist().get("17-18").get("Friday");
            } else {
                durationDist = constant.getDurationTimeDist().get("19-20").get("Friday");
            }
        } else if(ldt.getDayOfWeek() == DayOfWeek.SATURDAY) {
            if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("6-9").get("Saturday");
            } else if(ldt.getHour() < 12) {
                durationDist = constant.getDurationTimeDist().get("10-11").get("Saturday");
            } else if(ldt.getHour() < 13) {
                durationDist = constant.getDurationTimeDist().get("12").get("Saturday");
            } else if(ldt.getHour() < 17) {
                durationDist = constant.getDurationTimeDist().get("13-16").get("Saturday");
            } else if(ldt.getHour() < 19) {
                durationDist = constant.getDurationTimeDist().get("17-18").get("Saturday");
            } else {
                durationDist = constant.getDurationTimeDist().get("19-20").get("Saturday");
            }
            if(util.findWeather(ldt).getWasNiceWeather()) {
                if(ldt.getHour() < 10) {
                    durationDist = constant.getDurationTimeDist().get("6-9").get("NiceSaturday");
                } else if(ldt.getHour() < 12) {
                    durationDist = constant.getDurationTimeDist().get("10-11").get("NiceSaturday");
                } else if(ldt.getHour() < 13) {
                    durationDist = constant.getDurationTimeDist().get("12").get("NiceSaturday");
                } else if(ldt.getHour() < 17) {
                    durationDist = constant.getDurationTimeDist().get("13-16").get("NiceSaturday");
                } else if(ldt.getHour() < 19) {
                    durationDist = constant.getDurationTimeDist().get("17-18").get("NiceSaturday");
                } else {
                    durationDist = constant.getDurationTimeDist().get("19-20").get("NiceSaturday");
                }
            }
        } else if(ldt.getDayOfWeek() == DayOfWeek.SUNDAY) {
            if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("6-9").get("Sunday");
            } else if(ldt.getHour() < 12) {
                durationDist = constant.getDurationTimeDist().get("10-11").get("Sunday");
            } else if(ldt.getHour() < 13) {
                durationDist = constant.getDurationTimeDist().get("12").get("Sunday");
            } else if(ldt.getHour() < 17) {
                durationDist = constant.getDurationTimeDist().get("13-16").get("Sunday");
            } else if(ldt.getHour() < 19) {
                durationDist = constant.getDurationTimeDist().get("17-18").get("Sunday");
            } else {
                durationDist = constant.getDurationTimeDist().get("19-20").get("Sunday");
            }
            if(util.findWeather(ldt).getWasNiceWeather()) {
                if(ldt.getHour() < 10) {
                    durationDist = constant.getDurationTimeDist().get("6-9").get("NiceSunday");
                } else if(ldt.getHour() < 12) {
                    durationDist = constant.getDurationTimeDist().get("10-11").get("NiceSunday");
                } else if(ldt.getHour() < 13) {
                    durationDist = constant.getDurationTimeDist().get("12").get("NiceSunday");
                } else if(ldt.getHour() < 17) {
                    durationDist = constant.getDurationTimeDist().get("13-16").get("NiceSunday");
                } else if(ldt.getHour() < 19) {
                    durationDist = constant.getDurationTimeDist().get("17-18").get("NiceSunday");
                } else {
                    durationDist = constant.getDurationTimeDist().get("19-20").get("NiceSunday");
                }
            }
        }

        return durationDist;
    }
}
