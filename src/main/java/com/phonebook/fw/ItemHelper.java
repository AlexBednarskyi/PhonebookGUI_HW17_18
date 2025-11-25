package com.phonebook.fw;

import com.phonebook.core.BaseHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ItemHelper extends BaseHelper {

    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public String getSecondItemName() {
        WebElement item = driver.findElement(
                By.cssSelector(".product-item:nth-of-type(2) .product-title a"));
        return item.getText();
    }

    public void clickOnSecondItemAddToCart() {
        driver.findElement(
                        By.cssSelector(".product-item:nth-of-type(2) input[value='Add to cart']"))
                .click();
    }

    public void clickOnShoppingCartLink() {
        driver.findElement(By.cssSelector("a[href='/cart']")).click();
    }

    public boolean isItemPresentInCart(String itemName) {
        return driver.findElements(
                        By.xpath("//table[contains(@class,'cart')]//a[text()='" + itemName + "']"))
                .size() > 0;
    }
}
