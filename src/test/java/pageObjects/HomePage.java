package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
     WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //locators
    @FindBy(how = How.CSS, using ="a[class='skip-link skip-account'] span[class='label']")
    @CacheLookup
    private WebElement accountBtn;

    @FindBy(how = How.XPATH, using ="//a[normalize-space()='Contact Us']")
    @CacheLookup
    private WebElement contactUsBtn;

    @FindBy(how = How.CSS, using ="#search")
    @CacheLookup
    private WebElement searchBtnField;

    @FindBy(how = How.XPATH, using ="//settings-ui")
    @CacheLookup
    private WebElement settings;



    public void clickOnAccountBtn(){
        accountBtn.click();
    }
    public void clickOnContactUsBtn(){contactUsBtn.click();}
    public void clickOnSearchBtn(){searchBtnField.click();}

    public void searchProduct(String product){
        searchBtnField.sendKeys(product);
        searchBtnField.sendKeys(Keys.ENTER);
    }
    public WebDriver clearCache(){
        driver.manage().deleteAllCookies();
        driver.get("chrome://settings/clearBrowserData");
        driver.findElement(By.xpath("//settings-ui")).sendKeys(Keys.ENTER);
        return driver;
    }

}
