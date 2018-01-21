package Steps;


import Setup.Environment_Setup;
import com.google.common.base.Function;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.hamcrest.Condition;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class LoginSteps {
    public static WebDriver driver;


    Environment_Setup env = new Environment_Setup();

    @Given("^I navigate to login page in \"([^\"]*)\"$")
    public void iNavigateToLoginPageIn(String browser) {
        driver = env.driver(browser);
        System.out.println("lala");
        if(browser.equals("firefox")) {
            driver.get("http://www.toolsqa.com");
        }else if(browser.equals("chrome")){
            driver.navigate().to("http://www.toolsqa.com");
        }

    }


    @And("^I enter user name admin and password admin$")
    public void i_enter_user_name_admin_and_password_admin() {

        Wait<WebDriver> stubbornWait = new FluentWait<WebDriver>(driver)
                .withTimeout(30, SECONDS)
                .pollingEvery(5, SECONDS)
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);

        WebElement Home = stubbornWait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[1]/a/span[1]/span/span")));
        Home.click();
        WebElement Tutorial = stubbornWait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[2]/a/span[1]/span/span")));
        Tutorial.click();
        WebElement Maven = stubbornWait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div/div/section[3]/div[2]/b[9]/a")));
        Maven.click();

        }

    @And("^click login button$")
    public void click_login_button() {


    }

    @Then("^I should see user form$")
    public void i_should_see_user_form()  {
        driver.close();
    }


}
