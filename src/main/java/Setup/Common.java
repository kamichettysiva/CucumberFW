package Setup;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Common {
    public void safeClickOnElement(WebDriver driver, By by){
        try {
            WebElement element = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            element.click();
        }
        catch(StaleElementReferenceException ex)
        {
            WebElement element = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            element.click();
        }
    }


    public WebElement safeFindElement(WebDriver driver, By by){
        try {
            WebElement element = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            return element;
        }
        catch(StaleElementReferenceException ex)
        {
            WebElement element = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.presenceOfElementLocated(by));
            return element;
        }
    }
}

