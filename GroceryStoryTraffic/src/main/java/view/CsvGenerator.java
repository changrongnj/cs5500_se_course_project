package view;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import model.DateTime;
import model.PilotSim;
import model.Util;
import model.Visit;
import model.Weather;

public class CsvGenerator {

    static final int MONTH = 5;;
    static final int DAILY_VOLUME = 2000;

    // load useful instances here
    private static PilotSim pilotSim = new PilotSim();
    private static Util util = new Util();

    public static void main(String[] args) {

        List<Visit> visits = new ArrayList<>();

        for(int i=1; i <= 31; i++) {
            // int dailyNum = 2000;
            for(int j=0; j < DAILY_VOLUME; j++) {
                LocalDateTime ldt = pilotSim.timeGenerator(i);
                Weather weather = util.findWeather(ldt);

                //incorporate weather into datetime class
                DateTime dateTime = new DateTime(ldt, weather, util.isHoliday(ldt));
                Visit visit = new Visit();
                visit.setVisitID(String.valueOf((i-1)*DAILY_VOLUME + j));
                visit.setEntryTime(dateTime);

                // todo (all): Need methods to generate the duration and corresponding leave time.
                visits.add(visit);
            }
        }

        // generate the csv file
        util.writeToCSV(visits);

        // simple test
        for(Visit v: visits) {
            System.out.println(v.getEntryTime().getLocalDateTime().toString());
            System.out.println(v.getEntryTime().getWeather().getAverageTemperature());
        }

    }
}
