package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Todo: Skeletal representation of a Day. Consider extending with sub-classes, but to be discussed.
 */
public class Day {
  private List<Visit> visits;

  public Day() {
    this.visits = new ArrayList<>();
  }

  public void addVisit(Visit visit) {
    this.visits.add(visit);
  }

  public List<Visit> getVisits() {
    return this.visits;
  }
}
