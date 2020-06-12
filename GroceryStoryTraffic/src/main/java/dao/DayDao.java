
package dao;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import model.Day;
import model.Visit;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public final class DayDao {

    private static MongoClient mongoClient;

    static {
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private DayDao() throws UnknownHostException {
    }

    public static void cleanAllVisits() {
        mongoClient.getDB("CS5500").getCollection("visits").drop();
        System.out.println("success!");
    }

    public static void addAllVisits(List<Day> days) {
        List<DBObject> mongoObjs = new ArrayList<>();
        for(Day d:days) {
            for(Visit v:d.getVisits()) {
                DBObject visitObj = new BasicDBObject()
                        .append("VisitID", v.getVisitID())
                        .append("EntryTime",v.getEntryTime().getLocalDateTime().toString())
                        .append("LeaveTime", v.getLeaveTime().getLocalDateTime().toString())
                        .append("Duration", v.getDuration())
                        .append("Holiday", v.getEntryTime().getHolidayType().toString())
                        .append("DayofWeek", v.getEntryTime().getLocalDateTime().getDayOfWeek().toString());
                mongoObjs.add(visitObj);
            }
        }
        mongoClient.getDB("CS5500").getCollection("visits").insert(mongoObjs);
        System.out.printf("insert %d visits successfully", mongoObjs.size());
    }

    public static void closeClient() {
        mongoClient.close();
    }
}
