import model.data.Constant;
import model.utility.DistributionDeterminer;
import model.utility.Util;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DistributionDeterminerTest {

    LocalDate ld = LocalDate.of(2016, 5, 15);
    Constant constant = new Constant();
    Util util = new Util();

    @Test
    void getDailyVolumeTest() {
        System.out.println(DistributionDeterminer.getDailyVolume(ld, constant, util));
    }

    @Test
    void getEntryTimeTest() {
        LocalDateTime ldt = DistributionDeterminer.getEntryTime(1, ld, constant, util);
        System.out.println(ldt);
    }

    @Test
    void getDurationDistributionTest() {
        LocalDateTime ldt = DistributionDeterminer.getEntryTime(1, ld, constant, util);
        System.out.println(Arrays.toString(DistributionDeterminer.getDurationDistribution(ldt, constant, util)));
    }

}
