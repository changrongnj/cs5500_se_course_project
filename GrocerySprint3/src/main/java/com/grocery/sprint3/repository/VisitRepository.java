package com.grocery.sprint3.repository;

import com.grocery.sprint3.model.Visit;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component("visitRepository")
public interface VisitRepository extends CrudRepository<Visit, String> {

  // Find a specific visit by its ID
  Visit findAllByVisitID(String id);

  // Find all visits in one day by an ID prefix.
  List<Visit> findAllByEntryTimeIsBetween(String start, String end);

  // Finds all visits in the specified hour (military time)
  List<Visit> findAllByLeaveTimeIsBetween(String start, String end);

  // Finds all visits by order of entry time.
  List<Visit> findAllByOrderByEntryTime();
}
