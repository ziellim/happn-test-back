package com.happn.testback;

public class Util {

    /**
     * the largest multiple value of INCREMENT that is less than or equal to the argument
     * scale(0.1) == 0.0
     * scale(0.6) == 0.5
     * scale(-4.8) == -5.0
     */
    public static Double scale(Double value, Double increment){
        return Math.floor(value / increment) * increment;
    }
}
