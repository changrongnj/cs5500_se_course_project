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

  // Find all visits that contain an ID prefix
  List<Visit> findAllByVisitIDContainingAndEntryTimeIsBetweenOrderByEntryTime(String prefix,
      String start, String end);

  // Find all visits with entry times in between the specified interval.
  List<Visit> findAllByEntryTimeIsBetweenOrderByEntryTime(String start, String end);

  // Finds all visits with leave times in between the specified interval
  List<Visit> findAllByLeaveTimeIsBetweenOrderByLeaveTime(String start, String end);

  // finds all visits with shopping durations within the constraints.
  List<Visit> findAllByDurationBetweenOrderByEntryTime(Integer min, Integer max);

  // Finds all visits with shopping durations of at least min minutes.
  List<Visit> findAllByDurationGreaterThanEqualOrderByEntryTime(Integer min);

  // Finds all visits with shopping durations of at most max minutes.
  List<Visit> findAllByDurationLessThanEqualOrderByEntryTime(Integer max);

  // Finds all visits by order of entry time.
  List<Visit> findAllByOrderByEntryTime();
}
