package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.Login;
import pages.Register;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RegistrationStepDef {

    Register register = new Register();
    Login login = new Login();

    @Given("the user navigates to the home page")
    public void theUserNavigatesToTheHomePage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("the user clicks on the register page")
    public void theUserClicksOnRegisterPage() {
        register.accessToTheRegisterSection();
    }

    @And("the user attempts to register with user name {string} and password {string}")
    public void theUserAttemptsToRegisterWithUserNameAndPassword(String username, String password) {
        register.completeRegistrationProcess(username, password, password);
    }


    @And("the user clicks on the register button")
    public void theUserClicksOnRegisterButton(){
        register.clickOnRegisterButton();
        BrowserUtilities.waitFor(3);
    }

    @Then("the registration should be successful")
    public void theRegistrationShouldBeSuccessful() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Login"));
        String currentTitle = Driver.getDriver().getTitle();
        System.out.println(currentTitle);
    }

    @And("the user completes the registration process")
    public void the_user_completes_the_registration_process() {
        register.completeRegistrationProcess("Kate", "0987", "0987");
        register.registerButton.click();
    }

    @Then("the user is ready to login")
    public void the_user_is_ready_to_login() {
        String title = login.loginTitle.getText();
        Assert.assertTrue(title.contains("Login"));
    }
}
