package com.grocery.sprint3.service;

import com.grocery.sprint3.model.DateTime;
import com.grocery.sprint3.model.Visit;
import java.util.List;

public interface VisitAnalyzerService {

  // Find a specific visit by its ID
  Visit findAllByVisitID(String id);

  // Find all visits in one day by an ID prefix.
  List<Visit> findAllByEntryTimeIsBetween(DateTime start, DateTime end);

  // Finds all visits in one day.
  List<Visit> findAll();

  // Finds all visits in the specified hour (military time)
  List<Visit> findAllByLeaveTimeIsBetween(DateTime start, DateTime end);

  // Finds all visits by order of entry time.
  List<Visit> findAllByOrderByEntryTime();

  void saveOrUpdateVisit(Visit visit);

  void deleteVisit(Visit visit);
}
