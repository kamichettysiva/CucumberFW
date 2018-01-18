package Steps;


import Setup.Environment_Setup;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
    public static WebDriver driver;

    Environment_Setup env = new Environment_Setup();


    @Given("^I navigate to login page$")
    public void i_navigate_to_login_page() {
        driver = env.driver("firefox");
        System.out.println("lala");
        driver.get("http://www.toolsqa.com");
        driver.close();
        }

    @And("^I enter user name admin and password admin$")
    public void i_enter_user_name_admin_and_password_admin() {
        driver = env.driver("chrome");
        driver.navigate().to("http://google.com");
        driver.close();

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
