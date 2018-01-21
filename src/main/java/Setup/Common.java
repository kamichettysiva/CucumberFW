package Setup;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Common {
    public void safeClickOnElement(WebDriver driver, By by){
        try {
            WebElement element = driver.findElement(by);
            element.click();
        }
        catch(StaleElementReferenceException ex)
        {
            WebElement element = driver.findElement(by);
            element.click();
        }
    }
}
