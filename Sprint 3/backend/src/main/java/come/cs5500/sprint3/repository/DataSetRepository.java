package come.cs5500.sprint3.repository;

import come.cs5500.sprint3.model.DataSet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.time.Month;

public interface DataSetRepository extends MongoRepository<DataSet, Month> {
    public DataSet findByMonth(Month month);
}
