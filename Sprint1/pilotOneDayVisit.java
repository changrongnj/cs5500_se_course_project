
import java.util.Random;

public class pilotSim {

    public static void main(String[] args) {
        // these parameters below should retrive from other class/database
        int normalAmount = 50;
        int day = 1; //means Monday
        double[] visitDist = new double[] {0.03, 0.05, 0.06, 0.08, 0.09, 0.11, 0.095, 0.08, 0.07, 0.085, 0.12, 0.095, 0.035};

        int[] counter = new int[13];
        for (int i = 0; i < 2000; i++) {
            Time entryTime = timeGenerator(visitDist);
            counter[entryTime.getHour() - 8]++;
            // int visitID = i;
            // System.out.println(visitID + "   " + visitTime);
        }
        
        for (int i = 0; i < counter.length; i++) {
            System.out.println( (i+8) + ": " + counter[i]);
        }
    }



    public static int findHour(int num, double[] visitCumulative) {
        for (int i = 0; i < visitCumulative.length; i++) {
            if (num < visitCumulative[i]) {
                return i + 8; // store opens at 8
            }
        }
        System.out.println("Check the visit distribution, it was over 100%!!!");
        return -1;
    }

    public static Time timeGenerator(double[] visitDist) {
        
        double[] visitCumulative = new double[13];
        visitCumulative[0] = visitDist[0] * 100;
        for (int i = 1; i < visitDist.length; i++) {
            visitCumulative[i] = visitCumulative[i - 1] + visitDist[i] * 100;
        }

        int randomNum = randomNumberGenerator(100);
        int hour = findHour(randomNum, visitCumulative);
        int min = randomNumberGenerator(60);
        Time visitTime = new Time(hour, min);
        
        return visitTime;
    }


    public static int randomNumberGenerator(int range) {
        Random rand = new Random();
        int rand_number = rand.nextInt(range);
        return rand_number;
    }
}





class Time {
    /**
     * main constructor
     * @param hour
     * @param min
     */
    public Time(int hour, int min) {
        this.setHour(hour);
        this.setMin(min);
    }

    /**
     * default constructor
     */
    public Time() {

    }

    /**
     * copy constructor
     */
    public Time(Time other) {
        if (other != null) {
            this.setHour(other.getHour());
            this.setMin(other.getMin());
        }
    }

    private int hour = 0;
    private int min = 0;


    /**
     * setter and getter
     */
    public void setHour(int hour) { 
        if (hour < 0 || hour > 23) {  
            System.out.println("Hour input is invalid.");
            System.exit(1);
        }
        else {
            this.hour = hour;
        }
    }

    public int getHour() {return this.hour;}

    public void setMin(int min) { 
        if (min < 0 || min > 59) {  
            System.out.println("Min input is invalid.");
            System.exit(1);
        }
        else {
            this.min = min;
        }
    }

    public int getMin() {return this.min;}

    /**
     * toString() method for Date
     */
    @Override
    public String toString() {
        return this.hour + ":" + this.min;
    }
}    
