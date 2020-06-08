package view;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

import model.DateTime;
import controller.PilotSim;
import model.Day;
import model.utility.RandomGenerator;
import model.utility.Util;
import model.Visit;
import model.Weather;

public class CsvGenerator {

//    static final int MONTH = 5;;
//    static final int DAILY_VOLUME = 2000;

//    load useful instances here
//    private static PilotSim pilotSim = new PilotSim();
//    private static Util util = new Util();
//    private static final double[] VISIT_DIST = new double[] {0.03, 0.05, 0.06, 0.08, 0.09, 0.11,
//        0.095, 0.08, 0.07, 0.085, 0.12, 0.095, 0.035};

//    public static void main(String[] args) {
//
//        List<Visit> visits = new ArrayList<>();
//
//        for(int i=1; i <= 31; i++) {
//            // int dailyNum = 2000;
//            for(int j=0; j < DAILY_VOLUME; j++) {
//                LocalDateTime ldt = RandomGenerator.generateEntryData(i, VISIT_DIST);
//                Weather weather = util.findWeather(ldt);
//
//                //incorporate weather into datetime class
//                DateTime dateTime = new DateTime(ldt, weather, util.isHoliday(ldt));
//                Visit visit = new Visit();
//                visit.setVisitID(String.valueOf((i-1)*DAILY_VOLUME + j));
//                visit.setEntryTime(dateTime);
//
//                // todo (all): Need methods to generate the duration and corresponding leave time.
//                visits.add(visit);
//            }
//        }
//
//        // sort Visit based on entryTime
//        Collections.sort(visits, new Comparator<Visit>() {
//            @Override
//            public int compare(Visit v1, Visit v2) {
//                return v1.getEntryTime().getLocalDateTime().compareTo(v2.getEntryTime().getLocalDateTime());
//            }
//        });
//
//        // generate the csv file
//        writeToCSV(visits);
//
//        // simple test
//        for(Visit v: visits) {
//            System.out.println(v.getEntryTime().getLocalDateTime().toString());
//            System.out.println(v.getEntryTime().getWeather().getAverageTemperature());
//        }
//    }

    // (Andy) Moved from Util class to this class to increase cohesiveness and decrease coupling.
    // Created as a static class for now, but should be non-static once we set up the controller
    // class PilotSim to create instances of the necessary objects and call the methods.
    public void writeToCSV(List<Day> dayList) {

        // borrow some code from https://stackoverflow.com/questions/3666007/how-to-serialize-object-to-csv-file

        String CSV_SEPARATOR = ",";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("products.csv"), "UTF-8"));
            StringBuilder oneLine = new StringBuilder();
            oneLine.append("VisitID");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("EntryTime");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("LeaveTime");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Duration(minute)");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("IsNiceWeather");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("Temperature");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("HolidayType");
            oneLine.append(CSV_SEPARATOR);
            oneLine.append("DayOfWeek");
            bw.write(oneLine.toString());
            bw.newLine();
            for (Day day : dayList) {
                for (Visit visit : day.getVisits())
                {
                    oneLine = new StringBuilder();
                    oneLine.append(visit.getVisitID());
                    oneLine.append(CSV_SEPARATOR);
                    // here replace the year with 2020
                    oneLine.append(visit.getEntryTime().getLocalDateTime().format(formatter));
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(visit.getLeaveTime().getLocalDateTime().format(formatter));
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(visit.getTotalTime());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(visit.getEntryTime().getWeather().getWasNiceWeather());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(visit.getEntryTime().getWeather().getAverageTemperature());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(visit.getEntryTime().isHoliday());
                    oneLine.append(CSV_SEPARATOR);
                    oneLine.append(visit.getEntryTime().getLocalDateTime().getDayOfWeek());
                    bw.write(oneLine.toString());
                    bw.newLine();
                }
            }
            bw.flush();
            bw.close();
        } catch (IOException e){
            System.out.println("I/O exception");
        }
    }
}
