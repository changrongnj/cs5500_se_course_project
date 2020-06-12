package model;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.util.Objects;

/**
 * Creates an instance of the Visit class which contains a single method to generate additional
 * visit information. Contains two overloaded constructors that either take no parameters, or take
 * all four parameters corresponding to its internal attributes.
 */
public class Visit {
  private String visitID;
  private DateTime entryTime;
  private DateTime leaveTime;
  private int duration;

  /**
   * Overloaded constructor that does not take any parameters upon creation of an instance.
   * Requires manual setting of all four internal attributes.
   */
  public Visit() {
  }

  /**
   * Overloaded constructor that takes the following four parameters to create a complete visit.
   * @param visitID - String representing the unique visit.
   * @param entryTime - DateTime instance representing the entry information.
   * @param leaveTime - DateTime instance representing the leave information.
   * @param duration - int representing the duration of visit.
   */
  public Visit(String visitID, DateTime entryTime, DateTime leaveTime, int duration) {
    this.visitID = visitID;
    this.entryTime = entryTime;
    this.leaveTime = leaveTime;
    this.duration = duration;
  }

  /**
   * Returns a String representing the unique visit.
   * @return a String representing the unique visit.
   */
  public String getVisitID() {
    return visitID;
  }

  /**
   * Given a String visitID, sets the internal attribute to this value.
   * @param visitID - String representing the new visitID.
   */
  public void setVisitID(String visitID) {
    this.visitID = visitID;
  }

  /**
   * Returns a DateTime instance representing the entry time information.
   * @return a DateTime instance representing the entry time information.
   */
  public DateTime getEntryTime() {
    return this.entryTime;
  }

  /**
   * Given a DateTime instance, sets the internal attribute to this instance.
   * @param entryTime - DateTime instance representing the new entry time information.
   */
  public void setEntryTime(DateTime entryTime) {
    this.entryTime = entryTime;
  }

  /**
   * Returns a DateTime instance representing the leave information.
   * @return a DateTime instance representing the leave information.
   */
  public DateTime getLeaveTime() {
    return this.leaveTime;
  }

  /**
   * Given a DateTime instance, set the internal attribute to this new instance.
   * @param leaveTime - DateTime instance representing the new leave information.
   */
  public void setLeaveTime(DateTime leaveTime) {
    this.leaveTime = leaveTime;
  }

  /**
   * Returns an Integer representation the visit duration.
   * @return an Integer representation the visit duration.
   */
  public int getDuration() {
    return this.duration;
  }

  /**
   * Given an int, set the internal attribute to this new value.
   * @param duration - int representing the new duration value.
   */
  public void setDuration(int duration) {
    this.duration = duration;
  }

  /**
   * Given the current day of wek and the expected senior discount day per week, returns a String
   * representing additional descriptions for a visit.
   * @param thisDay - DayOfWeek representing the current day.
   * @param seniorDay - DayOfWeek representing the senior discount day.
   * @return a String representing additional descriptions for a visit.
   */
  public String getAdditionalDescriptors(DayOfWeek thisDay, DayOfWeek seniorDay) {
    if (thisDay == DayOfWeek.SATURDAY || thisDay == DayOfWeek.SUNDAY) {
      if (this.entryTime.getWeather().getWasNiceWeather()) {
        return "NICE_WEEKEND";
      } else {
        return "REGULAR_WEEKEND";
      }
    } else if (thisDay == seniorDay) {
      return "SENIOR_DISCOUNT_WEEKDAY";
    } else {
      return "REGULAR_WEEKDAY";
    }
  }

  /**
   * Returns true if this object has the same field values as the other object.
   * @param o - The other object being compared to this object.
   * @return true if this object has the same field values as the other object.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || (this.getClass() != o.getClass())) {
      return false;
    }
    Visit visit = (Visit) o;
    return Objects.equals(this.visitID, visit.visitID) &&
        Objects.equals(this.entryTime, visit.entryTime) &&
        Objects.equals(this.leaveTime, visit.leaveTime) &&
        Objects.equals(this.duration, visit.duration);
  }

  /**
   * Returns a hashCode representation of this instance.
   * @return a hashCode representation of this instance.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.visitID, this.entryTime, this.leaveTime, this.duration);
  }

  /**
   * Returns a String representation of this instance.
   * @return a String representation of this instance.
   */
  @Override
  public String toString() {
    return "Visit{" +
        "visitID='" + this.visitID + '\'' +
        ", entryTime=" + this.entryTime +
        ", leaveTime=" + this.leaveTime +
        ", duration=" + this.duration +
        '}';
  }
}
