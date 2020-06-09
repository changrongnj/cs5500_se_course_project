package model;

import java.util.Objects;

/**
 * Constructs an instance of the Weather class with the following fields:
 * Boolean representing whether or not the overall weather was nice, and
 * Double representing the average temperature during store operation hours.
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
    Weather weather = (Weather) o;
    return Objects.equals(this.getWasNiceWeather(), weather.getWasNiceWeather()) &&
        Objects.equals(this.getAverageTemperature(), weather.getAverageTemperature());
  }

  /**
   * Returns a hashCode representation of this instance.
   * @return a hashCode representation of this instance.
   */
  @Override
  public int hashCode() {
    return Objects.hash(this.getWasNiceWeather(), this.getAverageTemperature());
  }

  /**
   * Returns a String representation of this instance.
   * @return a String representation of this instance.
   */
  @Override
  public String toString() {
    return "Weather{" +
        "wasNiceWeather=" + this.wasNiceWeather +
        ", averageTemperature=" + this.averageTemperature +
        '}';
  }
}
