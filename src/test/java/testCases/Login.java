package testCases;

import dataProvider.LoginData;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;

import java.io.IOException;

public class Login extends BasePage{
    public static Logger log = LogManager.getLogger(BasePage.class.getName());


    @BeforeClass
    public void openBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");

    }

    @Test(dataProvider = "users", dataProviderClass = LoginData.class)
    @Description("Check the funcionality of Login")
    @Epic("EPIC3")
    @Feature("Feature1: LOGIN")
    public void Login(String scenario,String username,String password) throws  InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);
        WebDriverWait wait = new WebDriverWait(driver,2);
        driver.get("http://magento-demo.lexiconn.com/");
        log.info("Navigate to the homepage");
        homePage.clickOnAccountBtn();
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginBtnVisible()));
        loginPage.clickLogin2();
        loginPage.usernameFill(username);
        loginPage.passwordFill(password);
        loginPage.clickLogin3();

        if(scenario.equals("scenario_correcto")){
            Assert.assertTrue(driver.getTitle().contains("My Account"));
        }else if (scenario.equals("scenario_incorrecto")){
            Assert.assertEquals("Invalid login or password.", loginPage.getinvalidLoginText());
        }else{
            Assert.assertEquals("* Required Fields", loginPage.getRequiredFieldMgs());
        }
        homePage.clearCache();
        Thread.sleep(200);
    }

    @AfterTest
    public void tearDown(){
        driver.close();
    }


}


