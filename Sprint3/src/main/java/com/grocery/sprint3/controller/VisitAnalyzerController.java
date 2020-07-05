package com.grocery.sprint3.controller;

import com.grocery.sprint3.model.Visit;
import com.grocery.sprint3.service.VisitAnalyzerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visits")
public class VisitAnalyzerController {
  @Autowired
  private VisitAnalyzerService visitAnalyzerService;

  @GetMapping(value = "/")
  public List<Visit> getAllVisits() {
    return visitAnalyzerService.findAll();
  }

  @GetMapping(value = "/{VisitID}")
  public Visit getVisitByVisitID(@PathVariable("VisitID") String id) {
    return visitAnalyzerService.findAllByVisitID(id);
  }

  @GetMapping(value = "/orderByEntryTime")
  public List<Visit> findAllByEntryTimeOrder() {
    return visitAnalyzerService.findAllByOrderByEntryTime();
  }
}
