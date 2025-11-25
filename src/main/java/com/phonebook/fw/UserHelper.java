package com.phonebook.fw;

import com.phonebook.core.BaseHelper;
import com.phonebook.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginRegisterForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("button[type='submit']"));
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector("button[type='submit']"));
    }

    public boolean isSignOutButtonPresent() {
        return isElementPresent(By.xpath("//*[text()='Sign Out']"));
    }

    public boolean isAlertPresent() {
        return isElementPresent(By.cssSelector(".alert"));
    }
}
