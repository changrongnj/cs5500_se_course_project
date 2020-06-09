package model.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import model.Weather;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

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
            String filePath = new File("").getAbsolutePath();
            Object obj = parser.parse(new FileReader(filePath + "/src/main/java/weatherData.json"));
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
        String[] ans = weatherMap.get(key).split("-");
        String weatherType = ans[0];
        String temperature = ans[1];
        Boolean isNiceWeather = isNiceWeather(weatherType);
        String[] tmp = temperature.split("\\.");
        temperature = tmp[0] + "." + tmp[1].substring(0, Math.min(2, tmp[1].length()));
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

}
