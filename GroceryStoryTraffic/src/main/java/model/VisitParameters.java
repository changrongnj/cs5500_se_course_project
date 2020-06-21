package model;

public class VisitParameters {
  public double[] entryDist;
  public double[] durationDist;
  public int additionalVolume;

  /**
   * Generate additional customers for dayBeforeHoliday and weekBeforeHoliday
   * @param holiday: holiday type
   * @param currentVolume: daily normal volume without applying any events.
   * @return three values:
   * holidayEntryTimeDist: total additional volume,
   * holidayDurationDist: entry time distribution (same as weekend)
   * holidayVolume: additional volume due to dayBeforeHoliday or weekBeforeHoliday
   * Todo: Need to tidy up javadoc after we have confirmed this class's functionality.
   */
  public VisitParameters(int volume, double[] entry, double[] duration) {
    this.additionalVolume = volume;
    this.entryDist = entry;
    this.durationDist = duration;
  }

  public double[] getEntryDist() {
    return this.entryDist;
  }

  public double[] getDurationDist() {
    return this.durationDist;
  }

  public int getAdditionalVolume() {
    return this.additionalVolume;
  }
}