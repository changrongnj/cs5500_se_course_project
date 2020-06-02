package model.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Visit;
import model.Weather;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class Util {

    /**
     * a class containing useful functions for instance initialization
     * */

    private HashMap<String, String> weatherMap;

    public Util() {

        // load weather data from json file

        JSONObject jsonObject = new JSONObject();
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("/Users/yfyan/Desktop/NEU/Summer_2020/cs5500/cs5500_sum2020_group8/GroceryStoryTraffic/src/main/java/weatherData.json"));
            jsonObject =  (JSONObject) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        try {
            this.weatherMap = new ObjectMapper().readValue(jsonObject.toJSONString(), HashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        };
    }

    // self-defined function to find each hour's weather
    public Weather findWeather(LocalDateTime ldt) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String key = ldt.format(formatter).substring(0, 13) + ":00:00";
        System.out.println(key);
//        for(String k:weatherMap.keySet())
//            System.out.println(k);
        String[] ans = weatherMap.get(key).split("-");
        String weatherType = ans[0];
        String temperature = ans[1];
        Boolean isNiceWeather = isNiceWeather(weatherType);
        return new Weather(isNiceWeather, Double.valueOf(temperature));
    }

    public boolean isNiceWeather(String weatherType) {
        switch (weatherType) {
            case "clear":
            case "clouds":
                return true;
            case "drizzle":
            case "haze":
            case "mist":
            case "rain":
            case "smoke":
                return false;
        }
        return true;
    }

    // self-defined function to calculate DayOfWeekInMonth
    public int calDayOfWeekInMonth(LocalDateTime ldt) {
        LocalDate monthStart = LocalDate.of(ldt.getYear(), ldt.getMonth(), 1);
        DayOfWeek dayOfWeek = monthStart.getDayOfWeek();
        int newStart = 8 - dayOfWeek.getValue();
        return (ldt.getDayOfMonth() - newStart + 7 - 1) / 7 + 1;
    }

    // determine if the day is a holiday
    // there could be some controversy about holidays but we can discuss later
    public boolean isHoliday(LocalDateTime ldt) {

        // I borrow some code from https://gist.github.com/timperez/9555657

        // check if New Year's Day
        if (ldt.getMonth() == Month.JANUARY && ldt.getDayOfMonth() == 1) {
            return true;
        }

        // check if Christmas
        if (ldt.getMonth() == Month.DECEMBER && ldt.getDayOfMonth() == 25) {
            return true;
        }

        // check if 4th of July
        if (ldt.getMonth() == Month.JULY && ldt.getDayOfMonth() == 4) {
            return true;
        }

        // check Thanksgiving (4th Thursday of November)
        if (ldt.getMonth() == Month.NOVEMBER
                && ldt.getDayOfWeek() == DayOfWeek.THURSDAY
                && calDayOfWeekInMonth(ldt) == 4) {
            return true;
        }

        // check Memorial Day (last Monday of May)
        if (ldt.getMonth() == Month.MAY
                && ldt.getDayOfWeek() == DayOfWeek.MONDAY
                && ldt.getDayOfMonth() > (31 - 7) ) {
            return true;
        }

        // check Labor Day (1st Monday of September)
        if (ldt.getMonth() == Month.SEPTEMBER
                && calDayOfWeekInMonth(ldt) == 1
                && ldt.getDayOfWeek() == DayOfWeek.MONDAY) {
            return true;
        }

        // check President's Day (3rd Monday of February)
        if (ldt.getMonth() == Month.FEBRUARY
                && calDayOfWeekInMonth(ldt) == 3
                && ldt.getDayOfWeek() == DayOfWeek.MONDAY) {
            return true;
        }

        // check Veterans Day (November 11)
        if (ldt.getMonth() == Month.NOVEMBER
                && ldt.getDayOfMonth() == 11) {
            return true;
        }

        // check MLK Day (3rd Monday of January)
        if (ldt.getMonth() == Month.JANUARY
                && calDayOfWeekInMonth(ldt) == 3
                && ldt.getDayOfWeek() == DayOfWeek.MONDAY) {
            return true;
        }

        // IF NOTHING ELSE, IT'S A BUSINESS DAY
        return false;
    }
}
