package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class HolidayRelatedDates {
  private HashMap<Integer, HashMap<HolidayType, List<LocalDate>>> map;

  public HolidayRelatedDates(Integer year) {
  }

  private List<LocalDate> generate2016holidays() {
    final int YEAR = 2016;
    List<LocalDate> dates = new ArrayList<>();
    dates.add(LocalDate.of(YEAR, 1, 1));
    dates.add(LocalDate.of(YEAR, 1, 18));
    dates.add(LocalDate.of(YEAR, 2, 15));
    dates.add(LocalDate.of(YEAR, 5, 30));
    dates.add(LocalDate.of(YEAR, 7, 4));
    dates.add(LocalDate.of(YEAR, 9, 5));
    dates.add(LocalDate.of(YEAR, 11, 4));
    dates.add(LocalDate.of(YEAR, 11, 24));
    dates.add(LocalDate.of(YEAR, 12, 25));
    return dates;
  }

  private List<LocalDate> subtractByDays(List<LocalDate> holidays, long days) {
    return holidays.stream().map(holiday -> holiday.minusDays(days)).collect(Collectors.toList());
  }

  // Gets the map for 2016 data for all three holiday types.
  public HashMap<HolidayType, List<LocalDate>> get2016Map() {
    HashMap<HolidayType, List<LocalDate>> map = new HashMap<>();
    List<LocalDate> holidays = this.generate2016holidays();
    List<LocalDate> dayBeforeHolidays = this.subtractByDays(holidays, 1);
    List<LocalDate> weekToHolidays = this.subtractByDays(holidays, 7);
    map.put(HolidayType.IS_HOLIDAY, holidays);
    map.put(HolidayType.DAY_BEFORE_HOLIDAY, dayBeforeHolidays);
    map.put(HolidayType.WEEK_TO_HOLIDAY, weekToHolidays);
    return map;
  }
}
