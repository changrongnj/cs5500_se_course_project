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
    static final int MONTH = 5;
    static final int DAYS_IN_MONTH = 31;
    private static CsvGenerator csvGenerator = new CsvGenerator();
    private static Util util = new Util();

    public static void main(String[] args) {
        List<Day> days = new ArrayList<>();
        Constant constant = new Constant();
        int dailyVolume;

        for(int i = 1; i <= DAYS_IN_MONTH; i++) {

            Day newDay = new Day();
            // initialize a LocalDate instance here for determination
            LocalDate date = LocalDate.of(2020, MONTH, i);
            HolidayType holiday = HolidayDeterminer.getHolidayInfo(date);
            dailyVolume = DistributionDeterminer.getDailyVolume(date, constant);
            dailyVolume = DistributionDeterminer.applyHolidayVolume(holiday, dailyVolume);
            dailyVolume = DistributionDeterminer.applyNiceWeatherVolume(date, dailyVolume, util);

            for(int j=0; j < dailyVolume; j++) {

                // now use DistributionDeterminer for getting a random entry time.
                LocalDateTime ldt = DistributionDeterminer.getEntryTime(i, date, constant);

                // now use DistributionDeterminer for retrieving a distribution.
                double[] durationDist = DistributionDeterminer.getDurationDistribution(ldt, constant, util);

                Weather weather = util.findWeather(ldt);

                //incorporate weather into datetime class
                DateTime dateTime = new DateTime(ldt, weather, holiday);
                Visit visit = new Visit();
                visit.setVisitID(String.valueOf((i-1)*dailyVolume + j));
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

    }
}
