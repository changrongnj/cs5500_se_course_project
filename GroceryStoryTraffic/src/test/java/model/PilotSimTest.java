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
    System.out.println(test1.findHour(0, test1.getVisitCumulative()));
    System.out.println(test1.findHour(10, test1.getVisitCumulative()));
    System.out.println(test1.findHour(30, test1.getVisitCumulative()));
    System.out.println(test1.findHour(99, test1.getVisitCumulative()));

  }

  @Test
  public void randomNumberGenerator() {
  }

  @Test
  public void timeGenerator() {
  }
}