package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Questions extends HomePage {

    public Questions() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // The locators and methods are related to the Questions' section of the website

    @FindBy(css = "#Questions li:nth-of-type(1) .body a")
    public WebElement firstQuestion;

    @FindBy(css = "#Questions li:nth-of-type(2) .body a")
    public WebElement secondQuestion;

    @FindBy(css = "#Questions li:nth-of-type(3) .body a")
    public WebElement thirdQuestion;

    @FindBy(xpath = "//textarea[@id='AnswerContent']")
    public WebElement answerBox;

    @FindBy(xpath = "//input[@id='PostAnswerButton']")
    public WebElement postYourAnswer;

    @FindBy(id = "QuestionVoteUp")
    public WebElement voteUp;

    @FindBy(id = "QuestionVoteDown")
    public WebElement voteDown;

    @FindBy(xpath = "(//button[@class='vote-up'])[3]")
    public WebElement secondAnswerVoteUp;


}
