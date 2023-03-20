package com.example.demojunit4;

import net.minidev.json.JSONUtil;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintStream;


import static com.example.demojunit4.Validator.isPhoneNumberValid;
import static com.jayway.jsonpath.internal.path.PathCompiler.fail;
import static java.lang.String.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class DemoJunit4ApplicationTests {

    Calculator calc = new Calculator();


    @Test
    public void testAddNumber() {

        assertEquals(10, calc.add(5, 5));
    }

    @Test
    public void testSubtract() {


        assertEquals(0, calc.subtract(5, 5));
    }

    @Test
    public void testMultiplyTwoNumbers() {


        assertEquals(25, calc.multiply(5, 5));
    }

    @Test
    public void testDivideTwoNumbers() {


        assertEquals(5, calc.divide(25, 5));
    }


    //vill vi checka så att uträkningen stämmer överens med resultatet


    @Test
    public void testSquareRootOfPositiveInteger() {
        double result = calc.squareRootOf(9);
        assertEquals(3.0, result);
    }


    // Här kollar vi att vår test faktiskt skickar tillbaka NaN när vi försöker få roten ur ett negativt tal
    @Test
    public void testSquareRootOfZero() {
        double result = calc.squareRootOf(0);
        assertEquals(0.0, result);
    }

    @Test
    public void testSquareRootOfNegativeNumber() {
        double result = calc.squareRootOf(-9);
        assertTrue(Double.isNaN(result));
    }

    @Test
    public void testSquareRootOfDecimalNumber() {
        double result = calc.squareRootOf(2.25);
        assertEquals(1.5, result);
    }


    //vill vi checka så att svaret stämmer överens med resultatet
    @Test

    public void testGetArea() {

        assertEquals(50.27, calc.getArea(4));

    }

    // test för en kvadrat med sidläng 5
    @Test
    public void testSquareWithSideLengthFive() {
        double a = 5.0;
        double expectedArea = 78.54;

        assertEquals(expectedArea, calc.getArea(a));
    }


    //vill vi checka så att uträkningen stämmer överens med resultatet
    @Test
    public void testGetAreaWithPositiveInput() {
        double result = calc.getArea(5);

        assertEquals(78.54, result);

    }

    @Test
// Här kollar vi att vår test faktiskt skickar tillbaka NaN "not a number" när vi försöker få arean av ett negativt tal
    public void testGetAreaWithNegativeInput() {
        double result = calc.getArea(-1);

        assertTrue(Double.isNaN(result));

    }

    @Test
//vill vi checka så att uträkningen stämmer överens med resultatet
    public void testGetCircumferenceWithValidInput() {
        double result = calc.getCircumference(12);

        assertEquals(75.4, result);

    }

    @Test
// Här kollar vi att vår test faktiskt skickar tillbaka NaN när vi försöker få arean av ett negativt tal
    public void testGetCircumferenceWithInvalidInput() {
        double result = calc.getCircumference(-10);

        assertTrue(Double.isNaN(result));

    }

    // Validator class
    @Test
    void checkIfNumberStartsWithZero() {
        boolean result = Validator.isPhoneNumberValid("0746598230");

        assertTrue(result);

    }

    @Test
    public void testInvalidPhoneNumberWithTooFewDigits() {
        //testar skriva in ett kort telefon nummer
        boolean result = Validator.isPhoneNumberValid("012");

        assertFalse(result);
    }

    @Test
    public void testIsPhoneNumberContainsInvalidCharacters() {
        //testar skriva in ogiltiga tecken i telefon numret
        assertFalse(isPhoneNumberValid("01234A6789"));
    }

    @Test
    //Testa om meton retunerar True när man har space i telefonnumret
    public void testPhoneNumberWithExtraSpaces() {
        boolean result = Validator.isPhoneNumberWithExtraSpaces("047 012345");

        assertTrue(result);

    }


    //Testa om meton retunerar True vid en giltig Mail-adress
    @Test
    public void testValidEmail() {
        boolean result = Validator.isEmailValid("hello@mail.com");
        assertTrue(result);
    }

    @Test
    public void testInvalidEmail() {
        boolean result = Validator.isEmailValid("mail.com");

        assertFalse(result);

    }


    @Test
    public void testExtractEmailParts() {
        String email = "hello@hotmail.com";
        int domainIndexStart = email.lastIndexOf(".");
        int indexSign = email.lastIndexOf("@");
        String topDomainName = email.substring(domainIndexStart + 1);
        String emailDomaine = email.substring(indexSign + 1, domainIndexStart);
        String emailName = email.substring(0, indexSign);
        String[] expected = {"hello", "hotmail", "com"};
        String[] actual = {emailName, emailDomaine, topDomainName};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testNameLength() {

        assertFalse(Validator.isNameValid("Alexanderalexanaaa"));// invalid name
        // assertTrue(Validator.isNameValid("Alexander")); // valid name

    }

    @Test
    public void testEmailInputWithExtraSpaces() {
        //with space
        String email = "Alexander @.mail.com";
        assertTrue(Validator.isEmailContentIndexSign(email));

    }

    @Test
    public void testIfEmailNameToLong() {

       // retunera false om emailadress är orimligt lång
        String email = "Alexanderaxelssonhejsansson@.com";

        assertFalse(Validator.isEmailNameSizeValid(email));


    }

}



