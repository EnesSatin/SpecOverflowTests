package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AskQuestion;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

public class AskingQuestionsStepDef {

    AskQuestion askQuestion = new AskQuestion();


    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("the user clicks on Ask Question section")
    public void the_user_clicks_on_ask_question_section() {
        askQuestion.accessToTheAskQuestionSection();
        BrowserUtilities.waitFor(3);
    }

    @And("the user fills out the required fields")
    public void the_user_fills_out_the_required_fields() {
        askQuestion.completeAskQuestionProcess("Java", "Tell me names of Object Oriented principles", "OOP");
    }

    @Then("the user needs to be logged in")
    public void the_user_needs_to_be_logged_in() {
        String message = askQuestion.errorMessage.getText();
        System.out.println("message = " + message);
        Assert.assertTrue(message.contains("Not logged in"));
    }

    @And("the user does not complete the required fields in the asking question section")
    public void theUserDoesNotCompleteTheRequiredFieldsInTheAskingQuestionSection() {
        askQuestion.completeAskQuestionProcess("Tell me about your locator strategy in UI automation please?", " ", "Locators");
    }

    @Then("the user needs to fill out mandatory fields")
    public void theUserNeedsToFillOutMandatoryFields() {
        String errorMessage = askQuestion.errorMessage2.getText();
        System.out.println("errorMessage = " + errorMessage);
        Assert.assertTrue(askQuestion.errorMessage2.isDisplayed());
    }
}
