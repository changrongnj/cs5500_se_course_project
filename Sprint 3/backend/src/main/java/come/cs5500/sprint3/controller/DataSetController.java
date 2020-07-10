package come.cs5500.sprint3.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import come.cs5500.sprint3.model.Visit;
import org.json.JSONArray;
import org.json.JSONObject;
import come.cs5500.sprint3.dao.MetaDao;
import come.cs5500.sprint3.model.DataSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DataSetController {

    @Autowired
    MetaDao metaDao;

    @RequestMapping(value="api/remove", method = RequestMethod.GET)
    public void truncateDatabase() {
        metaDao.truncateDatabase();
        System.out.println();
    }

    @RequestMapping(value="/api/find/{month}", method = RequestMethod.GET)
    public DataSet FindDataSet(@PathVariable("month") Month month) {
        return metaDao.findDataSet(month);
    }

    @RequestMapping(value="/api/add", method = RequestMethod.POST)
    public void AddDataSet(@RequestBody String data) throws JsonProcessingException {
        JSONObject json = new JSONObject(data);
        System.out.println(Month.valueOf(json.get("month").toString()));
        DataSet dataSet = new DataSet();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        dataSet.setGeneratedTime(LocalDateTime.parse(json.get("generated_time").toString(), dateTimeFormatter));
        dataSet.setMonth(Month.valueOf(json.get("month").toString()));
        JSONArray jsonArray = json.getJSONArray("visits");
        List<Visit> visits = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        for(int i=0; i < jsonArray.length(); i++) {
            JSONObject obj = (JSONObject) jsonArray.get(i);
            Visit visit = mapper.readValue(obj.toString(), Visit.class);
            visits.add(visit);
        }
        dataSet.setVisits(visits);
        metaDao.createDataSet(dataSet);
        System.out.printf("successfully insert %d visit-records for %s \n", visits.size(), dataSet.getGeneratedTime().toString());
    }
//    public void AddDataSet(@RequestBody String data) throws JsonProcessingException {
//        JSONObject json = new JSONObject(data);
//        DataSet dataSet = new DataSet();
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
//        dataSet.setGeneratedTime(LocalDateTime.parse(json.get("generated_time").toString(), dateTimeFormatter));
//        dataSet.setMonth(Month.valueOf(json.get("month").toString()));
//        JSONArray jsonArray = json.getJSONArray("visits");
//        List<Visit> visits = new ArrayList<>();
//        ObjectMapper mapper = new ObjectMapper();
//        for(int i=0; i < jsonArray.length(); i++) {
//            JSONObject obj = (JSONObject) jsonArray.get(i);
//            Visit visit = mapper.readValue(obj.toString(), Visit.class);
//            visits.add(visit);
//        }
//        dataSet.setVisits(visits);
//        metaDao.createDataSet(dataSet);
//        System.out.printf("successfully insert %d visit-records for %s", visits.size(), dataSet.getGeneratedTime().toString());
//    }
}
