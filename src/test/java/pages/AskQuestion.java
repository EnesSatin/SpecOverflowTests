package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.BrowserUtilities;
import utilities.Driver;

public class AskQuestion extends HomePage {

    public AskQuestion() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // The locators and methods are related to the Ask Question section of the website

    @FindBy(id = "TitleInput")
    public WebElement title;

    @FindBy(id = "BodyInput")
    public WebElement body;

    @FindBy(id = "Tags")
    public WebElement tags;

    @FindBy(xpath = "//input[@value='Post your question']")
    public WebElement postButton;

    @FindBy(xpath = "//div[text()='Not logged in']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[text()='Title and Body cannot be empty']")
    public WebElement errorMessage2;

    public void completeAskQuestionProcess(String text1, String text2, String text3) {
        title.sendKeys(text1);
        BrowserUtilities.waitFor(2);
        body.sendKeys(text2);
        BrowserUtilities.waitFor(2);
        tags.sendKeys(text3);
        BrowserUtilities.waitFor(2);
        postButton.click();
        BrowserUtilities.waitFor(2);
    }

}
