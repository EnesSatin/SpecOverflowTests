package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.BrowserUtilities;
import utilities.Driver;

import java.time.Duration;

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

    public void completeAskQuestionProcess(String text1, String text2, String text3) {
        title.sendKeys(text1);
        body.sendKeys(text2);
        tags.sendKeys(text3);
        postButton.click();
    }
}
