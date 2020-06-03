package model;

import java.time.LocalDateTime;

public class DateTime {

    // localDate class is useful,
    // if you want to use other classes,
    // I suggest you convert them into localDatetime at first,
    // then use my functions
    private LocalDateTime localDateTime;
    private Weather weather;
    private HolidayType holidayType;

    // constructor
    public DateTime(LocalDateTime localDateTime, Weather weather, HolidayType holidayType) {
        this.localDateTime = localDateTime;
        this.weather = weather;
        this.holidayType = holidayType;
    }

    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public Weather getWeather() {
        return this.weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public HolidayType isHoliday() {
        return this.holidayType;
    }

    public void setHoliday(HolidayType holiday) {
        this.holidayType = holiday;
    }

}
