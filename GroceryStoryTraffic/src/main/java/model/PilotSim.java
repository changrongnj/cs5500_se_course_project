package model;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;

public class PilotSim {

    // Made VISIT_DIST into a constant since we never modify in our calculations.
    private static final int VISIT_YEAR = 2016;
    private static final double[] VISIT_DIST = new double[] {0.03, 0.05, 0.06, 0.08, 0.09, 0.11,
        0.095, 0.08, 0.07, 0.085, 0.12, 0.095, 0.035};
    private double[] visitCumulative = this.generateVisitCumulative();

    /**
     * Returns a double array representing the cumulative visits on a particular day.
     * @return a double array representing the cumulative visits on a particular day.
     */
    private double[] generateVisitCumulative() {
        final int TOTAL_STORE_HOURS = 13;
        final int PERCENT_CONVERSION_FACTOR = 100;

        double[] visitCumulative = new double[TOTAL_STORE_HOURS];
        visitCumulative[0] = VISIT_DIST[0] * PERCENT_CONVERSION_FACTOR;

        // Converts the distribution to actual number of visits and stores its cumulative number.
        for (int i = 1; i < VISIT_DIST.length; i++) {
            visitCumulative[i] = visitCumulative[i - 1] + VISIT_DIST[i] * PERCENT_CONVERSION_FACTOR;
        }
        return visitCumulative;
    }

    /**
     * Returns a double array representing the attribute, cumulative visits.
     * @return a double array representing the attribute, cumulative visits.
     */
    public double[] getVisitCumulative() {
        return this.visitCumulative;
    }

    /**
     * Given an int representing the random distribution threshold, returns an int representing the
     * hour of a particular visit.
     * @param num - An int representing the random distribution threshold.
     * @return an int representing the hour of a particular visit.
     */
    public int findHour(int num) {
        final int STORE_OPENING_HOUR = 8;
        final int DEFAULT_RETURN = -1;

        for (int i = 0; i < this.visitCumulative.length; i++) {
            if (num < this.visitCumulative[i]) {
                return i + STORE_OPENING_HOUR; // store opens at 8
            }
        }
        System.out.println("Check the visit distribution, it was over 100%!!!");
        return DEFAULT_RETURN;
    }

    /**
     * Returns a pseudo-randomly generated int between 0 and non-inclusive range.
     * @param range - An int representing the non-inclusive end range of a random number.
     * @return a pseudo-randomly generated int between 0 and non-inclusive range.
     */
    public int randomNumberGenerator(int range) {
        Random rand = new Random();
        return rand.nextInt(range);
    }

    /**
     * Returns a LocalDateTime instance representing the entry information of a visit.
     * @param visitDay - An int representing the day of a month that the visit occured.
     * @return a LocalDateTime instance representing the entry information of a visit.
     */
    public LocalDateTime timeGenerator(int visitDay) {
        final int MINUTES_PER_HOUR = 60;
        final int FULL_PERCENTAGE = 100;

        // This section of code seems independent of the parameter, day.
        // Moved to a separate method and generated as an attribute of this class instead.
        /*double[] visitCumulative = new double[TOTAL_STORE_HOURS];
        visitCumulative[0] = VISIT_DIST[0] * 100;  // Might still have decimals.
        for (int i = 1; i < VISIT_DIST.length; i++) {
            visitCumulative[i] = visitCumulative[i - 1] + VISIT_DIST[i] * 100;
        }*/
        int randomPercent = this.randomNumberGenerator(FULL_PERCENTAGE);
        int entryHour = this.findHour(randomPercent);
        int entryMinute = this.randomNumberGenerator(MINUTES_PER_HOUR);

        return LocalDateTime.of(VISIT_YEAR, Month.MAY, visitDay, entryHour, entryMinute);
    }

}
