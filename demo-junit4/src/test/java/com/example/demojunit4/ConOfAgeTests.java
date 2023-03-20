package com.example.demojunit4;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConOfAgeTests {

    //Här definerar vi vår objekt
    // för att komma åt metoder som finns i vår ConOfAge klass
    ConOfAge Control = new ConOfAge();

    @Test

    void shouldReturnTrueIfVisitorIsOverTwenty(){

        boolean result = Control.isAllowedToEnterLiquorStore(25,false,false,false);
        // här ska vi göra någon form av gämförelse av resultatet

        Assertions.assertTrue(result);

    }

}
