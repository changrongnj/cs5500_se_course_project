package model.utility;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import model.HolidayType;
import model.Visit;
import model.WeatherType;

public final class Modifier {
  private Modifier() {}

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
  // Todo: Need to pass parameters reflecting the lunch start/end, dinner lunch/end.
  // Todo: Consider separating lunch and dinner effects.
  public static List<Visit> applyMealRushEffect() {
    double[] mealDurationDist = {1.0, 0, 0, 0, 0, 0};
    double[] lunchDurationDist = {};  // Todo: Need to convert parameters to distribution.
    double[] dinnerDurationDist = {};  // Todo Need to convert parameters to distribution.


    // Todo: Generate additional visits in the given time frame.
    return null;  // No modifications.
  }

  // Checking for poor weather.
  // Should be called before visit generation.
  public static int applyPoorWeather(WeatherType weather, int currentVolume, DayOfWeek dayOfWeek) {
    if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
      final double POOR_WEATHER_FACTOR = 0.7;
      if (weather == WeatherType.IS_POOR) {
        return (int) (currentVolume * POOR_WEATHER_FACTOR);  // Modified.
      }
    }
    return currentVolume;  // Unmodified.
  }

  // Should be called after baseline visit generation.
  public static List<Visit> applyNiceWeather(WeatherType weather, int volume, DayOfWeek dayOfWeek) {
    if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
      if (weather == WeatherType.IS_NICE) {
        final double NICE_WEATHER_BOOST = 0.4;
        double[] durationDist = {.50, .30, .15, .0125, .015, .0125};
        double[] entryDist = {0, 0, 0, 0, .1, .1, .2, .1, 0, 0, .1, .2, .2, 0, 0};
        List<Visit> newVisits = new ArrayList<>();
        int extraVisits = (int) Math.ceil(NICE_WEATHER_BOOST * volume);
        for (int i = 0; i < extraVisits; i++) {
          //  Todo: Figure out how to generate visits using the methods in RandomGenerator.
        }
        // Create visits and append to visits.
      }
    }
    return null;  // No modifications.
  }

  // Todo: Need to figure out what parameters to pass to determine start/end time of discount.
  // Todo: Need to check that this is indeed the discount day.
  public static List<Visit> applySeniorDiscount() {
    double[] seniorDurationDist = {0, 0, 0, .45, .5, .05};
    double[] seniorVisitDist = {};  // Todo: Need to figure out this part from passed parameters.

    // Todo: Generate additional visits in the given time frame.
    return null;  // No modifications.
  }
}
