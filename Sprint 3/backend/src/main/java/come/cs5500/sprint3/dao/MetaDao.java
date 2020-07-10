package come.cs5500.sprint3.dao;

import come.cs5500.sprint3.model.DataSet;
import come.cs5500.sprint3.repository.DataSetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Month;

@Component
public class MetaDao {

    @Autowired
    DataSetRepository dataSetRepository;

    public void createDataSet(DataSet dataSet) {
        dataSetRepository.save(dataSet);
    }

    public DataSet findDataSet(Month month) {
        return dataSetRepository.findByMonth(month);
    }

    public void truncateDatabase() {
        dataSetRepository.deleteAll();
    }

}
