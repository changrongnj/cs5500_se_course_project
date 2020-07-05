package com.grocery.sprint3.service;

import com.grocery.sprint3.model.DateTime;
import com.grocery.sprint3.model.Visit;
import com.grocery.sprint3.repository.VisitRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class VisitAnalyzerServiceImpl implements VisitAnalyzerService {

  @Autowired
  private VisitRepository visitRepository;

  @Override
  public Visit findAllByVisitID(String id) {
    return visitRepository.findAllByVisitID(id);
  }

  @Override
  public List<Visit> findAllByEntryTimeIsBetween(DateTime start, DateTime end) {
    return visitRepository.findAllByEntryTimeIsBetween(start, end);
  }

  @Override
  public List<Visit> findAll() {
    return visitRepository.findAll();
  }

  @Override
  public List<Visit> findAllByLeaveTimeIsBetween(DateTime start, DateTime end) {
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
  }
}
