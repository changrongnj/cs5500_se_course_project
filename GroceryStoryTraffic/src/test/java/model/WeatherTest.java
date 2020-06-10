package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WeatherTest {
  Weather test1;
  Weather test2;
  Weather test3;
  Weather test4;

  @Before
  public void setUp() {
    test1 = new Weather(true, 65.0);
    test2 = new Weather(true, 65.0);
    test3 = new Weather(false, 65.0);
    test4 = new Weather(true, 64.0);
  }

  @Test
  public void getWasNiceWeather() {
    assertTrue(test1.getWasNiceWeather());
  }

  @Test
  public void getAverageTemperature() {
    assertEquals(test1.getAverageTemperature(), Double.valueOf(65.0));
  }

  @Test
  public void testEquals() {
    assertEquals(test1, test1);
    assertEquals(test1, test2);
    assertNotEquals(test1, test3);
    assertNotEquals(test1, test4);
    assertNotEquals(test1, null);
    assertNotEquals(test1, 0.0);
  }

  @Test
  public void testHashCode() {
    assertEquals(test1.hashCode(), test2.hashCode());
  }

  @Test
  public void testToString() {
    String expected = "Weather{wasNiceWeather=true, averageTemperature=65.0}";
    assertEquals(test1.toString(), expected);
  }
}