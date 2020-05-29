package model;

import java.time.LocalDate;

public class Visit {
  private String visitID;

  // I just remembered that LocalDate does not include time data
  // Will need to think about how to represent the exact time data.
  // Using String as a placeholder for now.
  // Updated (James): switch to self-defined DateTime class.
  private DateTime entryTime;
  private DateTime leaveTime;

  // Will calculate this based on leave time - entry time.
  private Integer totalTime;

  public Visit() {
    // Will update once we figure out how to represent time.
  }

  public String getVisitID() {
    return visitID;
  }

  public void setVisitID(String visitID) {
    this.visitID = visitID;
  }

  public DateTime getEntryTime() {
    return entryTime;
  }

  public void setEntryTime(DateTime entryTime) {
    this.entryTime = entryTime;
  }

  public DateTime getLeaveTime() {
    return leaveTime;
  }

  public void setLeaveTime(DateTime leaveTime) {
    this.leaveTime = leaveTime;
  }

  public Integer getTotalTime() {
    return totalTime;
  }

  public void setTotalTime(Integer totalTime) {
    this.totalTime = totalTime;
  }
}
