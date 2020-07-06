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

@RestController
@RequestMapping(path="/visits")
public class VisitController {

  @Qualifier("visitRepository")
  @Autowired
  private VisitRepository visitRepo;

  @GetMapping(path="/all")
  public List<Visit> getAllVisits() {
    return visitRepo.findAll();
  }

  @GetMapping(path="/{visitID}")
  public Visit getVisitByVisitID(@PathVariable("visitID") String id) {
    return visitRepo.findAllByVisitID(id);
  }

  @GetMapping(path="/orderByEntryTime")
  public List<Visit> findAllByEntryTimeOrder() {
    return visitRepo.findAllByOrderByEntryTime();
  }

  @PostMapping(path="/add")
  public @ResponseBody String saveOrUpdateVisit(@RequestParam String visitID,
      @RequestParam String entryTime, @RequestParam String leaveTime, @RequestParam int duration) {
    visitRepo.save(new Visit(visitID, entryTime, leaveTime, duration));
    return "Visit added successfully";
  }
}
