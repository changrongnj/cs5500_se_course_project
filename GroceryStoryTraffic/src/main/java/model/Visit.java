package model;

import java.time.LocalDate;

public class Visit {
  private String visitID;

  // I just remembered that LocalDate does not include time data
  // Will need to think about how to represent the exact time data.
  // Using String as a placeholder for now.
  // Todo (James): Please update the type here after we figure out how to represent time.
  private String entryTime;
  private String leaveTime;

  // Will calculate this based on leave time - entry time.
  private Integer totalTime;

  public Visit() {
    // Will update once we figure out how to represent time.
  }

}
