package com.example.demojunit4;

import static java.lang.Long.MAX_VALUE;

public class Calculator {

    private int lowValue;


    public Calculator() {
        lowValue = 0;

    }

    public int add(int a, int b) {
        if (a <= 0 && b <= 0) {
            System.out.println(" You can't add two negative numbers ");
        }
        return a + b;
    }

    // här vill jag att användare får ett meddelande att värdet du angivit är för lågt
    public int addTwoNegativeNr(int a, int b) {
        if (a <= 0 || b <= 0) {
            System.out.println(lowValue + "value to low ");


        }
        return a + b;

    }


    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        return (double) a / (double) b;
    }


    public double squareRootOf(double a) {
        if (a < 0) {

            System.out.println("Your value is a NoN value, please enter a positive number ");
            return Double.NaN;
        }

        return Math.sqrt(a);

    }


    public double getArea(double a) {
        try {
            if (a <= 0) {

                System.out.println(" you cannot input a negative value , value is to low ");
                return Double.NaN;
            }
            if (a > Double.MAX_VALUE / 2) {
                throw new IllegalArgumentException(" the input i to high, side lenght is too large ");
            }
            double area = Math.PI * (a * a);
            return Math.round(area * 100.0) / 100.0;
        } catch (IllegalArgumentException e) {
            System.out.println(" Wrong input " + e.getMessage());
            return Double.NaN;
        }



    }
    public double getCircumference(double a) {
        if (a <= 0) {
            System.out.println("Input to low! ");
            return Double.NaN;
        }
        double circumference = Math.PI * 2 * a;
        return Math.round(circumference * 100.0) / 100.0;
    }


}
