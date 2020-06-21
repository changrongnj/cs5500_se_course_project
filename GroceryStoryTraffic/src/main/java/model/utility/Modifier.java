package model.utility;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.HolidayType;
import model.Visit;
import model.WeatherType;

import javax.xml.transform.Result;

public final class Modifier {
  private Modifier() {}

  // checking for the day of holiday.
  // should be called before visit generation.
  public static int applyHolidayVolume(HolidayType holiday, int currentVolume) {
    if (holiday == HolidayType.IS_HOLIDAY) {
      final double HOLIDAY_FACTOR = 1.20;
      return (int) (currentVolume * HOLIDAY_FACTOR);  // Modified.
    }
    return currentVolume;  // Unmodified.
  }

  // Checking for poor weather.
  // Should be called before visit generation.
  public static int applyPoorWeatherVolume(WeatherType weather, int currentVolume, DayOfWeek dayOfWeek) {
    if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
      final double POOR_WEATHER_FACTOR = 0.7;
      if (weather == WeatherType.IS_POOR) {
        return (int) (currentVolume * POOR_WEATHER_FACTOR);  // Modified.
      }
    }
    return currentVolume;  // Unmodified.
  }

  /**
   * Generate additional customers for dayBeforeHoliday and weekBeforeHoliday
   * @param holiday: holiday type
   * @param currentVolume: daily normal volume without applying any events.
   * @return three values:
   * holidayEntryTimeDist: total additional volume,
   * holidayDurationDist: entry time distribution (same as weekend)
   * holidayVolume: additional volume due to dayBeforeHoliday or weekBeforeHoliday
   */
  public static class ResultType {
    public double[] entryDist;
    public double[] durationDist;
    public int additionalVolume;
    public ResultType(int volume, double[] entry, double[] duration) {
      this.additionalVolume = volume;
      this.entryDist = entry;
      this.durationDist = duration;
    }
  }
  public static ResultType applyBeforeHoliday(HolidayType holiday, int currentVolume) {
    final double DAY_BEFORE_HOLIDAY_BOOST = 0.40;
    final double WEEK_TO_HOLIDAY_BOOST = 0.15;
    final double[] entryDist = {0.003, 0.005, 0.03, 0.05, 0.06, 0.07,
            0.08, 0.085, 0.09, 0.095, 0.095, 0.095, 0.097, 0.085, 0.06};
    final double[] durationDist = {0, 0.1 , 0.2, 0.25, 0.3, 0.15};
    int additionalVolume;
    switch (holiday) {
      case DAY_BEFORE_HOLIDAY:
        additionalVolume = (int) (currentVolume * DAY_BEFORE_HOLIDAY_BOOST);
      case WEEK_TO_HOLIDAY:
        additionalVolume = (int) (currentVolume * WEEK_TO_HOLIDAY_BOOST);
      default:
        additionalVolume = 0;
    }
    return new ResultType(additionalVolume, entryDist, durationDist);
  }

  public static ResultType applyNiceWeather(int currentVolume) {
        final double NICE_WEATHER_BOOST = 0.4;
        double[] durationDist = {.50, .30, .15, .0125, .015, .0125};
        double[] entryDist = {0, 0, 0, 0, .1, .1, .2, .1, 0, 0, .1, .2, .2, 0, 0};
        int additionalVolume = (int) (currentVolume * NICE_WEATHER_BOOST);
        return new ResultType(additionalVolume, entryDist, durationDist);
  }


  // Should have either lunch AND dinner effects or neither effect.
  // Todo: Need to pass parameters reflecting the lunch start/end, dinner lunch/end.
  // Todo: Consider separating lunch and dinner effects.
  // Todo: need to change entryDist to be possible for :30.  Not priority I think...
  public static ResultType applyMealRush(int currentVolume) {
    final double MEAL_BOOST = 0.3;
    double[] durationDist = {1.0, 0, 0, 0, 0, 0};
    double[] entryDist = {0, 0, 0, 0, 0, 0, .4, 0, 0, 0, .6, 0, 0, 0, 0};
    int additionalVolume = (int) (currentVolume * MEAL_BOOST);
    return new ResultType(additionalVolume, entryDist, durationDist);
  }


  // Todo: Need to figure out what parameters to pass to determine start/end time of discount.
  // Todo: Need to check that this is indeed the discount day.
  // Todo: Same as above, think about how to auto change distribution instead manually locating hour and entry to distribution.
  public static ResultType applySeniorDiscount(int currentVolume) {
    double[] seniorDurationDist = {0, 0, 0, .45, .5, .05};
    double[] seniorVisitDist = {};  // Todo: Need to figure out this part from passed parameters.
    final double SENIOR_BOOST = 0.3;
    double[] durationDist = {0, 0, 0, .45, .5, .05};
    double[] entryDist = {0, 0, 0, 0, 0, 0, 0, 0.5, 0.5, 0,0, 0, 0, 0, 0};
    int additionalVolume = (int) (currentVolume * SENIOR_BOOST);
    return new ResultType(additionalVolume, entryDist, durationDist);

  }
}
