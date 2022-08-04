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
import pages.Questions;
import utilities.BrowserUtilities;
import utilities.ConfigurationReader;
import utilities.Driver;

import java.time.Duration;

public class VotingAnswersStepDef {
    Questions q1 = new Questions();

    @Given("the user is on the Questions section")
    public void the_user_is_on_the_questions_section() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        q1.accessToTheQuestionsSection();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("All Questions - Spec Overflow"));
    }

    @When("the user clicks on the first question")
    public void the_user_clicks_on_the_first_question() {
        q1.firstQuestion.click();
    }

    @And("the user clicks on the vote down button")
    public void the_user_clicks_on_the_vote_down_button() {
        BrowserUtilities.clickWithJS(q1.voteDown);
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("What is Cucumber? - Spec Overflow"));
        BrowserUtilities.waitFor(3);
    }

    @Then("the user verifies that the message {string} is displayed")
    public void theUserVerifiesThatTheMessageIsDisplayed(String expectedMessage) {
        String actualMessage = Driver.getDriver().switchTo().alert().getText();
        System.out.println("actualMessage = " + actualMessage);
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @When("the user clicks on default login section")
    public void the_user_clicks_on_default_login_section() {
        q1.loginAsDefault();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("Home - Spec Overflow"));
    }

    @And("the user clicks on the question that has been answered")
    public void the_user_clicks_on_the_question_that_has_been_answered() {
        q1.secondQuestion.click();
        new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5))
                .until(ExpectedConditions.titleIs("How to write better BDD scenarios? - Spec Overflow"));
        BrowserUtilities.waitFor(3);

    }

    @Then("the user verifies that the second answer should move up after clicking up")
    public void theUserVerifiesThatTheSecondAnswerShouldMoveUpAfterClickingUp() {
        WebElement secondAnswerVoteNumber = Driver.getDriver().findElement(By.xpath("(//div[@class='current-votes'])[3]"));
        String secondAnswerVoteNumberText = secondAnswerVoteNumber.getText();
        int secondAnswerVoteNumberDigit = Integer.parseInt(secondAnswerVoteNumberText);
        System.out.println("secondAnswerVoteNumberDigit = " + secondAnswerVoteNumberDigit);

        q1.secondAnswerVoteUp.click();
        BrowserUtilities.waitFor(3);

        WebElement secondAnswerVoteNumberUpdated = Driver.getDriver().findElement(By.xpath("(//div[@class='current-votes'])[2]"));
        String secondAnswerVoteNumberTextUpdated = secondAnswerVoteNumberUpdated.getText();
        int secondAnswerVoteNumberDigitUpdated = Integer.parseInt(secondAnswerVoteNumberTextUpdated);
        System.out.println("secondAnswerVoteNumberDigitUpdated = " + secondAnswerVoteNumberDigitUpdated);

        Assert.assertNotEquals(secondAnswerVoteNumberDigit, secondAnswerVoteNumberDigitUpdated);
    }


}

