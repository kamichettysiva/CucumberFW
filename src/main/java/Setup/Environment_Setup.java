package Setup;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Environment_Setup {
    public static String driverPath = "D:\\Users\\UAT72\\Desktop\\Siva\\";
    public static WebDriver driver;

    public WebDriver driver(String browser) {
        if (browser == "firefox") {
            System.setProperty("webdriver.gecko.driver", driverPath + "geckodriver.exe");
            driver = new FirefoxDriver();
            return driver;
        } else if (browser == "chrome") {
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
            driver = new ChromeDriver();
            return driver;
        }
        return null;
    }

}


