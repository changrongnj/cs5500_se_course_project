package com.grocery.sprint3.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@CacheConfig(cacheNames = "holidays")
public class HolidayService {

    @Autowired
    RestTemplate restTemplate;

    @Cacheable(key = "#ld")
    public String CheckHoliday(LocalDate ld) {
        int year = ld.getYear();
        int month = ld.getMonthValue();
        int day = ld.getDayOfMonth();
        String key = "36332bb3f96d2fcc2536c4b87a373f6f896ad86d";
        String url = String.format("https://calendarific.com/api/v2/holidays?&api_key=%s&country=US&year=%d&month=%d&day=%d&type=national", key, year, month, day);
        String response = restTemplate.getForObject(url, String.class);

        try {
            JSONArray holidays = new JSONObject(response).getJSONObject("response").getJSONArray("holidays");
            if(holidays.length() < 1)
                return "non-holiday";
            return holidays.getJSONObject(0).getString("name");
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return "non-holiday";
    }

}
