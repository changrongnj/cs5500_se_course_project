package com.grocery.sprint3.controller;

import com.grocery.sprint3.model.Visit;
import com.grocery.sprint3.service.VisitAnalyzerService;
import com.grocery.sprint3.service.VisitAnalyzerServiceImpl;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visits")
public class VisitAnalyzerController {
  // @Autowired
  private VisitAnalyzerService visitAnalyzerService = new VisitAnalyzerServiceImpl();

  @GetMapping(value = "/")
  public List<Visit> getAllVisits() {
    return this.visitAnalyzerService.findAll();
  }

  @GetMapping(value = "/{VisitID}")
  public Visit getVisitByVisitID(@PathVariable("VisitID") String id) {
    return this.visitAnalyzerService.findAllByVisitID(id);
  }

  @GetMapping(value = "/orderByEntryTime")
  public List<Visit> findAllByEntryTimeOrder() {
    return this.visitAnalyzerService.findAllByOrderByEntryTime();
  }
}
