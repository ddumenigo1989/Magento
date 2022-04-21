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
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.SearchPage;

import java.io.IOException;

public class Search extends BasePage {
    public static Logger log = LogManager.getLogger(BasePage.class.getName());

    @BeforeClass
    public void openBrowser() throws IOException {
        driver = initializeDriver();
    }
    @Test
    @Description("Make a search that will not throw results")
    @Epic("EPIC5")
    @Feature("Feature1: SEARCH")
    public void noProductSearch() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        driver.get("http://magento-demo.lexiconn.com/");
        homePage.clickOnSearchBtn();
        homePage.searchProduct("nothing");
        Assert.assertEquals("Your search returns no results.",searchPage.noProductMsg());
    }
    @Test
    @Description("Make a valid search in the web application")
    public void productSearch() {
        HomePage homePage = new HomePage(driver);
        SearchPage searchPage = new SearchPage(driver);
        driver.get("http://magento-demo.lexiconn.com/");
        homePage.clickOnSearchBtn();
        homePage.searchProduct("glasses");
        Assert.assertEquals("$295.00",searchPage.getPrice());
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }

}
