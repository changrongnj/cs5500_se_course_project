package model;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Random;

public class PilotSim {

    double[] visitDist = new double[] {0.03, 0.05, 0.06, 0.08, 0.09, 0.11, 0.095, 0.08, 0.07, 0.085, 0.12, 0.095, 0.035};

    public int findHour(int num, double[] visitCumulative) {
        for (int i = 0; i < visitCumulative.length; i++) {
            if (num < visitCumulative[i]) {
                return i + 8; // store opens at 8
            }
        }
        System.out.println("Check the visit distribution, it was over 100%!!!");
        return -1;
    }

    public int randomNumberGenerator(int range) {
        Random rand = new Random();
        int rand_number = rand.nextInt(range);
        return rand_number;
    }

    public LocalDateTime timeGenerator(int day) {

        double[] visitCumulative = new double[13];
        visitCumulative[0] = visitDist[0] * 100;
        for (int i = 1; i < visitDist.length; i++) {
            visitCumulative[i] = visitCumulative[i - 1] + visitDist[i] * 100;
        }

        int randomNum = randomNumberGenerator(100);
        int hour = findHour(randomNum, visitCumulative);
        int min = randomNumberGenerator(60);

        LocalDateTime localDateTime = LocalDateTime.of(2016, Month.MAY, day, hour, min);

        return localDateTime;
    }

}
