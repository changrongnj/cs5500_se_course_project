package controller;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import dao.DayDao;
import model.*;
import model.data.Constant;
import model.utility.SpecialEventsApplier;
import model.utility.*;
import view.CsvGenerator;
import model.Visit;

/**
 * Controller class that contains a main method that instantiates all of the required objects.
 * Does not require any command line arguments and generates a csv document displaying all of the
 * highlighted visit information per row.
 */
public class PilotSim {
    static final int MONTH = 5;
    static final int DAYS_IN_MONTH = 31;
    private static CsvGenerator csvGenerator = new CsvGenerator();
    private static Util util = new Util();

    /**
     * main method that does not require any command line arguments.
     * @param args - command line arguments; not required for this method.
     */
    public static void main(String[] args) {
        List<Day> days = new ArrayList<>();
        Constant constant = new Constant();
        int dailyVolume;

        for(int i = 1; i <= DAYS_IN_MONTH; i++) {

            Day newDay = new Day();
            // Initialize a new date in the target range and determine customer volume that day.
            LocalDate date = LocalDate.of(2020, MONTH, i);
            HolidayType holiday = HolidayDeterminer.getHolidayInfo(date);
            dailyVolume = DistributionDeterminer.getDailyVolume(date, constant);
            dailyVolume = SpecialEventsApplier.applyHolidayVolume(holiday, dailyVolume);
            dailyVolume = DistributionDeterminer.applyNiceWeatherVolume(date, dailyVolume, util);

            for(int j=0; j < dailyVolume; j++) {
                // Get entry information.
                LocalDateTime ldt = DistributionDeterminer.getEntryTime(i, date, constant);

                // Get visit duration distribution for the specified date/time.
                double[] durationDist = DistributionDeterminer.getDurationDistribution(
                    ldt, constant, util);

                // Get weather data.
                Weather weather = util.findWeather(ldt);

                // Get entry information including weather and holiday information.
                DateTime dateTime = new DateTime(ldt, weather, holiday);
                Visit visit = new Visit();
                visit.setVisitID(String.valueOf((i-1)*dailyVolume + j));
                visit.setEntryTime(dateTime);

                // get the visit duration in minutes.
                int totalMinutes = RandomGenerator.generateDuration(durationDist);
                visit.setDuration(totalMinutes);

                // Get visit leave information.
                LocalDateTime leaveTime = ldt.plusMinutes(totalMinutes);
                DateTime leaveDateTime = new DateTime(leaveTime, util.findWeather(leaveTime),
                    HolidayDeterminer.getHolidayInfo(ldt.toLocalDate()));
                visit.setLeaveTime(leaveDateTime);

                newDay.addVisit(visit);
            }
            days.add(newDay);
        }

        // Sorts all visits by entry date/time information.
        for (Day day : days) {
            day.getVisits().sort(new Comparator<Visit>() {
                @Override
                public int compare(Visit v1, Visit v2) {
                    return v1.getEntryTime().getLocalDateTime()
                        .compareTo(v2.getEntryTime().getLocalDateTime());
                }
            });
        }
        csvGenerator.writeToCSV(days);
        DayDao.cleanAllVisits();
        DayDao.addAllVisits(days);
        DayDao.closeClient();
    }
}
