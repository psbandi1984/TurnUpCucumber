package StepDefinitions;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.TM_Page;
import Utilities.CommonDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TM_StepDefinitions extends CommonDriver {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    TM_Page tmPage = new TM_Page();


    @Before
    public void setUP(){

        driver = new ChromeDriver();

    }

    @Given("I log into Turnup portal")
    public void iLogIntoTurnupPortal() {


        loginPage.LoginSteps(driver);
        
    }

    @When("I navigate to Time and Material page")
    public void iNavigateToTimeAndMaterialPage() {

        homePage.GoToTMPage(driver);

    }

    @And("I create a new Time and Material record {string} {string} {string}")
    public void iCreateANewTimeAndMaterialRecordCodeMouse(String code, String description, String price) {

        tmPage.CreateTimeRecord(driver, code,"M", description, price);
        
    }

    @Then("the record should be saved {string} {string} {string}")
    public void theRecordShouldBeSavedCode(String code, String description, String price) {

        tmPage.CreateTMAssertion(driver, code,"M", description, price);

    }

    @And("I edit an existing Time and Material record {string} {string} {string}")
    public void iEditAnExistingTimeAndMaterialRecordOldCodeNewCode(String code, String description, String price) {

       tmPage.EditTimeRecord(driver, code,"M", description, price);

    }

    @Then("the record should be updated {string} {string} {string}")
    public void theRecordShouldBeUpdatedNewCode(String code, String description, String price) {

        tmPage.EditTMAssertion(driver, code,"T", description, price );

    }

    @And("I delete an existing Time and Material record {string}")
    public void iDeleteAnExistingTimeAndMaterialRecordCode(String code) {


        
    }

    @Then("the record should be deleted {string}")
    public void theRecordShouldBeDeletedTime(String code) {
    }


    @After
    public void tearDown(){

        driver.quit();
    }


}
