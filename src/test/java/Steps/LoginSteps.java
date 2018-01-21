package Steps;


import Setup.Environment_Setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        try {
            WebElement Home = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[1]/a/span[1]/span/span"));
            Home.click();
        }
        catch(StaleElementReferenceException ex)
        {
            WebElement Home = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[1]/a/span[1]/span/span"));
            Home.click();
        }

        try {
            WebElement Tutorial = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[2]/a/span[1]/span/span"));
            Tutorial.click();
        }
        catch(StaleElementReferenceException ex)
        {
            WebElement Tutorial = driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[1]/a/span[1]/span/span"));
            Tutorial.click();
        }

        try {
            WebElement Maven = driver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div/div/section[3]/div[2]/b[9]/a"));
            Maven.click();
        }
        catch(StaleElementReferenceException ex)
        {
            WebElement Maven = driver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div/div/section[3]/div[2]/b[9]/a"));
            Maven.click();
        }

   /*     WebElement Home = stubbornWait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[1]/a/span[1]/span/span")));
        Home.click();
        WebElement Tutorial = stubbornWait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("/html/body/div[1]/div[1]/header/nav/ul/li[2]/a/span[1]/span/span")));
        Tutorial.click();
        WebElement Maven = stubbornWait.until((Function<WebDriver, WebElement>) driver -> driver.findElement(By.xpath("/html/body/div[1]/footer/div[1]/div/div/section[3]/div[2]/b[9]/a")));
        Maven.click();*/

        }

    @And("^click login button$")
    public void click_login_button() {


    }

    @Then("^I should see user form$")
    public void i_should_see_user_form()  {
        driver.close();
    }


}
