package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.Questions;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class VotingAnswersStepDef {
    Questions q1 = new Questions();

    @Given("the user is on the Questions section")
    public void the_user_is_on_the_questions_section() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        q1.accessToTheQuestionsSection();
        BrowserUtilities.waitFor(2);

    }

    @When("the user clicks on the first question")
    public void the_user_clicks_on_the_first_question() {
        q1.firstQuestion.click();
        BrowserUtilities.waitFor(2);
    }

    @And("the user clicks on the vote down button")
    public void the_user_clicks_on_the_vote_down_button() {
        q1.voteDown.click();
        BrowserUtilities.waitFor(2);

    }

    @Then("the pop-up message is shown")
    public void the_pop_up_message_is_shown() {
        String popUpMessage = Driver.getDriver().switchTo().alert().getText();
        System.out.println("popUpMessage = " + popUpMessage);
        Assert.assertTrue(popUpMessage.contains("login"));
    }

    @When("the user clicks on default login section")
    public void the_user_clicks_on_default_login_section() {
        q1.loginAsDefault();
        BrowserUtilities.waitFor(2);
    }

    @And("the user clicks on the question that has been answered")
    public void the_user_clicks_on_the_question_that_has_been_answered() {
        q1.secondQuestion.click();
        BrowserUtilities.waitFor(2);
    }

    @Then("the user verifies that the second answer should move up after clicking up")
    public void theUserVerifiesThatTheSecondAnswerShouldMoveUpAfterClickingUp() {
        WebElement secondAnswerVoteNumber = Driver.getDriver().findElement(By.xpath("(//div[@class='current-votes'])[3]"));
        String secondAnswerVoteNumberText = secondAnswerVoteNumber.getText();
        int secondAnswerVoteNumberDigit = Integer.parseInt(secondAnswerVoteNumberText);
        System.out.println("secondAnswerVoteNumberDigit = " + secondAnswerVoteNumberDigit);

        q1.secondAnswerVoteUp.click();
        BrowserUtilities.waitFor(2);

        WebElement secondAnswerVoteNumberUpdated = Driver.getDriver().findElement(By.xpath("(//div[@class='current-votes'])[2]"));
        String secondAnswerVoteNumberTextUpdated = secondAnswerVoteNumberUpdated.getText();
        int secondAnswerVoteNumberDigitUpdated = Integer.parseInt(secondAnswerVoteNumberTextUpdated);
        System.out.println("secondAnswerVoteNumberDigitUpdated = " + secondAnswerVoteNumberDigitUpdated);

        Assert.assertNotEquals(secondAnswerVoteNumberDigit, secondAnswerVoteNumberDigitUpdated);
    }
}

