package model;

import java.time.LocalDateTime;

public class DateTime {

    // localDate class is useful,
    // if you want to use other classes,
    // I suggest you convert them into localDatetime at first,
    // then use my functions
    private LocalDateTime localDateTime;
    private Weather weather;
    private boolean isHoliday;

    // constructor
    public DateTime(LocalDateTime localDateTime, Weather weather, boolean isHoliday) {
        this.localDateTime = localDateTime;
        this.weather = weather;
        this.isHoliday = isHoliday;
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

    public boolean isHoliday() {
        return this.isHoliday;
    }

    public void setHoliday(boolean holiday) {
        this.isHoliday = holiday;
    }

}
