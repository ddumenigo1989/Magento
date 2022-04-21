package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Empty Cart')]")
    @CacheLookup
    WebElement emptyCart;

    @FindBy(how = How.CSS,using = "div[class='page-title'] h1")
    @CacheLookup
    WebElement emptyShopingCartMsg;


    public void emptyCart(){
        emptyCart.click();
    }

    public String getSuccessEmptyCartMsg(){
        return emptyShopingCartMsg.getText();
    }


}
