package controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import model.*;
import model.data.Constant;
import model.utility.*;
import view.CsvGenerator;


public class PilotSim {
    // PilotSim can be our controller class that contains Model and View instances
    // This class will be in charge of putting everything together for a month of data.
    static final int MONTH = 5;  // Todo: Figure out how to incorporate the month parameter.
    static final int DAYS_IN_MONTH = 31;
    private static CsvGenerator csvGenerator = new CsvGenerator();
    private static Util util = new Util();

    // (Andy): I moved the main class to PilotSim since it seemed more appropriate to run the
    // simulations here. I am currently defining the Day class as a concrete class, but I plan on
    // making it an abstract class with sub-classes later (if that still makes sense) to allow more
    // flexibilities dealing with holiday-dependent changes later. However, I think just having the
    // concept for now might help us visualize more options for the final product and help us
    // decide if one way might make more design sense than the other.
    public static void main(String[] args) {
        // List<Visit> visits = new ArrayList<>();
        List<Day> days = new ArrayList<>();  // List of days of the month.
        Constant constant = new Constant();
        int DAILY_VOLUME = 2000;

        for(int i=1; i <= DAYS_IN_MONTH; i++) {

            Day newDay = new Day();
            // initialize a LocalDate instance here for determination
            LocalDate ld = LocalDate.of(2016, 5, i);

            DAILY_VOLUME = DistributionDeterminer.getDailyVolume(ld, constant, util);

            for(int j=0; j < DAILY_VOLUME; j++) {

                // now use DistributionDeterminer for getting a random entry time.
                LocalDateTime ldt = DistributionDeterminer.getEntryTime(i, ld, constant, util);

                // now use DistributionDeterminer for retrieving a distribution.
                double[] durationDist = DistributionDeterminer.getDurationDistribution(ldt, constant, util);

                Weather weather = util.findWeather(ldt);

                //incorporate weather into datetime class
                DateTime dateTime = new DateTime(ldt, weather, HolidayDeterminer.getHolidayInfo(ldt.toLocalDate()));
                Visit visit = new Visit();
                visit.setVisitID(String.valueOf((i-1)*DAILY_VOLUME + j));
                visit.setEntryTime(dateTime);

                // generate the corresponding duration time(Minutes).
                int totalMinutes = RandomGenerator.generateDuration(durationDist);
                visit.setTotalTime(totalMinutes);

                // generate the corresponding leave time.
                LocalDateTime leaveTime = ldt.plusMinutes(totalMinutes);
                DateTime leaveDateTime = new DateTime(leaveTime, util.findWeather(leaveTime),
                    HolidayDeterminer.getHolidayInfo(ldt.toLocalDate()));
                visit.setLeaveTime(leaveDateTime);

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
