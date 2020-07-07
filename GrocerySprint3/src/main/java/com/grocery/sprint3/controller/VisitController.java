package com.grocery.sprint3.controller;

import com.grocery.sprint3.model.Visit;
import com.grocery.sprint3.repository.VisitRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for handling certain queries for the visits collection.
 */
@RestController
@RequestMapping(path="/visits")  // localhost:8080/visits
public class VisitController {

  @Qualifier("visitRepository")
  @Autowired
  private VisitRepository visitRepo;

  /**
   * Postman GET command: localhost:8080/visits/all
   * Returns all visits in the collection without modifying the native ordering.
   * @return all visits in the collection without modifying the native ordering.
   */
  @GetMapping(path="/all/unordered")
  public List<Visit> getAllVisits() {
    return (List<Visit>) visitRepo.findAll();
  }

  /**
   * Postman GET command: localhost:8080/visits/all/ordered/entry
   * Returns all visits in order of entry time.
   * @return all visits in order of entry time.
   */
  @GetMapping(path="/all/ordered/entry")
  public List<Visit> findAllByEntryTimeOrder() {
    return visitRepo.findAllByOrderByEntryTime();
  }

  /**
   * Postman GET command: localhost:8080/visits/single/{visitID}
   * Returns a single visit matching the provided visitID
   * @param id - String representing the visit ID.
   * @return a single visit matching the provided visitID
   */
  @GetMapping(path="/single/{visitID}")
  public Visit getVisitByVisitID(@PathVariable("visitID") String id) {
    return visitRepo.findAllByVisitID(id);
  }

  /**
   * Postman GET command: localhost:8080/visits/partial/prefix/{idPrefix}|{start}|{end}
   * Returns a subset of visits that match the provided prefix within the provided interval.
   * @param prefix - String representing the prefix of interest (single letter)
   * @param start - String representing the starting date/time (yyyy-mm-ddThh:mm)
   * @param end - String representing the ending date/time (yyyy-mm-ddThh:mm)
   * @return a subset of visits that match the provided prefix within the provided interval.
   */
  @GetMapping(path="/partial/prefix/{idPrefix}|{start}|{end}")
  public List<Visit> getVisitByPrefix(@PathVariable("idPrefix") String prefix,
      @PathVariable("start") String start, @PathVariable("end") String end) {
    return visitRepo.findAllByVisitIDContainingAndEntryTimeIsBetweenOrderByEntryTime(prefix, start,
        end);
  }

  /**
   * Postman GET command: localhost:8080/visits/partial/entry/interval/{start}|{end}
   * Returns a subset of visits with entry times between the given interval.
   * @param start - String representing start of interval (yyyy-mm-ddThh:mm)
   * @param end - String representing end of interval (yyyy-mm-ddThh:mm)
   * @return a subset of visits with entry times between the given interval.
   */
  @GetMapping(path="partial/entry/interval/{start}|{end}")
  public List<Visit> findAllByEntryTimeIsBetween(@PathVariable("start") String start,
      @PathVariable("end") String end) {
    return visitRepo.findAllByEntryTimeIsBetweenOrderByEntryTime(start, end);
  }

  /**
   * Postman GET command: localhost:8080/visits/partial/leave/interval/{start}|{end}
   * Returns a subset of visits with leave times between the given interval.
   * @param start - String representing start of interval (yyyy-mm-ddThh:mm)
   * @param end - String representing end of interval (yyyy-mm-ddThh:mm)
   * @return a subset of visits with leave times between the given interval.
   */
  @GetMapping(path="partial/leave/interval/{start}|{end}")
  public List<Visit> findAllByLeaveTimeIsBetween(@PathVariable("start") String start,
      @PathVariable("end") String end) {
    return visitRepo.findAllByLeaveTimeIsBetweenOrderByLeaveTime(start, end);
  }

  /**
   * Postman GET command: localhost:8080/visits/partial/duration/interval/{min}|{max}
   * Returns a subset of visits with shopping durations in between the specified interval
   * @param min - Integer representing the minimum shopping duration
   * @param max - Integer representing the maximum shopping duration
   * @return a subset of visits with shopping durations in between the specified interval
   */
  @GetMapping(path="partial/duration/interval/{min}|{max}")
  public List<Visit> findAllByDurationIsBetween(@PathVariable("min") Integer min,
      @PathVariable("max") Integer max){
    return visitRepo.findAllByDurationBetweenOrderByEntryTime(min, max);
  }

  /**
   * Postman GET command: localhost:8080/visits/partial/duration/LTE/{max}
   * Returns a subset of visits with shopping durations less than or equal the target time.
   * @param max - Integer representing the maximum shopping duration
   * @return a subset of visits with shopping durations less than or equal the target time.
   */
  @GetMapping(path="partial/duration/LTE/{max}")
  public List<Visit> findAllByDurationLessThanEqual(@PathVariable("max") Integer max) {
    return visitRepo.findAllByDurationLessThanEqualOrderByEntryTime(max);
  }

  /**
   * Postman GET command: localhost:8080/visits/partial/duration/GTE/{min}
   * Returns a subset of visits with shopping durations greater than or equal the target time.
   * @param min - Integer representing the minimum shopping duration
   * @return a subset of visits with shopping durations greater than or equal the target time.
   */
  @GetMapping(path="partial/duration/GTE/{min}")
  public List<Visit> findAllByDurationGreaterThanEqual(@PathVariable("min") Integer min) {
    return visitRepo.findAllByDurationGreaterThanEqualOrderByEntryTime(min);
  }

  /**
   * Postman POST command: localhost:8080/visits/add/single    plus 6 parameters
   * Returns a String message to indicate successful addition to collection.
   * @param visitID - String representing the unique visit ID (prefix + digits)
   * @param entryTime - String representing the entry time (yyyy-mm-ddThh:mm)
   * @param leaveTime - String representing the leave time (yyyy-mm-ddThh:mm)
   * @param duration - Integer representing the shopping duration.
   * @param holiday - String representing the holiday type (CAPS_UNDERSCORE)
   * @param dayOfWeek - String representing day of the week (CAPS)
   * @return a String message indicating successful addition to collection.
   */
  @PostMapping(path="/add/single")
  public @ResponseBody String saveOrUpdateVisit(@RequestParam String visitID,
      @RequestParam String entryTime, @RequestParam String leaveTime,
      @RequestParam Integer duration, @RequestParam String holiday, @RequestParam String dayOfWeek) {
    visitRepo.save(new Visit(visitID, entryTime, leaveTime, duration, holiday, dayOfWeek));
    return "Visit added successfully";
  }
}
