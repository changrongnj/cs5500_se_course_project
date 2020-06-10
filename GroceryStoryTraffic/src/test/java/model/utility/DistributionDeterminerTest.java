package model.utility;

import model.data.Constant;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import model.HolidayType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class DistributionDeterminerTest {

    private LocalDate ld = LocalDate.of(2020, 5, 15);
    private Constant constant = new Constant();
    private Util util = new Util();

    @Test
    void getDailyVolumeTest() {
        assertEquals(DistributionDeterminer.getDailyVolume(ld, constant), 2500);
    }

    @Test
    void applyHolidayVolumeTest() {
        assertEquals(DistributionDeterminer.applyHolidayVolume(HolidayType.IS_HOLIDAY, 1000), 1200);
    }

    @Test
    void getEntryTimeTest() {
        LocalDateTime ldt = DistributionDeterminer.getEntryTime(1, ld, constant);
        System.out.println(ldt);
    }

    @Test
    void getDurationDistributionTest() {
        LocalDateTime ldt = ld.atTime(12, 1);
        assertArrayEquals(DistributionDeterminer.getDurationDistribution(ldt, constant, util), new double[]{0.45, 0.3, 0.2, 0.05, 0, 0});
    }

}
