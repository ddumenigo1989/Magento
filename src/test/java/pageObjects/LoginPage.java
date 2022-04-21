package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //locators
    @FindBy (how = How.CSS, using = "a[title='Log In']")
    @CacheLookup
    private WebElement login2Btn;

    @FindBy (how = How.CSS, using = "a[title='Create an Account']")
    @CacheLookup
    private WebElement createAccountBtn;

    @FindBy (how = How.CSS, using = "#email")
    @CacheLookup
    private WebElement emailField;

    @FindBy (how = How.CSS, using = "#pass")
    @CacheLookup
    private WebElement passWordField;

    @FindBy (how = How.CSS, using =".f-left")
    @CacheLookup
    private WebElement forgotPassBtn;

    @FindBy (how = How.CSS, using ="#send2")
    @CacheLookup
    private WebElement login3Btn;

    @FindBy (how = How.CSS, using ="p[class='hello'] strong")
    @CacheLookup
    private WebElement welcomeMsg;

    @FindBy (how = How.XPATH, using ="//span[normalize-space()='Invalid login or password.']")
    @CacheLookup
    WebElement invalidLoginMsg;

    @FindBy (how = How.CSS, using ="p[class='required']")
    @CacheLookup
    WebElement requiredFieldMsg;


   /* public void Login(String username,String password){
        emailField.sendKeys(username);
        passWordField.sendKeys(password);
        login3Btn.click();
    }*/

    public void usernameFill(String username){
        emailField.sendKeys(username);
    }

    public void passwordFill(String password){
        passWordField.sendKeys(password);
    }

    public void clickLogin3(){
        login3Btn.click();
    }

    public void clickLogin2(){
        login2Btn.click();
    }

    public String getWelcomeText(){
        return welcomeMsg.getText();
    }

    public String getRequiredFieldMgs(){
        return requiredFieldMsg.getText();
    }

    public String getinvalidLoginText(){
        return invalidLoginMsg.getText();
    }

    public WebElement loginBtnVisible(){
        return login2Btn;
    }






}
