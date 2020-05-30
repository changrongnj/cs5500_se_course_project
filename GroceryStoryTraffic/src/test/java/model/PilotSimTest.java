package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PilotSimTest {
  private static PilotSim test1;

  @Before
  public void setUp() throws Exception {
    test1 = new PilotSim();
  }

  @Test
  public void findHour() {
    System.out.println(test1.findHour(0));
    System.out.println(test1.findHour(10));
    System.out.println(test1.findHour(55));
    System.out.println(test1.findHour(99));
  }

  @Test
  public void randomNumberGenerator() {
  }

  @Test
  public void timeGenerator() {
  }
}