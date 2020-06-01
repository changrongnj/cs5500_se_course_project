package model;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;

public final class RandomGenerator {

  private RandomGenerator() {}  // Private constructor; cannot create instance.

  /**
   * Given the following parameters, returns a LocalDateTime instance representing the entry
   * information of a visit.
   * @param visitDay - An int representing the day of a month that the visit occurred.
   * @param visitDist - An array of doubles representing the visit distribution by percentage.
   * @return a LocalDateTime instance representing the entry information of a visit.
   */
  public static LocalDateTime generateEntryData(int visitDay, double[] visitDist) {
    final int MINUTES_PER_HOUR = 60;
    final int FULL_PERCENTAGE = 100;
    final int VISIT_YEAR = 2016;  // Make this a parameter?
    final Month month = Month.MAY;  // Make this a parameter?

    int visitPercentage = randomNumberGenerator(FULL_PERCENTAGE);
    int entryHour = findHour(visitPercentage, getVisitCumulative(visitDist));
    int entryMinute = randomNumberGenerator(MINUTES_PER_HOUR);

    return LocalDateTime.of(VISIT_YEAR, month, visitDay, entryHour, entryMinute);
  }

  // Todo: Implement this method. Accepts a duration distribution and generates data accordingly.
  public static int generateDuration() {
    return 0;
  }

  /**
   * Returns a pseudo-randomly generated int between 0 and non-inclusive range.
   * @param range - An int representing the non-inclusive end range of a random number.
   * @return a pseudo-randomly generated int between 0 and non-inclusive range.
   */
  private static int randomNumberGenerator(int range) {
    Random rand = new Random();
    return rand.nextInt(range);
  }

  /**
   * Given an array of doubles representing a one-day visit distribution by percentage, returns an
   * array of doubles representing the cumulative visits by hour for the day.
   * @param visitDist - Array of doubles representing the visit distribution by percentage.
   * @return an array of doubles representing the cumulative visits by hour for the day.
   */
  private static double[] getVisitCumulative(double[] visitDist) {
    final int TOTAL_STORE_HOURS = 13;
    final int PERCENT_CONVERSION_FACTOR = 100;

    double[] visitCumulative = new double[TOTAL_STORE_HOURS];
    visitCumulative[0] = visitDist[0] * PERCENT_CONVERSION_FACTOR;

    for (int i = 1; i < visitDist.length; i++) {
      visitCumulative[i] = visitCumulative[i - 1] + visitDist[i] * PERCENT_CONVERSION_FACTOR;
    }
    return visitCumulative;
  }

  /**
   * Given an int representing the random distribution threshold and a double array representing the
   * cumulative visits, returns an int representing the hour of a particular visit.
   * @param num - An int representing the random distribution threshold.
   * @param visitCumulative - double array representing cumulative visit totals per hour.
   * @return an int representing the hour of a particular visit.
   */
  private static int findHour(int num, double[] visitCumulative) {
    final int STORE_OPENING_HOUR = 6;
    final int DEFAULT_RETURN = -1;

    for (int i = 0; i < visitCumulative.length; i++) {
      if (num < visitCumulative[i]) {
        return i + STORE_OPENING_HOUR; // store opens at 6
      }
    }
    System.out.println("Check the visit distribution, it was over 100%!!!");
    return DEFAULT_RETURN;
  }
}
