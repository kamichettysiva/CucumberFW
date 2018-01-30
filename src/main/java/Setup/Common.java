package Setup;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static Setup.Environment_Setup.driver;

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

    public static void captureScreenShot(WebDriver ldriver){

        // Take screenshot and store as a file format
        File src= ((TakesScreenshot)ldriver).getScreenshotAs(OutputType.FILE);
        try {
            // now copy the  screenshot to desired location using copyFile method
            FileUtils.copyFile(src, new File(System.getProperty("user.dir").toString() + "\\Screenshots\\"+System.currentTimeMillis()+".png"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());

        }

    }

    public void embedScreenshot(Scenario scenario){
        final byte[] screenshot = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png"); //stick it in the report
    }
}

