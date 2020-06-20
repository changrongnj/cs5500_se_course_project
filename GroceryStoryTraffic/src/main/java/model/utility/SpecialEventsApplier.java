package model.utility;

import model.HolidayType;

public final class SpecialEventsApplier {
  private SpecialEventsApplier() {}

  /**
   * Given a a HolidayType and an int representing the current customer volume, returns an int
   * representing the total customer volume after applying holiday considerations.
   * @param holiday - HolidayType representing the holiday modification to consider.
   * @param currentVolume - int representing the unmodified customer volume
   * @return an int representing the total customer volume after applying holiday considerations.
   */
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

  // Should have either lunch AND dinner effects or neither effect.
  public static void applyMealRushEffect() {

  }


  // Should have bad weather, nice, weather, OR neutral weather.
  public static void applyWeatherEffect() {

  }
}
