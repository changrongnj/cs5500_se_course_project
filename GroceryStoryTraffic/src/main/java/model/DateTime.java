package model;

import java.time.LocalDateTime;

public class DateTime {

    // localDate class is useful,
    // if you want to use other classes,
    // I suggest you convert them into localDatetime at first,
    // then use my functions
    private LocalDateTime localDateTime;

    private boolean isHoliday;

    // constructor
    public DateTime(LocalDateTime localDateTime, boolean isHoliday) {
        this.localDateTime = localDateTime;
        this.isHoliday = isHoliday;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public boolean isHoliday() {
        return isHoliday;
    }

    public void setHoliday(boolean holiday) {
        isHoliday = holiday;
    }

}
