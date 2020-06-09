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
                DAILY_VOLUME = constant.getAmountOfCustomers().get("Saturday");
            } else if(ld.getDayOfWeek() == DayOfWeek.SUNDAY) {
                DAILY_VOLUME = constant.getAmountOfCustomers().get("Sunday");
            }
        return DAILY_VOLUME;
    }

    public static int applyHolidayVolume(HolidayType holiday, int currentVolume) {
        final double HOLIDAY_FACTOR = 1.20;
        final double DAY_BEFORE_HOLIDAY_FACTOR = 1.40;
        final double WEEK_TO_HOLIDAY_FACTOR = 1.15;

        switch (holiday) {
            case IS_HOLIDAY:
                return (int) (currentVolume * HOLIDAY_FACTOR);
            case DAY_BEFORE_HOLIDAY:
                return (int) (currentVolume * DAY_BEFORE_HOLIDAY_FACTOR);
            case WEEK_TO_HOLIDAY:
                return (int) (currentVolume * WEEK_TO_HOLIDAY_FACTOR);
            default:
                return currentVolume;
        }
    }

    public static int applyNiceWeatherVolume(LocalDate ld, int currentVolume, Util util) {

        final double NICE_WEATHER_FACTOR = 1.40;

        if(ld.getDayOfWeek() == DayOfWeek.SATURDAY || ld.getDayOfWeek() == DayOfWeek.SUNDAY) {
            if(util.findWeather(ld.atTime(12, 0)).getWasNiceWeather())
                currentVolume *= NICE_WEATHER_FACTOR;
        }

        return currentVolume;
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
        } else if(ld.getDayOfWeek() == DayOfWeek.SUNDAY) {
            ldt = RandomGenerator.generateEntryData(i, constant.getEntryTimeDist().get("Sunday"));
        }
        return ldt;
    }

    public static double[] getDurationDistribution(LocalDateTime ldt, Constant constant, Util util) {

        double[] durationDist = new double[0];
        if(ldt.getDayOfWeek() == DayOfWeek.MONDAY) {
            if(ldt.getHour() < 8) {
                durationDist = constant.getDurationTimeDist().get("6-7").get("Monday");
            } else if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("8-9").get("Monday");
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
            if(ldt.getHour() < 8) {
                durationDist = constant.getDurationTimeDist().get("6-7").get("Tuesday");
            } else if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("8-9").get("Tuesday");
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
            if(ldt.getHour() < 8) {
                durationDist = constant.getDurationTimeDist().get("6-7").get("Wednesday");
            } else if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("8-9").get("Wednesday");
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
            if(ldt.getHour() < 8) {
                durationDist = constant.getDurationTimeDist().get("6-7").get("Thursday");
            } else if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("8-9").get("Thursday");
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
            if(ldt.getHour() < 8) {
                durationDist = constant.getDurationTimeDist().get("6-7").get("Friday");
            } else if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("8-9").get("Friday");
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
            if(ldt.getHour() < 8) {
                durationDist = constant.getDurationTimeDist().get("6-7").get("Saturday");
            } else if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("8-9").get("Saturday");
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
        } else if(ldt.getDayOfWeek() == DayOfWeek.SUNDAY) {
            if(ldt.getHour() < 8) {
                durationDist = constant.getDurationTimeDist().get("6-7").get("Sunday");
            } else if(ldt.getHour() < 10) {
                durationDist = constant.getDurationTimeDist().get("8-9").get("Sunday");
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
        }

        return durationDist;
    }
}
