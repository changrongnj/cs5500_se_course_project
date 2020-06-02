package controller;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import model.DateTime;
import model.Day;
import model.Visit;
import model.Weather;
import model.utility.RandomGenerator;
import model.utility.Util;
import view.CsvGenerator;


public class PilotSim {
    // PilotSim can be our controller class that contains Model and View instances
    // This class will be in charge of putting everything together for a month of data.
    static final int MONTH = 5;  // Todo: Figure out how to incorporate the month parameter.
    static final int DAYS_IN_MONTH = 31;
    static final int DAILY_VOLUME = 2000;  // Todo: Adjust this to actual values later.
    private static CsvGenerator csvGenerator = new CsvGenerator();
    private static Util util = new Util();

    private static final double[] VISIT_DIST = new double[] {0.03, 0.05, 0.06, 0.08, 0.09, 0.11,
        0.095, 0.08, 0.07, 0.085, 0.12, 0.095, 0.035};  // Todo: Pass this as parameter.

    // (Andy): I moved the main class to PilotSim since it seemed more appropriate to run the
    // simulations here. I am currently defining the Day class as a concrete class, but I plan on
    // making it an abstract class with sub-classes later (if that still makes sense) to allow more
    // flexibilities dealing with holiday-dependent changes later. However, I think just having the
    // concept for now might help us visualize more options for the final product and help us
    // decide if one way might make more design sense than the other.
    public static void main(String[] args) {
        // List<Visit> visits = new ArrayList<>();
        List<Day> days = new ArrayList<>();  // List of days of the month.

        for(int i=1; i <= DAYS_IN_MONTH; i++) {
            Day newDay = new Day();
            for(int j=0; j < DAILY_VOLUME; j++) {
                LocalDateTime ldt = RandomGenerator.generateEntryData(i, VISIT_DIST);
                Weather weather = util.findWeather(ldt);

                //incorporate weather into datetime class
                DateTime dateTime = new DateTime(ldt, weather, util.isHoliday(ldt));
                Visit visit = new Visit();
                visit.setVisitID(String.valueOf((i-1)*DAILY_VOLUME + j));
                visit.setEntryTime(dateTime);

                // todo (all): Need methods to generate the duration and corresponding leave time.
                newDay.addVisit(visit);
            }
            days.add(newDay);
        }

        // sort Visit based on entryTime

        for (Day day : days) {
            Collections.sort(day.getVisits(), new Comparator<Visit>() {
                @Override
                public int compare(Visit v1, Visit v2) {
                    return v1.getEntryTime().getLocalDateTime().compareTo(v2.getEntryTime().getLocalDateTime());
                }
            });
        }

        // generate the csv file
        csvGenerator.writeToCSV(days);

        // simple test
        /*for(Visit v: visits) {
            System.out.println(v.getEntryTime().getLocalDateTime().toString());
            System.out.println(v.getEntryTime().getWeather().getAverageTemperature());
        }*/
    }
}
