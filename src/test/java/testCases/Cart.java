package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.*;

import java.io.IOException;

public class Cart extends BasePage {
public static Logger log = LogManager.getLogger(BasePage.class.getName());

    @BeforeClass
    public void openBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }
    @Test
    @Description("Eliminate succesfully a product from the cart")
    @Epic("EPIC1")
    @Feature("Feature1: CART")
    public void eliminateProduct()  {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        HomePage homePage = new HomePage(driver);
        ProducPage producPage = new ProducPage(driver);
        CartPage cartPage = new CartPage(driver);
        driver.get("http://magento-demo.lexiconn.com/");
        log.info("Navigate to the homepage");
        homePage.clickOnSearchBtn();
        homePage.searchProduct("card");
        producPage.selectFirstElement();
        producPage.addProductToCart();
        cartPage.emptyCart();
        Assert.assertEquals("SHOPPING CART IS EMPTY",cartPage.getSuccessEmptyCartMsg());
        log.info("The message for empty cart was displayed successfully");

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
