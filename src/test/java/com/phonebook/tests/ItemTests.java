package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ItemTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginRegisterForm(new User()
                .setEmail(UserData.email)
                .setPassword(UserData.password));
        app.getUser().clickOnLoginButton();
    }

    @Test(enabled = false)
    public void addItemToCartTest() {
        String itemName = app.getItem().getSecondItemName();
        app.getItem().clickOnSecondItemAddToCart();
        app.getItem().clickOnShoppingCartLink();
        Assert.assertTrue(app.getItem().isItemPresentInCart(itemName));
    }
}
