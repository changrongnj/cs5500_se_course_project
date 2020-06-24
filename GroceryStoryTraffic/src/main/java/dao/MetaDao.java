package dao;

import com.mongodb.MongoClient;
import model.DataSet;
import model.Visit;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.net.UnknownHostException;
import java.util.List;

public final class MetaDao {

    private static Datastore datastore;

    static {
        try {
            datastore = new Morphia().mapPackage("model").createDatastore(new MongoClient(), "CS5500");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    private MetaDao(){
    }

    public static void truncateData() {
        datastore.getCollection(Visit.class).drop();
        datastore.getCollection(DataSet.class).drop();
    }

    private static void addAllVisits(List<Visit> visits) {
        datastore.save(visits);
        System.out.printf("successfully insert %d visits\n", visits.size());
    }

    public static void addAllDataSets(List<DataSet> dataSets) {
        for(DataSet ds:dataSets) {
            addAllVisits(ds.getVisits());
        }
        datastore.save(dataSets);
        System.out.printf("successfully insert %d datasets\n", dataSets.size());
    }
}



