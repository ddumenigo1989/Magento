package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProducPage {
    WebDriver driver;

    public ProducPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    //locators
    @FindBy (how = How.CSS,using = "button[onclick='productAddToCartForm.submit(this)']")
    @CacheLookup
    WebElement addtoCartBtn;

    @FindBy (how = How.CSS,using = ".link-wishlist")
    @CacheLookup
    WebElement addToWishlist;

    @FindBy (how = How.CSS,using = ".link-compare")
    @CacheLookup
    WebElement addToCompare;


    public void selectFirstElement(){
        List<WebElement> results = driver.findElements(By.xpath("//li[@class='item last']"));
        if(results.size()>=1){
            results.get(0).click();
        }else {
            System.out.println("NO HAY ELEMENTOS QUE MOSTRAR");
        }
    }

    public void addProductToCart(){
        addtoCartBtn.click();
    }






}
