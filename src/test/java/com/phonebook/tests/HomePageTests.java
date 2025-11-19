package com.phonebook.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HomePageTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://telranedu.web.app/");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void isHomeComponentPresentTest(){
        System.out.println("Home Component is " + isHomeComponentPresent());
    }

    public boolean isHomeComponentPresent(){
        return driver.findElements(By.xpath("//div[2]//h1")).size() > 0;
    }

    @Test
    public void findElementsByXPathOnDemoWebShopTest() {
        driver.get("https://demowebshop.tricentis.com/");

        System.out.println("1. Logo present: " +
                isElementPresent(By.xpath("//div[@class='header-logo']/a")));

        System.out.println("2. Search input present: " +
                isElementPresent(By.xpath("//input[@id='small-searchterms']")));

        System.out.println("3. Search button present: " +
                isElementPresent(By.xpath("//input[@type='submit' and @value='Search']")));

        System.out.println("4. Register link present: " +
                isElementPresent(By.xpath("//a[@class='ico-register']")));

        System.out.println("5. Login link present: " +
                isElementPresent(By.xpath("//a[@class='ico-login']")));

        System.out.println("6. Wishlist link present: " +
                isElementPresent(By.xpath("//a[@class='ico-wishlist']")));

        System.out.println("7. Shopping cart link present: " +
                isElementPresent(By.xpath("//a[@class='ico-cart']")));

        System.out.println("8. Top menu 'Books' present: " +
                isElementPresent(By.xpath("//ul[@class='top-menu']//a[contains(.,'Books')]")));

        System.out.println("9. Footer block 'Information' present: " +
                isElementPresent(By.xpath("//div[@class='footer']//div[@class='column information']")));

        System.out.println("10. Newsletter email input present: " +
                isElementPresent(By.xpath("//input[@id='newsletter-email']")));
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }
}
