package com.company;

public class Rabbits {

    // FIELDS  -------------------------------------------------------------------------------------------------------------

    private int month;
    private int startingValue = 1;
    private double monthOne;
    private double monthTwo;
    private double monthThree;
    private int counter;

    // METHODS  ------------------------------------------------------------------------------------------------------------


    public void setMonth(int month) {

        // THESE ARE WHERE ALL THE VARIABLES ARE SET FOR USE IN THE PROGRAM
        // DUE TO LOOPING, THESE VARIABLES MUST BE UPDATED BEFORE THE RECURSION BEGINS

        this.month = month;
        monthOne = startingValue;
        monthTwo = startingValue;
        counter = 3; // Starting at 3 since the counter is used beginning after Month 3
        monthThree = 0;
    }

    // GET MONTH WILL BE USED FOR TYPE CHECKING THE MONTH VARIABLE IN THE MAIN CLASS

    public int getMonth() {
        return month;
    }

    public double recursion() {

        //  THE SEQUENCE THAT THIS QUESTION USES IS THE FIBONACCI SEQUENCE

        // THE PROGRAM IS DESIGNED TO MOVE INTO THE RECURSIVE SECTION WHEN THERE AER 3 OR MORE MONTHS
        // THE FIRST TWO MONTHS WILL ALWAYS BE 1 AND 1
        // THUS THEY ARE BRUTE FORCED TO PREVENT ERRORS

        // IF THE VALUE THE USER ENTERS IS EQUAL TO 1 ---------------------------------
        // RECURSION DOES NOT TAKE PLACE IN THIS SITUATION

        if (month == 1) {
            System.out.println("Month 1: " + monthOne + " pairs");
            counter = month;
            monthThree = monthOne;

            // IF THE VALUE THE USER ENTERS IS EQUAL TO 2 --------------------------------
            // RECURSION DOES NOT TAKE PLACE IN THIS SITUATION


        } else if (month == 2) {
            System.out.println("Month 1: " + monthOne + " pairs");
            System.out.println("Month 2: " + monthTwo + " pairs");
            counter = month;
            monthThree = monthTwo;

            // IF THE VALUE THE USER ENTERS FOR THE MONTH IS GREATER THAN OR EQUAL TO 3 ---------------
            // RECURSION DOES TAKE PLACE IN THIS SCENARIO

        } else {

            // IF THE LOOP HAS JUST BEGUN (SO MONTH THREE IS ZERO), PRINT MONTHS ONE AND TWO
            // THIS WAY THEY DO NOT PRINT EVERY TIME AND ONLY WILL PRINT ONCE

            if (monthThree == 0) {
                System.out.println("Month 1: " + monthOne + " pairs");
                System.out.println("Month 2: " + monthTwo + " pairs");
            }

            // THEN SET MONTH THREE
            // THE PROGRAM WILL SHIFT WITHIN THE SEQUENCE
            // THE THIRD TERM WILL BE SET TO THE SUM OF THE TWO TERMS BEFORE IT
            // THEN THE PROGRAM WILL SHIFT.  THE SECOND TERM WILL BECOME THE THIRD TERM
            // THE FIRST TERM WILL BECOME THE SECOND TERM

            monthThree = monthTwo + monthOne;
            monthOne = monthTwo;
            monthTwo = monthThree;

            // PRINT STATEMENT FOR THE NUMBER OF PAIRS

            System.out.println("Month " + counter + ": " + monthThree + " pairs");
        }

        // IF COUNTER DOES NOT EQUAL MONTH -----------------------------------------------------
        // IF THE COUNTER DOES NOT EQUAL THE MONTH, THE MONTH THE USER WANTS TO FIND HAS NOT BEEN ACHIEVED
        // THE PROGRAM MUST LOOP AGAIN RECURSIVELY
        // THE COUNTER IS INCREMENTED HERE TO MAKE SURE ALL MONTHS PRINT

        if (counter != month) {
            counter++;
            recursion();

            // IF THE COUNTER HAS FINISHED, THE USERS MONTH HAS BEEN FOUND ----------------------------
            // RECURSION WILL END HERE

        } else {
            System.out.print("Final pairs after " + counter + " month(s): ");
        }

        // FINAL VALUE & SENTENCE TO SATISFY A NON-VOID FUNCTION

        return monthThree;
    } // END recursion METHOD
} // END RABBITS CLASS
