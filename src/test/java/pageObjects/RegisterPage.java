package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage   {
    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //localizadores
    @FindBy (how= How.CSS, using = "a[title='Register']")
    @CacheLookup
    private WebElement registerBtn;

    @FindBy (how= How.CSS, using = "#firstname")
    @CacheLookup
    private WebElement firstNameField;

    @FindBy (how= How.CSS, using = "#lastname")
    @CacheLookup
    private WebElement lastNameField;

    @FindBy (how= How.CSS, using = "#email_address")
    @CacheLookup
    private WebElement emailField;

    @FindBy (how= How.CSS, using = "#password")
    @CacheLookup
    private WebElement passWordField;

    @FindBy (how= How.CSS, using = "#confirmation")
    @CacheLookup
    private WebElement confirmPassField;

    @FindBy (how= How.CSS, using = "#is_subscribed")
    @CacheLookup
    private WebElement subscribeNewsletter;

    @FindBy (how= How.CSS, using = "button[title='Register'] span span")
    @CacheLookup
    private WebElement registerUserBtn;

    @FindBy (how= How.CSS, using = "li[class='success-msg'] ul li")
    @CacheLookup
    private WebElement welcomeRegisteredUserMsg;

    public void fillFirstNameRegister(String firstNameRegister){
        firstNameField.sendKeys(firstNameRegister);
    }
    public void fillLastNameRegister(String lastNameRegister){
        lastNameField.sendKeys(lastNameRegister);
    }

    public void fillEmailRegister(String emailRegister){
        emailField.sendKeys(emailRegister);
    }
    public void fillPassRegister(String passRegister){
        passWordField.sendKeys(passRegister);
    }
    public void fillConfirmPass(String confirmPassRegister){
        confirmPassField.sendKeys(confirmPassRegister);
    }
    public void clickOnRegisterBtn(){
        registerBtn.click();
    }
    public void clickOnRegisterUserBtn(){
        registerUserBtn.click();
    }
    public  String getWelcomeRegisteredUserMsg(){
        return  welcomeRegisteredUserMsg.getText();
    }





}
