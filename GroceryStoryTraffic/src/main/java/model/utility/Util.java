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

/**
 * Creates an instance of the Util class that contains automatically loads weather data upon
 * instantiation. Contains a method to find weather information on a particular date/time, and
 * another method that checks if the weather type is considered "nice" by an arbitrary standard.
 */
public class Util {
    private HashMap<String, String> weatherMap;

    /**
     * Constructs an instance of the Util class without accepting any parameters.
     * Automatically loads weather information from an external database.
     */
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
        }
    }

    /**
     * Given a LocalDateTime instance, returns a Weather instance representing the weather
     * information at that date and time.
     * @param ldt - LocalDateTime instance representing the date and time of interest.
     * @return a Weather instance representing the weather information at that date and time.
     */
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

    /**
     * Given a String representing the weather type, returns true if the weather is considered
     * "nice" and false otherwise.
     * @param weatherType - String representing the type of weather.
     * @return true if the weather is considered "nice" and false otherwise.
     */
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
