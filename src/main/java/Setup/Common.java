package Setup;

import cucumber.api.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import static Setup.Environment_Setup.driver;

public class Common {
    public void safeClickOnElement(WebDriver driver, By by){
        try {
            clicker(driver, by);
            }
        catch(StaleElementReferenceException | MoveTargetOutOfBoundsException ex)
        {
            clicker(driver, by);
        }
    }


    public WebElement safeFindElement(WebDriver driver, By by){
        try {
           return finder(driver, by);
        }
        catch(StaleElementReferenceException ex)
        {
            return finder(driver, by);
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

    public void clicker(WebDriver driver, By by){
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();

        }

    public WebElement finder(WebDriver driver, By by){
        WebElement element = (new WebDriverWait(driver, 60))
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return element;

    }
}

