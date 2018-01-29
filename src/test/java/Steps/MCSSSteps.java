package Steps;

import Setup.Common;
import Runner.FirefoxTestRunner;
import Setup.Environment_Setup;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static Setup.Environment_Setup.driver;
import static org.junit.Assert.assertEquals;


public class MCSSSteps {

    Environment_Setup env = new Environment_Setup();
    Common common = new Common();
    String accountID;

    @Given("^Login with contact ID \"([^\"]*)\"$")
    public void loginWithContactID(String contactID) {
   WebElement contactIDField = driver.findElement(By.xpath(" /html/body/center/div/div[2]/div[2]/form/table/tbody/tr[11]/td[2]/input"));
   contactIDField.sendKeys(contactID);
   common.safeClickOnElement(driver,By.xpath("/html/body/center/div/div[2]/div[2]/form/table/tbody/tr[20]/td/input"));

    }

    @And("^Select account \"([^\"]*)\" in selection page$")
    public void selectAccountInSelectionPage(String accountID) {
        common.safeClickOnElement(driver, By.xpath("//*[@id=\"" + accountID.substring(1,9) + "\"]"));
        }

    @Then("^Verify the account \"([^\"]*)\" in landing page$")
    public void verifyTheAccountInLandingPage(String accountID) {
        WebElement displayAcc = common.safeFindElement(driver,By.xpath("//*[@id=\"uniform-view386\"]/span"));
        assertEquals(displayAcc.getText(),accountID);
    }

    @And("^Click on Account Settings$")
    public void clickOnAccountSettings() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Expand Addresses$")
    public void expandAddresses() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Click on Edit Email Address$")
    public void clickOnEditEmailAddress() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Fill all the mandatory address fields$")
    public void fillAllTheMandatoryAddressFields() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^Click on Save button$")
    public void clickOnSaveButton() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
