package com.linkedin.javacodechallenges;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.regex.*;

public class App {

    private static final Logger logger = Logger.getLogger(App.class.getName());

    private static final String UPPERCASE_REGX = ".*[A-Z].*";
    private static final String LOWERCASE_REGX = ".*[a-z].*";
    private static final String DIGIT_REGX = ".*[0-9].*"; // "\d"
    /*
        len >= 6
        uppercase >= 1
        lowercase >= 1
        num >= 1
    */

    public static boolean isPasswordComplex(String password) {
        if (password.length() < 6) {
            logger.info("Length contraint failed");
            return false;
        }

        if (!password.matches(UPPERCASE_REGX)) {
            logger.info("Uppercase contraint failed");
            return false;
        }

        if (!password.matches(LOWERCASE_REGX)) {
            logger.info("Lowercase contraint failed");
            return false;
        }

        if (!password.matches(DIGIT_REGX)) {
            logger.info("Digit contraint failed");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}
