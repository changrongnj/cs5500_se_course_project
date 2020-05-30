package model;

public class Visit {
  private String visitID;

  // Updated (James): switch to self-defined DateTime class.
  private DateTime entryTime;

  // Will calculate the leave time based on the totalTime.
  private DateTime leaveTime;

  // Will need to randomly generate this somehow.
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
    return this.entryTime;
  }

  public void setEntryTime(DateTime entryTime) {
    this.entryTime = entryTime;
  }

  public DateTime getLeaveTime() {
    return this.leaveTime;
  }

  public void setLeaveTime(DateTime leaveTime) {
    this.leaveTime = leaveTime;
  }

  public Integer getTotalTime() {
    return this.totalTime;
  }

  public void setTotalTime(Integer totalTime) {
    this.totalTime = totalTime;
  }
}
