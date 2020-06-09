package model;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 *
 */
public class DateTime {
    private LocalDateTime localDateTime;
    private Weather weather;
    private HolidayType holidayType;

    /**
     *
     * @param localDateTime
     * @param weather
     * @param holidayType
     */
    public DateTime(LocalDateTime localDateTime, Weather weather, HolidayType holidayType) {
        this.localDateTime = localDateTime;
        this.weather = weather;
        this.holidayType = holidayType;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getLocalDateTime() {
        return this.localDateTime;
    }

    /**
     *
     * @return
     */
    public Weather getWeather() {
        return this.weather;
    }

    /**
     *
     * @return
     */
    public HolidayType getHolidayType() {
        return this.holidayType;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "DateTime{" +
            "localDateTime=" + this.localDateTime +
            ", weather=" + this.weather +
            ", holidayType=" + this.holidayType +
            '}';
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DateTime)) {
            return false;
        }
        DateTime dateTime = (DateTime) o;
        return Objects.equals(this.getLocalDateTime(), dateTime.getLocalDateTime()) &&
            Objects.equals(this.getWeather(), dateTime.getWeather()) &&
            this.getHolidayType() == dateTime.getHolidayType();
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.getLocalDateTime(), this.getWeather(), this.getHolidayType());
    }
}
