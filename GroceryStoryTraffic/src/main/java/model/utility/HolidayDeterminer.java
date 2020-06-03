package model.utility;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import model.HolidayRelatedDates;
import model.HolidayType;

public final class HolidayDeterminer {
  private HolidayDeterminer() {}

/*  // self-defined function to calculate DayOfWeekInMonth
  public static int calDayOfWeekInMonth(LocalDateTime ldt) {
    LocalDate monthStart = LocalDate.of(ldt.getYear(), ldt.getMonth(), 1);
    DayOfWeek dayOfWeek = monthStart.getDayOfWeek();
    int newStart = 8 - dayOfWeek.getValue();
    return (ldt.getDayOfMonth() - newStart + 7 - 1) / 7 + 1;
  }*/

  public static boolean isHoliday(List<LocalDate> localDates, LocalDate ldt) {
    for (LocalDate date : localDates) {
      if (date.equals(ldt)) {
        return true;
      }
    }
    return false;
  }

//  public static boolean isDayBeforeHoliday(List<LocalDate> localDates, LocalDate ldt) {
//    for (LocalDate date : localDates) {
//      if (date.equals(ldt)) {
//        return true;
//      }
//    }
//    return false;
//  }

  public static boolean isWeekToHoliday(List<LocalDate> localDates, LocalDate ldt) {
    for (LocalDate date : localDates) {
      int holidayTarget = date.getDayOfYear();
      int potentialMatch = ldt.getDayOfYear();
      if (potentialMatch >= holidayTarget && potentialMatch - 7 <= holidayTarget) {
        return true;
      }
    }
    return false;
  }

  public static HolidayType getHolidayInfo(LocalDateTime ltd) {
    HolidayRelatedDates dates = new HolidayRelatedDates(2016);
    HashMap<HolidayType, List<LocalDate>> allDates = dates.get2016Map();

    if (isHoliday(allDates.get(HolidayType.IS_HOLIDAY), ltd.toLocalDate())) {
      return HolidayType.IS_HOLIDAY;
    }

    if (isHoliday(allDates.get(HolidayType.DAY_BEFORE_HOLIDAY), ltd.toLocalDate())) {
      return HolidayType.DAY_BEFORE_HOLIDAY;
    }

    if (isWeekToHoliday(allDates.get(HolidayType.WEEK_TO_HOLIDAY), ltd.toLocalDate())) {
      return HolidayType.WEEK_TO_HOLIDAY;
    }

    return HolidayType.NON_HOLIDAY;
  }
}
