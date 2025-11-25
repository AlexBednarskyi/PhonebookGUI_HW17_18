package com.phonebook.core;

import com.phonebook.fw.ContactHelper;
import com.phonebook.fw.HomePageHelper;
import com.phonebook.fw.ItemHelper;
import com.phonebook.fw.UserHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ApplicationManager {

    protected WebDriver driver;

    private UserHelper user;
    private ContactHelper contact;
    private HomePageHelper homePage;
    private ItemHelper item;

    public void init() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
        contact = new ContactHelper(driver);
        homePage = new HomePageHelper(driver);
        item = new ItemHelper(driver);
    }

    public void stop() {
        driver.quit();
    }

    public UserHelper getUser() {
        return user;
    }

    public ContactHelper getContact() {
        return contact;
    }

    public HomePageHelper getHomePage() {
        return homePage;
    }

    public ItemHelper getItem() {
        return item;
    }
}
