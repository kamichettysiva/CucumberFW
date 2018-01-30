package Steps;

import Setup.Common;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static Setup.Environment_Setup.driver;
import static org.junit.Assert.assertEquals;


public class MCSSSteps {
    Common common = new Common();


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
    public void clickOnAccountSettings() {
        common.safeClickOnElement(driver, By.xpath("//*[@id=\"MyAccountProfile\"]/span/span"));
    }

    @And("^Expand Addresses$")
    public void expandAddresses(){
        WebElement Addresses = driver.findElement(By.xpath("//*[@id=\"ui-id-1\"]/span[2]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Addresses);
        Addresses.click();
        }

    @And("^Click on Edit Mail Address$")
    public void clickOnEditMailAddress() {
        common.safeClickOnElement(driver, By.xpath("//*[@id=\"mailing\"]"));
    }

    @And("^Fill all the mandatory address fields$")
    public void fillAllTheMandatoryAddressFields(){
        //Select Dwelling_type = new Select(driver.findElement(By.xpath("//*[@id=\"editAddressForm\"]/div[1]/ul[3]/div/fieldset/span/div[2]")));
        //Dwelling_type.selectByVisibleText("bungalow");
        WebElement House_num = driver.findElement(By.xpath("//*[@id=\"view542\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", House_num);
        House_num.sendKeys("1-3-5");
        WebElement Building_Name = driver.findElement(By.xpath("//*[@id=\"view544\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Building_Name);
        Building_Name.sendKeys("Desa Green");
        WebElement Addr1 = driver.findElement(By.xpath("//*[@id=\"view548\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", Addr1);
        Addr1.sendKeys("Jalan Desa Bakti");
        WebElement PostCode = driver.findElement(By.xpath("//*[@id=\"view552\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", PostCode);
        PostCode.sendKeys("58000");

    }

    @And("^Click on Save button$")
    public void clickOnSaveButton() {
       driver.findElement(By.xpath("//*[@id=\"editAddressForm\"]/div[1]/ul[15]/a/span")).click();
    }


}
