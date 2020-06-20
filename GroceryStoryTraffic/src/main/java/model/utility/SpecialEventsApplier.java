package model.utility;

import java.util.List;
import model.HolidayType;
import model.Visit;
import model.WeatherType;

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

  // Checking for poor weather.
  // Should be called before visit generation.
  public static int applyPoorWeatherVolume(WeatherType weather, int currentVolume) {
    final double POOR_WEATHER_FACTOR = 0.7;
    if (weather == WeatherType.IS_POOR) {
      return (int) (currentVolume * POOR_WEATHER_FACTOR);
    } else {
      return currentVolume;
    }
  }

  // Should be called after baseline visit generation.
  public static List<Visit> applyNiceWeatherEffect(WeatherType weatherType, List<Visit> visits) {
    switch (weatherType) {
      case IS_NICE:
        System.out.println();
      case IS_POOR:
        System.out.println();
      default:
        return visits;
    }
  }
}
