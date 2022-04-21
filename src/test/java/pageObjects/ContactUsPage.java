package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    WebDriver driver;
    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //locators
    @FindBy (how = How.CSS, using = "#name")
    @CacheLookup
    WebElement contactUsNameField;

    @FindBy (how = How.CSS, using = "#email")
    @CacheLookup
    WebElement contactUsEmailField;

    @FindBy (how = How.CSS, using = "#telephone")
    @CacheLookup
    WebElement contactUsPhoneField;


    @FindBy (how = How.CSS, using = "#comment")
    @CacheLookup
    WebElement contactUsCommentField;

    @FindBy (how = How.XPATH, using = "//span[contains(text(),'Submit')]")
    @CacheLookup
    WebElement submitBtn;

    @FindBy (how = How.CSS, using = "li[class='success-msg'] ul li span")
    @CacheLookup
    WebElement successMsg;

    public void fillFirstName(String firstName){
        contactUsNameField.sendKeys(firstName);
    }
    public void fillEmail(String email){
        contactUsEmailField.sendKeys(email);
    }
    public void fillPhone(String phone){
        contactUsPhoneField.sendKeys(phone);
    }
    public void fillComment(String comment){
        contactUsCommentField.sendKeys(comment);
    }
    public void clickOnSubmit(){
        submitBtn.click();
    }

    public String getSuccessMsg(){
        return successMsg.getText();
    }
    public WebElement getSuccesMsg(){
        return successMsg;
    }

}
