package com.grocery.sprint3.model;

import org.bson.types.ObjectId;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Creates an instance of the Visit class which contains a single method to generate additional
 * visit information. Contains two overloaded constructors that either take no parameters, or take
 * all four parameters corresponding to its internal attributes.
 */
@Document(collection = "Visits")
public class Visit {
  @Id
  private ObjectId id = new ObjectId();
  private String visitID;
  private String entryTime;
  private String leaveTime;
  private Integer duration;
  private String holiday;
  private String dayOfWeek;

  /**
   * Overloaded constructor that takes the following three parameters to create a visit without id.
   * @param entryTime - DateTime instance representing the entry information.
   * @param leaveTime - DateTime instance representing the leave information.
   * @param duration - Integer representing the duration of visit.
   */
  public Visit(String entryTime, String leaveTime, Integer duration, String holiday,
      String dayOfWeek) {
    this.entryTime = entryTime;
    this.leaveTime = leaveTime;
    this.duration = duration;
    this.holiday = holiday;
    this.dayOfWeek = dayOfWeek;
  }

  /**
   * Overloaded constructor that takes the following four parameters to create a complete visit.
   * @param visitID - String representing the unique visit.
   * @param entryTime - DateTime instance representing the entry information.
   * @param leaveTime - DateTime instance representing the leave information.
   * @param duration - Integer representing the duration of visit.
   */
  public Visit(String visitID, String entryTime, String leaveTime, Integer duration, String holiday,
      String dayOfWeek) {
    this.visitID = visitID;
    this.entryTime = entryTime;
    this.leaveTime = leaveTime;
    this.duration = duration;
    this.holiday = holiday;
    this.dayOfWeek = dayOfWeek;
  }

  /**
   * Overloaded constructor that does not accept any parameters and relies on setters to update
   * internal attributes.
   */
  public Visit() {}

  /**
   * Returns an ObjectId representing the actual object ID
   * @return an ObjectId representing the actual object ID
   */
  public ObjectId getId() {
    return id;
  }

  /**
   * Given an ObjectId instance, sets the internal attribute to new value.
   * @param id - new ObjectId instance.
   */
  public void setId(ObjectId id) {
    this.id = id;
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
  public String getEntryTime() {
    return this.entryTime;
  }

  /**
   * Sets the new entry time to the given parameter
   * @param entryTime - DateTime instance representing new entry time information.
   */
  public void setEntryTime(String entryTime) {
    this.entryTime = entryTime;
  }

  /**
   * Returns a DateTime instance representing the leave information.
   * @return a DateTime instance representing the leave information.
   */
  public String getLeaveTime() {
    return this.leaveTime;
  }


  /**
   * Sets the new LeaveTime to the given parameter
   * @param leaveTime - DateTime instance representing leave time information.
   */
  public void setLeaveTime(String leaveTime) {
    this.leaveTime = leaveTime;
  }

  /**
   * Returns an Integer representation the visit duration.
   * @return an Integer representation the visit duration.
   */
  public Integer getDuration() {
    return this.duration;
  }

  /**
   * Sets the duration attribute to given parameter
   * @param duration - Integer representing new duration.
   */
  public void setDuration(Integer duration) {
    this.duration = duration;
  }

  /**
   * Returns a String representing the holiday information.
   * @return a String representing the holiday information.
   */
  public String getHoliday() {
    return holiday;
  }

  /**
   * Given a String, sets the holiday information attribute to new value.
   * @param holiday - String representing new holiday information.
   */
  public void setHoliday(String holiday) {
    this.holiday = holiday;
  }

  /**
   * Returns a String representing the day of week.
   * @return a String representing the day of week.
   */
  public String getDayOfWeek() {
    return dayOfWeek;
  }

  /**
   * Given a String, sets the dayOfWeek attribute to the new value.
   * @param dayOfWeek - String representing the new day of week.
   */
  public void setDayOfWeek(String dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }
}
