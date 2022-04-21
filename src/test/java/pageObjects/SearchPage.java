package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    public WebDriver driver;

    //locators
    @FindBy (how = How.CSS,using = ".note-msg")
    @CacheLookup
    WebElement noResultMsg;

    @FindBy (how = How.XPATH,using = "(//div[@class='price-box'])[1]")
    @CacheLookup
    WebElement price;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
   public String noProductMsg(){
        return noResultMsg.getText();
    }
    public String getPrice(){
        return price.getText();
    }

}



