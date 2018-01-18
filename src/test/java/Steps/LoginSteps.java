package Steps;


import Setup.Environment_Setup;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

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
        driver.close();
    }


    @And("^I enter user name admin and password admin$")
    public void i_enter_user_name_admin_and_password_admin() {


    }

    @And("^click login button$")
    public void click_login_button() {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^I should see user form$")
    public void i_should_see_user_form()  {
        // Write code here that turns the phrase above into concrete actions
    }


}
