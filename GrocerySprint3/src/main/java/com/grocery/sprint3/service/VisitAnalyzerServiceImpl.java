package com.grocery.sprint3.service;

import com.grocery.sprint3.model.Visit;
import com.grocery.sprint3.repository.VisitRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitAnalyzerServiceImpl implements VisitAnalyzerService {
/*
  @Autowired
  private VisitRepository visitRepository;

  @Override
  public Visit findAllByVisitID(String id) {
    System.out.println("Attempting to find visit with String id");
    return visitRepository.findAllByVisitID(id);
  }

  @Override
  public List<Visit> findAllByEntryTimeIsBetween(String start, String end) {
    return visitRepository.findAllByEntryTimeIsBetween(start, end);
  }

  @Override
  public List<Visit> findAll() {
    System.out.println("Attempting to find all visits");
    List<Visit> visits = visitRepository.findAll();
    for (Visit visit : visits) {
      System.out.println("Entry time of visit: " + visit.getEntryTime() + "\n");
    }
    return visitRepository.findAll();
  }

  @Override
  public List<Visit> findAllByLeaveTimeIsBetween(String start, String end) {
    return visitRepository.findAllByLeaveTimeIsBetween(start, end);
  }

  @Override
  public List<Visit> findAllByOrderByEntryTime() {
    return visitRepository.findAllByOrderByEntryTime();
  }

  @Override
  public void saveOrUpdateVisit(Visit visit) {
    visitRepository.save(visit);
  }

  @Override
  public void deleteVisit(Visit visit) {
    visitRepository.delete(visit);
  }*/
}
