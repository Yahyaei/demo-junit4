package com.example.demojunit4;

import net.minidev.json.JSONUtil;
import org.apache.juli.logging.LogFactory;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.mockito.internal.util.StringUtil;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.PrintStream;


import static com.example.demojunit4.Validator.isEmailValid;
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
    //testar ett korrekt telefonnummer
    void testValidPhoneNumber() {
        boolean result = Validator.isPhoneNumberValid("0746598230");

        assertTrue(result);

    }

    @Test
    //testar ett telefon nummer som börjar på 0
    void checkIfNumberStartsWithZero() {
        boolean result = Validator.isPhoneNumberValid("0746598230");

        assertTrue(result);

    }
    @Test
    //testar skicka ett telefon nummer som inte börjar på 0
    public void phoneNumberDoNotStartsWithZero() {

        boolean result = Validator.isPhoneNumberValid("1284648596");

        assertFalse(result);

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

    @Test
    //Testa om meton retunerar ett felmeddelande när man har snedstreck i telefonnumret
    public void testIfPhoneNumberIsValidWithSlashCharacters() {

        boolean result = Validator.isPhoneNumberValid("074//46587089");

        assertFalse(result);

    }
    @Test
   //testar skicka in ett värde med bara mellanslag som argument
    public void testPhoneNumber_with_emptyInput() {

        boolean result = Validator.isPhoneNumberValid("  ");

        assertFalse(result);

    }
    @Test
    //testar skicka in ett långt telefon nummer
    public void testPhoneNumber_with_LoongNumber() {

        boolean result = Validator.isPhoneNumberValid("0756839768564736282");

        assertFalse(result);

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
    public void testExtractEmailPartsWithInvalidIndexSign() {
        String email = "hello@hotmail.com";
        //indexOf är en metod som man använder för att söka efter en viss teckensträng i en annan teckensträng
        int positionSign = email.indexOf("@");
        //lastIndexOf metoden hittar positionen för det sista
        int domainPositionStart = email.lastIndexOf(".");
        String topDomainName = email.substring(domainPositionStart + 1);
        String emailDomaine = email.substring(positionSign + 1, domainPositionStart);
        String emailName = email.substring(0, positionSign);
        String[] expected = {"hello", "hotmail", "com"};
        String[] actual = {emailName, emailDomaine, topDomainName};
        assertArrayEquals(expected, actual);
    }

    //kontrollerar att det förväntade resultatet är falskt, för att eport adressen är ogiltig
    @Test
    public void testIsEmailValidWithInvalidSign() {
        String email = " hello!hotmail.com";
        boolean result = Validator.isEmailValid(email);
        assertFalse(result);
    }

    // kontrollerar att det testfallet returnerar false falskt, för att epostadressen saknar . i formatet

    //vill få ut ett felmeddelande isåfall
    @Test
    public void testIsEmailValidWithNoDot() {
        String email = " hello@hotmailcom";
        boolean result = Validator.isEmailValid(email);
        assertFalse(result);
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
        String email = "Alexanderaxelssonhejsanssonnnn@.com";

        assertFalse(Validator.isEmailValid(email));


    }

    @Test
    public void testIfEmailValidWithEmptyEmail() {
        // retunera false om emailadress fältet är tomt, ett felmeddelande bör visas i terminalen
        String email = "";

        assertFalse(Validator.isEmailValid(email));


    }

    @Test
    public void testIfIsEmailValidWithNumbers(){
        String str = "142336374757585884";
        String result = Validator.ShouldContainsOnlyLetters(str);
        assertEquals("Error", result);
    }







}



