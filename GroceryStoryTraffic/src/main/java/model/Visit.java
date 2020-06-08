package model;

import java.time.DayOfWeek;

public class Visit {
  private String visitID;

  // Updated (James): switch to self-defined DateTime class.
  private DateTime entryTime;
  private DateTime leaveTime;
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

  public String getAdditionalDescriptors(DayOfWeek thisDay, DayOfWeek seniorDay) {

    if (thisDay == DayOfWeek.SATURDAY || thisDay == DayOfWeek.SUNDAY) {
      if (this.entryTime.getWeather().getWasNiceWeather()) {
        return "niceWeatherWeekend";
      } else {
        return "regularWeekend";
      }
    } else if (thisDay == seniorDay) {
      return "seniorDiscountWeekday";
    } else {
      return "regularWeekday";
    }
  }
}
