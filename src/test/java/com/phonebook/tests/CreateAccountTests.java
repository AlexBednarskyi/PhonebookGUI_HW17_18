package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {

    @Test
    public void newUserRegisterPositiveTest() {
        // click on Login link
        click(By.cssSelector("[href='/login']"));

        // generate unique email for each run
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "manuel67" + i + "@gmail.com";

        // enter email
        type(By.name("email"), email);

        // enter password
        type(By.name("password"), "Pp1234567!");

        // click on Registration button
        click(By.name("registration"));

        // assert Sign Out button present
        Assert.assertTrue(
                isElementPresent(By.xpath("//button[.='Sign Out']")),
                "Sign Out button is not present"
        );
    }
}
