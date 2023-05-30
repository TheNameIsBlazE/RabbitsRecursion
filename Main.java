package com.company;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    final private static int MAXDATASIZE = 1477;
    final private static String SEPARATOR = "============================================================================================================================";

    // progInfo METHOD ----------------------------------------------------------------

    public static void progInfo() {
        System.out.println(SEPARATOR);
        System.out.println("Hello!");
        System.out.println("This program will calculate the number of male/female pairs of rabbits after a given number of months.");
        System.out.println("In month 1, there is one pair of rabbits.");
        System.out.println("Rabbits reach sexual maturity in their third year of life, and will give birth to one more male/female pair of rabbits.");
        System.out.println("The program will display the pairs of rabbits for each month up to and including the month you select!");
    } // END progInfo METHOD

    // MAIN METHOD ----------------------------------------------------------------

    public static void main(String[] args) {

        // CONSTANTS, OBJECTS AND VARIABLES ----------------------------------------

        boolean mainDone;
        boolean done;
        String response;
        String garbage;
        Scanner s = new Scanner(System.in);
        Rabbits rabbits = new Rabbits();

        // STARTING THE PROGRAM WITH A PROGINFO METHOD --------------------------------------

        progInfo();

        // MAIN DO LOOP --------------------------------------------------------------

        do {

            // ASKING THE USER TO CONTINUE ----------------------------------------------------------------

            mainDone = false;
            System.out.println(SEPARATOR);
            System.out.println("Would you like to enter a month to find the pairs of rabbits alive in that month? (yes/no)");
            response = s.nextLine();

            // IF THEY SAY YES ----------------------------------------------------------------

            if (response.toUpperCase().equals("YES")) {

                // MAIN CODE ----------------------------------------------------------------

                // DO LOOP FOR TYPE CHECKING ----------------------------------------------------------------
                do {
                    done = false;

                    // ASKING THE USER TO ENTER THE NUMBER OF PAIRS THEY WANT TO INDEX
                    // ----------------------------------------------------------------
                    System.out.println(SEPARATOR);
                    System.out.println("Please enter the month.");

                    // IF THEIR RESPONSE CONTAINS AN INTEGER AND IS WITHIN THE SPECIFIED RANGE, PROCEED

                    // IF RESPONSE HAS AN INTEGER ----------------------------------------------------------------

                    if (s.hasNextInt()) {
                        rabbits.setMonth(s.nextInt());

                        // IF THE RESPONSE IS LESS THAN / EQUAL TO ZERO, GIVE AN ERROR ----------------------------------------------------------------

                        if (rabbits.getMonth() <= 0) {
                            System.out.println(SEPARATOR);
                            System.out.println("\t\tINPUT ERROR: Please enter a number of months GREATER than ZERO!");

                            // IF THE RESPONSE IS GREATER OR EQUAL TO THE FIRST VALUE THAT WILL GIVE INFINITY, GIVE AN ERROR ----------------------------------------------------------------

                        } else if (rabbits.getMonth() >= MAXDATASIZE) {
                            System.out.println(SEPARATOR);
                            System.out.println("\t\tINPUT ERROR: Any answers above and including " + MAXDATASIZE + " are unrealistic, as a value of infinity is reached!");

                            // IF THE THREE ABOVE CONDITIONS ARE TRUE, CHANGE DONE TO TRUE AND PROCEED WITH THE PROGRAM ----------------------------------------------------------------
                            // THE VALUE HAS BEEN ACCEPTED ----------------------------------------------------------------

                        } else {
                            done = true;
                        }

                        // IF THE USER DOES NOT ENTER A VALID INTEGER IN THE FIRST PLACE ----------------------------------------------------------------

                    } else {
                        System.out.println(SEPARATOR);
                        System.out.println("\t\tINPUT ERROR: Please enter a valid integer!");
                        garbage = s.nextLine();
                    }

                } while (!done);

                // GARBAGE COLLECTION TO PREVENT ISSUES WITH LOOPING ----------------------------------------------------------------

                garbage = s.nextLine();

                // RUNNING THE RECURSIVE METHOD AND PRINTING THE ANSWER ----------------------------------------------------------------
                System.out.println(SEPARATOR);
                System.out.println(rabbits.recursion() + " pairs");

                // AT THIS POINT, THE PROGRAM WILL LOOP AGAIN

                // ----------------------------------------------------------------
                // ----------------------------------------------------------------

                // IF THE USER SAYS NO TO THE INITIAL QUESTION (IF THEY WANT TO ENTER A PAIR) ----------------------------------------------------------------

            } else if (response.toUpperCase().equals("NO")) {
                System.out.println(SEPARATOR);
                System.out.println("Thank you for using this program!");
                System.out.println("Have a good day! :)");
                mainDone = true;

                // IF THE USER DOES NOT ENTER YES OR NO FOR THE INITIAL QUESTION ----------------------------------------------------------------

            } else {
                System.out.println(SEPARATOR);
                System.out.println("\t\tINPUT ERROR: Please enter YES or NO");
            }

        } while (!mainDone);
    } // END MAIN METHOD
} // END MAIN CLASS
