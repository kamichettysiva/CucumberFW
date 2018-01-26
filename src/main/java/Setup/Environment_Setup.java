package Setup;

import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Environment_Setup {

    public static String driverPath = System.getProperty("user.dir").toString() + "\\Drivers\\";
    public static WebDriver driver;
    public String JavaVersion = System.getProperty("sun.arch.data.model");


    public WebDriver driver(String browser) {
        if (browser.equals("firefox") ){
            System.out.println( driverPath + JavaVersion + "geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", driverPath + JavaVersion + "geckodriver.exe");
            driver = new FirefoxDriver();
            return driver;
        } else if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
            driver = new ChromeDriver();
            return driver;
        }
        return null;
    }

}


