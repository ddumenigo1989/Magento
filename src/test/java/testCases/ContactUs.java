package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.ContactUsPage;
import pageObjects.HomePage;

import java.io.IOException;

    public class ContactUs extends BasePage {
    public static Logger log = LogManager.getLogger(BasePage.class.getName());

    @BeforeClass
    public void openBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

    }

    @Test
    @Description("Check the function of ContactUs")
    @Epic("EPIC2")
    @Feature("Feature1: CONTACTUS")
    public void contactUs() {
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("http://magento-demo.lexiconn.com/");
        log.info("Navigate to the homepage");

        homePage.clickOnContactUsBtn();
        contactUsPage.fillFirstName("Jerry");
        contactUsPage.fillEmail("jerry@mailinator.com");
        contactUsPage.fillPhone("123456789");
        contactUsPage.fillComment("This is a test");
        contactUsPage.clickOnSubmit();
        wait.until(ExpectedConditions.visibilityOf(contactUsPage.getSuccesMsg()));
        Assert.assertEquals("Your inquiry was submitted and will be responded to as soon as possible. Thank you for contacting us.",contactUsPage.getSuccessMsg());
        log.info("The message for inquiry was sent successfully");
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
