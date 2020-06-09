package model.data;

import java.util.HashMap;
import java.util.Map;

public class Constant {

    private Map<String, Integer> amountOfCustomers;
    private Map<String, double[]> entryTimeDist;
    private Map<String, Map<String, double[]>> durationTimeDist;

    public Constant() {

        // load total amount of customers per Day

        this.amountOfCustomers = new HashMap<>();
        this.amountOfCustomers.put("Monday", 800);
        this.amountOfCustomers.put("Tuesday", 1000);
        this.amountOfCustomers.put("Wednesday", 1200);
        this.amountOfCustomers.put("Thursday", 900);
        this.amountOfCustomers.put("Friday", 2500);
        this.amountOfCustomers.put("Saturday", 4000);
        this.amountOfCustomers.put("Sunday", 5000);
        this.amountOfCustomers.put("NiceWeekend", 6300);
        // this.amountOfCustomers.put("MondayBeforeHoliday", 920);
        // this.amountOfCustomers.put("TuesdayBeforeHoliday", 1150);
        // this.amountOfCustomers.put("WednesdayBeforeHoliday", 1380);
        // this.amountOfCustomers.put("ThursdayBeforeHoliday", 1035);
        // this.amountOfCustomers.put("FridayBeforeHoliday", 2875);
        // this.amountOfCustomers.put("SaturdayBeforeHoliday", 4600);
        // this.amountOfCustomers.put("SundayBeforeHoliday", 5750);
        // this.amountOfCustomers.put("Holiday", 5400);
        // this.amountOfCustomers.put("DayBeforeHoliday", 6300);

        // load entry time distributions

        this.entryTimeDist = new HashMap<>();
        this.entryTimeDist.put("Monday", new double[]{0.005, 0.025, 0.03, 0.05, 0.075, 0.08, 0.1, 0.08, 0.06, 0.065, 0.07, 0.11, 0.12, 0.08, 0.05});
        this.entryTimeDist.put("Wednesday", new double[]{0.005, 0.025, 0.03, 0.05, 0.075, 0.08, 0.1, 0.08, 0.06, 0.065, 0.07, 0.11, 0.12, 0.08, 0.05});
        this.entryTimeDist.put("Thursday", new double[]{0.005, 0.025, 0.03, 0.05, 0.075, 0.08, 0.1, 0.08, 0.06, 0.065, 0.07, 0.11, 0.12, 0.08, 0.05});
        this.entryTimeDist.put("Friday", new double[]{0.005, 0.025, 0.03, 0.05, 0.075, 0.08, 0.1, 0.08, 0.06, 0.065, 0.07, 0.11, 0.12, 0.08, 0.05});

        this.entryTimeDist.put("Tuesday", new double[]{0.005, 0.01, 0.02, 0.03, 0.1, 0.1, 0.12, 0.07, 0.05, 0.06, 0.065, 0.15, 0.12, 0.07, 0.03});

        this.entryTimeDist.put("Saturday", new double[]{0.003, 0.005, 0.04, 0.06, 0.07, 0.075, 0.085, 0.082, 0.08, 0.09, 0.1, 0.1, 0.09, 0.06, 0.06});
        this.entryTimeDist.put("Sunday", new double[]{0.003, 0.005, 0.04, 0.06, 0.07, 0.075, 0.085, 0.082, 0.08, 0.09, 0.1, 0.1, 0.09, 0.06, 0.06});

        this.entryTimeDist.put("NiceSaturday", new double[]{0.001, 0.004, 0.01, 0.05, 0.06, 0.1, 0.12, 0.08, 0.06, 0.07, 0.085, 0.13, 0.15, 0.05, 0.03});
        this.entryTimeDist.put("NiceSunday", new double[]{0.001, 0.004, 0.01, 0.05, 0.06, 0.1, 0.12, 0.08, 0.06, 0.07, 0.085, 0.13, 0.15, 0.05, 0.03});

        // load duration time distributions

        this.durationTimeDist = new HashMap<>();

        Map<String, double[]> sixToSeven = new HashMap<>();
        sixToSeven.put("Monday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        sixToSeven.put("Tuesday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        sixToSeven.put("Wednesday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        sixToSeven.put("Thursday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        sixToSeven.put("Friday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        sixToSeven.put("Saturday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        sixToSeven.put("Sunday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        sixToSeven.put("NiceSaturday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        sixToSeven.put("NiceSunday", new double[]{0.35, 0.55, 0.1, 0, 0, 0});
        this.durationTimeDist.put("6-7", sixToSeven);

        Map<String, double[]> eightToNine = new HashMap<>();
        eightToNine.put("Monday", new double[]{0.3, 0.55, 0.15, 0, 0, 0});
        eightToNine.put("Tuesday", new double[]{0.3, 0.55, 0.15, 0, 0, 0});
        eightToNine.put("Wednesday", new double[]{0.3, 0.55, 0.15, 0, 0, 0});
        eightToNine.put("Thursday", new double[]{0.3, 0.55, 0.15, 0, 0, 0});
        eightToNine.put("Friday", new double[]{0.3, 0.55, 0.15, 0, 0, 0});
        eightToNine.put("Saturday", new double[]{0, 0.2, 0.4, 0.3, 0.1, 0});
        eightToNine.put("Sunday", new double[]{0, 0.2, 0.4, 0.3, 0.1, 0});
        eightToNine.put("NiceSaturday", new double[]{0, 0.2, 0.4, 0.3, 0.1, 0});
        eightToNine.put("NiceSunday", new double[]{0, 0.2, 0.4, 0.3, 0.1, 0});
        this.durationTimeDist.put("8-9", eightToNine);

        Map<String, double[]> tenToEleven = new HashMap<>();
        tenToEleven.put("Monday", new double[]{0.3, 0.5, 0.2, 0, 0, 0});
        tenToEleven.put("Tuesday", new double[]{0.2, 0.2, 0.1, 0.3, 0.2, 0});
        tenToEleven.put("Wednesday", new double[]{0.3, 0.5, 0.2, 0, 0, 0});
        tenToEleven.put("Thursday", new double[]{0.3, 0.5, 0.2, 0, 0, 0});
        tenToEleven.put("Friday", new double[]{0.3, 0.5, 0.2, 0, 0, 0});
        tenToEleven.put("Saturday", new double[]{0, 0.1, 0.1, 0.25, 0.35, 0.2});
        tenToEleven.put("Sunday", new double[]{0, 0.1, 0.1, 0.25, 0.35, 0.2});
        tenToEleven.put("NiceSaturday", new double[]{0.1, 0.3, 0.1, 0.15, 0.2, 0.15});
        tenToEleven.put("NiceSunday", new double[]{0.1, 0.3, 0.1, 0.15, 0.2, 0.15});
        this.durationTimeDist.put("10-11", tenToEleven);

        Map<String, double[]> twelve = new HashMap<>();
        twelve.put("Monday", new double[]{0.5, 0.35, 0.13, 0.02, 0, 0});
        twelve.put("Tuesday", new double[]{0.5, 0.35, 0.13, 0.02, 0, 0});
        twelve.put("Wednesday", new double[]{0.5, 0.35, 0.13, 0.02, 0, 0});
        twelve.put("Thursday", new double[]{0.5, 0.35, 0.13, 0.02, 0, 0});
        twelve.put("Friday", new double[]{0.45, 0.3, 0.2, 0.05, 0, 0});
        twelve.put("Saturday", new double[]{0, 0.05, 0.1, 0.25, 0.35, 0.25});
        twelve.put("Sunday", new double[]{0, 0.05, 0.1, 0.25, 0.35, 0.25});
        twelve.put("NiceSaturday", new double[]{0.1, 0.3, 0.1, 0.15, 0.2, 0.15});
        twelve.put("NiceSunday", new double[]{0.1, 0.3, 0.1, 0.15, 0.2, 0.15});
        this.durationTimeDist.put("12", twelve);

        Map<String, double[]> thirteenToSixteen = new HashMap<>();
        thirteenToSixteen.put("Monday", new double[]{0.35, 0.45, 0.2, 0, 0, 0});
        thirteenToSixteen.put("Tuesday", new double[]{0.35, 0.45, 0.2, 0, 0, 0});
        thirteenToSixteen.put("Wednesday", new double[]{0.35, 0.45, 0.2, 0, 0, 0});
        thirteenToSixteen.put("Thursday", new double[]{0.35, 0.45, 0.2, 0, 0, 0});
        thirteenToSixteen.put("Friday", new double[]{0.3, 0.4, 0.2, 0.05, 0.05, 0});
        thirteenToSixteen.put("Saturday", new double[]{0, 0.02, 0.13, 0.2, 0.4, 0.25});
        thirteenToSixteen.put("Sunday", new double[]{0, 0.02, 0.13, 0.2, 0.4, 0.25});
        thirteenToSixteen.put("NiceSaturday", new double[]{0, 0.02, 0.13, 0.2, 0.4, 0.25});
        thirteenToSixteen.put("NiceSunday", new double[]{0, 0.02, 0.13, 0.2, 0.4, 0.25});
        this.durationTimeDist.put("13-16", thirteenToSixteen);

        Map<String, double[]> seventeenToEighteen = new HashMap<>();
        seventeenToEighteen.put("Monday", new double[]{0.4, 0.45, 0.2, 0.15, 0, 0});
        seventeenToEighteen.put("Tuesday", new double[]{0.4, 0.45, 0.2, 0.15, 0, 0});
        seventeenToEighteen.put("Wednesday", new double[]{0.4, 0.45, 0.2, 0.15, 0, 0});
        seventeenToEighteen.put("Thursday", new double[]{0.4, 0.45, 0.2, 0.15, 0, 0});
        seventeenToEighteen.put("Friday", new double[]{0.35, 0.45, 0.1, 0.05, 0.05, 0});
        seventeenToEighteen.put("Saturday", new double[]{0, 0.02, 0.08, 0.15, 0.45, 0.3});
        seventeenToEighteen.put("Sunday", new double[]{0, 0.02, 0.08, 0.15, 0.45, 0.3});
        seventeenToEighteen.put("NiceSaturday", new double[]{0.1, 0.3, 0.1, 0.15, 0.2, 0.15});
        seventeenToEighteen.put("NiceSunday", new double[]{0.1, 0.3, 0.1, 0.15, 0.2, 0.15});
        this.durationTimeDist.put("17-18", seventeenToEighteen);

        Map<String, double[]> NineteenToTwenty = new HashMap<>();
        NineteenToTwenty.put("Monday", new double[]{0.35, 0.45, 0.2, 0, 0, 0});
        NineteenToTwenty.put("Tuesday", new double[]{0.35, 0.45, 0.2, 0, 0, 0});
        NineteenToTwenty.put("Wednesday", new double[]{0.35, 0.45, 0.2, 0, 0, 0});
        NineteenToTwenty.put("Thursday", new double[]{0.35, 0.45, 0.2, 0, 0, 0});
        NineteenToTwenty.put("Friday", new double[]{0.3, 0.4, 0.2, 0.05, 0.05, 0});
        NineteenToTwenty.put("Saturday", new double[]{0, 0.02, 0.13, 0.2, 0.4, 0.25});
        NineteenToTwenty.put("Sunday", new double[]{0, 0.02, 0.13, 0.2, 0.4, 0.25});
        NineteenToTwenty.put("NiceSaturday", new double[]{0, 0.02, 0.13, 0.2, 0.4, 0.25});
        NineteenToTwenty.put("NiceSunday", new double[]{0, 0.02, 0.13, 0.2, 0.4, 0.25});
        this.durationTimeDist.put("19-20", NineteenToTwenty);

    }

    public Map<String, Integer> getAmountOfCustomers() {
        return amountOfCustomers;
    }

    public Map<String, double[]> getEntryTimeDist() {
        return entryTimeDist;
    }

    public Map<String, Map<String, double[]>> getDurationTimeDist() {
        return durationTimeDist;
    }
}
