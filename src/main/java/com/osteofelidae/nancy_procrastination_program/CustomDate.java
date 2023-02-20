// Package
package com.osteofelidae.nancy_procrastination_program;

// Class for date handling
public class CustomDate {

    // Instance variables
    private int year;
    private int month;
    private int day;

    // Basic constructor
    public CustomDate() {

        // Set instance variables
        year = 1;
        month = 1;
        day = 1;

    }

    // Constructor with input
    public CustomDate(int year, int month, int day) {

        // Set instance variables
        if (checkDate(year, month, day)){

            // Set instance variables
            this.year = year;
            this.month = month;
            this.day = day;

        }
        // If values are invalid
        else {

            // Raise exception
            throw new IllegalArgumentException("Month or day out of range");

        }

    }

    // Set variables
    public void set(int year, int month, int day){

        // Set instance variables
        if (checkDate(year, month, day)){

            // Set instance variables
            this.year = year;
            this.month = month;
            this.day = day;

        }
        // If values are invalid
        else {

            // Raise exception
            throw new IllegalArgumentException("Month or day out of range");

        }

    }

    // Day validity checker
    private boolean checkDate(int year, int month, int day) {

        // Set local variables
        int maxDays;
        int[] months31 = {1, 3, 5, 7, 8, 10, 12};
        int[] months30 = {4, 6, 9, 11};

        // Validate year
        if (year < 2000) {

            // Return false
            return false;

        }

        // Calculate maxDays

        // Feb
        if (month == 2) {

            // If leap year
            if ((year % 4 == 0) && ((!(year % 100 == 0)) || (year % 400 == 0))){

                // Set valid maxDays
                maxDays = 29;

            }
            // If not leap year
            else {

                // Set valid maxDays
                maxDays = 28;

            }

        }
        // 31 day months
        else if (in(months31, month)) {

            // Set valid maxDays
            maxDays = 31;

        }
        // 20 day months
        else if (in(months30, month)) {

            // Set valid maxDays
            maxDays = 30;

        }
        // Invalid month
        else{

            // Return false
            return false;

        }

        // If maxDays is valid
        if (0 <= day && maxDays >= day){

            // Return true
            return true;

        }
        // If not valid
        else {

            // Return false
            return false;

        }

    }

    // Check if item is in list
    private boolean in(int[] arrayIn, int number){

        // Iterate through array
        for (int item:arrayIn) {

            // If match
            if (item == number){

                // Return true
                return true;

            }

        }

        // If loop finishes, return false
        return false;

    }

    // To string method
    public String toString() {

        // Return text
        return "" + month + "/" + day + "/" + year;

    }

    // To int method - returns number of seconds since 2000 of the current date (estimated)
    public int toInt() {

        // Calculate
        int seconds = (day * 86400) + (month * 2592000) + ((year-2000) * 31104000);

        // Return value
        return seconds;

    }

}
