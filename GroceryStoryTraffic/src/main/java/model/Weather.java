package model;

/**
 * Constructs an instance of the Weather class with the following fields:
 * Boolean representing whether or not the overall weather was nice, and Double
 * representing the average temperature during store operation hours.
 */
public class Weather {
  private Boolean wasNiceWeather;
  private Double averageTemperature;

  /**
   * Constructs a new instance of the Weather class with the following parameters:
   * @param wasNiceWeather - Boolean representing whether or not the weather was nice overall.
   * @param averageTemperature - Double representing the average temperature during store hours.
   */
  public Weather(Boolean wasNiceWeather, Double averageTemperature) {
    this.wasNiceWeather = wasNiceWeather;
    this.averageTemperature = averageTemperature;
  }

  /**
   * Returns a Boolean indicating whether or not the weather was nice overall.
   * @return a Boolean indicating whether or not the weather was nice overall.
   */
  public Boolean getWasNiceWeather() {
    return this.wasNiceWeather;
  }

  /**
   * Returns a Double representing the average temperature during store hours.
   * @return a Double representing the average temperature during store hours.
   */
  public Double getAverageTemperature() {
    return this.averageTemperature;
  }

  // May need to add toString, equals(), hashCode() later.
}
