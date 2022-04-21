package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BasePage {
    public WebDriver driver;
    public WebDriver initializeDriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ddume\\OneDrive\\Escritorio\\Dustin\\src\\test\\resources\\data.properties");
        prop.load(fileInputStream);
        String browserName = prop.getProperty("browser");

        switch (browserName) {
            case "chrome":
                //ejecuto chrome
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ddume\\OneDrive\\Escritorio\\Dustin\\drivers\\chrome\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                //ejecuto firefox
                System.setProperty("webdriver.geckodriver.driver", "C:\\Users\\ddume\\OneDrive\\Escritorio\\Dustin\\drivers\\firefox\\geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "IE":
                //ejecuto InternetExplorer
                break;
        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;



    }
    public boolean validatePageTitle(WebDriver driver, String expectedTitle){
        boolean var = false;
        if(driver.getTitle().equalsIgnoreCase(expectedTitle)){
            var = true;
        }
        return  var;
    }



}
