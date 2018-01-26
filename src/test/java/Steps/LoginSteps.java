package Steps;


import Setup.Environment_Setup;
import Setup.Common;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginSteps {
    public static WebDriver driver;


    Environment_Setup env = new Environment_Setup();
    Common common = new Common();

    @Given("^I navigate to login page in \"([^\"]*)\"$")
    public void iNavigateToLoginPageIn(String browser) {
        driver = env.driver(browser);
        System.out.println("lala");
        if(browser.equals("firefox")) {
            driver.get("https://www.google.com");
        }else if(browser.equals("chrome")){
            driver.navigate().to("https://www.google.com");
        }

    }


    @And("^I enter user name admin and password admin$")
    public void i_enter_user_name_admin_and_password_admin() {

       //common.safeClickOnElement(driver,By.linkText("Sign in"));
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("idSIButton9")));
        if(myDynamicElement.isDisplayed()) {
            common.safeClickOnElement(driver, By.id("idSIButton9"));
        }
       //common.safeClickOnElement(driver,By.id("usernameError"));
        }

    @And("^click login button$")
    public void click_login_button() {


    }

    @Then("^I should see user form$")
    public void i_should_see_user_form()  {
        driver.close();
    }


}
