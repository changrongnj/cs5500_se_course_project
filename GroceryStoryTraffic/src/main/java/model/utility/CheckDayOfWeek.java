package model.utility;

import java.time.DayOfWeek;

public final class CheckDayOfWeek {
  private CheckDayOfWeek() {}

  public static boolean isWeekend(DayOfWeek dayOfWeek) {
    return (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY);
  }
}
