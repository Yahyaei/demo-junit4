package com.example.demojunit4;


public class Validator {


    public static boolean isPhoneNumberValid(String phoneNumber) {

        if (!phoneNumber.startsWith("0")) {
            System.out.println(" (Phone number most began with 0! )");
            return false;
        }
        if (phoneNumber.length() < 6 || phoneNumber.length() > 10) {
            System.out.println("(PhoneNumber to short!!)");
            return false;
        }
        if (!phoneNumber.matches("[0-9]+")) {
            System.out.println("( you got a 'AssertionFailedError' , you have to input only numbers)");
            return false;
        }


        return true;
    }

    public static boolean isPhoneNumberWithExtraSpaces(String phoneNumber) {
        // Ta bort alla mellanslag från början och slutet av strängen
        phoneNumber = phoneNumber.trim();

        // Kolla om det finns några mellanslag kvar i strängen
        if (phoneNumber.contains(" ")) {
            System.out.println(" (Du får inte använda mellanslag i telefonnumret.)");
            return true;
        }

        // annars retunera false

        return false;
    }


    public static boolean isEmailValid(String email) {
        int indexOfTopLevelDomainStart = email.lastIndexOf(".");
        int indexOfAtSign = email.lastIndexOf("@");

        if (indexOfAtSign == -1 || indexOfTopLevelDomainStart == -1) {
            System.out.println("(Error, felaktig format på email-adress )");
            return false;
        }
        String topLevelDomain = email.substring(indexOfTopLevelDomainStart + 1); // se
        String domainName = email.substring(indexOfAtSign + 1, indexOfTopLevelDomainStart);
        String name = email.substring(0, indexOfAtSign);
        String[] requiredStringParts = {name, domainName, topLevelDomain};

        for (String emailAddress : requiredStringParts) {
            if (emailAddress.length() == 0) {
                System.out.println("( Invalid email-address )");

                return false;
            }

        }


        return true;
    }


    public static boolean isNameValid(String name) {
        if (name.length() == 0 || name.length() > 15) {
            System.out.println("( please enter a valid email address  )");
            return false;
        }
        return true;
    }

    public static boolean isEmailNameSizeValid(String email) {
        if (email.length() > 20) {
            System.out.println("( please enter a valid email address, email address too long )");
            return false;
        }
        return true;
    }

    public static boolean isEmailContentIndexSign(String email) {
        email = email.trim();

        if (email.contains(" ")) {
            System.out.println("AssertionFailedError: ( wrong formatting of email-address ! )");
            return true;
        }

        return false;
    }



}