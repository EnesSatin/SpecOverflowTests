package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AskQuestion;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

public class AskingQuestionsStepDef {

    AskQuestion askQuestion = new AskQuestion();


    @Given("the user is on the home page")
    public void the_user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("the user clicks on Ask Question section")
    public void the_user_clicks_on_ask_question_section() {
        askQuestion.accessToTheAskQuestionSection();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("Ask a Question - Spec Overflow"));
    }

    @And("the user fills out the required fields")
    public void the_user_fills_out_the_required_fields() {
        askQuestion.completeAskQuestionProcess("Java", "Tell me names of Object Oriented principles", "OOP");
    }

    @Then("the user needs to be logged in")
    public void the_user_needs_to_be_logged_in() {
        WebElement errorMessage = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("ErrorMessage")));
        String message = errorMessage.getText();
        System.out.println("message = " + message);
        Assert.assertTrue(message.contains("Not logged in"));
    }

    @And("the user does not complete the required fields in the asking question section")
    public void theUserDoesNotCompleteTheRequiredFieldsInTheAskingQuestionSection() {
        askQuestion.completeAskQuestionProcess("Tell me about your locator strategy in UI automation please?", " ", "Locators");
    }

    @Then("the user needs to fill out mandatory fields")
    public void theUserNeedsToFillOutMandatoryFields() {
        WebElement errorMessage2 = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("ErrorMessage")));
        String message2 = errorMessage2.getText();
        System.out.println("message2 = " + message2);
        Assert.assertTrue(errorMessage2.isDisplayed());
    }
}
