package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MapSitePage extends BasePage{
    public MapSitePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    





}
