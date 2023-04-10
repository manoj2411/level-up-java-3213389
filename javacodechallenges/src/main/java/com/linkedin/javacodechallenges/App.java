package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {
    private static final double MIN_CHARGE = 18.84;
    private static final int ONE_CCF = 748;
    private static final double CHARGE = 3.9;
    private static final int BASE_CCF = 2;

    public static double calculateWaterBill(double gallonsUsage) {
        double extraUsage = gallonsUsage - (ONE_CCF * BASE_CCF);
        int extraUnits = getExtraUnits(extraUsage);

        return MIN_CHARGE + (extraUnits * CHARGE);
    }

    private static int getExtraUnits(double gallonsUsage) {
        if (gallonsUsage <= 0) {
            return 0;
        }
        return (int)Math.ceil(gallonsUsage / ONE_CCF);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
