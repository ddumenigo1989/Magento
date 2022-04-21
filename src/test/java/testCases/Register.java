package testCases;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.RegisterPage;

import java.io.IOException;

public class Register extends BasePage {
    public static Logger log = LogManager.getLogger(BasePage.class.getName());

    @BeforeClass
    public void openBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Test
    @Description("Check the funcionality of Register an user")
    @Epic("EPIC4")
    @Feature("Feature1: REGISTER")
    public void registerUser() throws IOException {
        RegisterPage registerPage = new RegisterPage(driver);
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.get("http://magento-demo.lexiconn.com/");
        log.info("Navigate to the homepage");
        homePage.clickOnAccountBtn();
        registerPage.clickOnRegisterBtn();
        registerPage.fillFirstNameRegister("Manuel");
        registerPage.fillLastNameRegister("Pererz");
        registerPage.fillEmailRegister("manuelperez@mailinator.com");
        registerPage.fillPassRegister("manuel123");
        registerPage.fillConfirmPass("manuel123");
        registerPage.clickOnRegisterUserBtn();
        Assert.assertEquals("Thank you for registering with Madison Island.",registerPage.getWelcomeRegisteredUserMsg());
        log.info("The message for user registered was displayed successfully");

    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }
}
