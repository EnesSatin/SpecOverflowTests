package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public abstract class HomePage {

    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // The locators and methods are related to the Home Page of the website

    @FindBy(xpath = "//a[text()='Spec Overflow']")
    public WebElement SpecOverflowLogo;

    @FindBy(xpath = "//a[text()='Home']")
    public WebElement home;

    @FindBy(xpath = "//a[text()='Questions']")
    public WebElement questions;

    @FindBy(xpath = "//a[text()='Ask Question']")
    public WebElement askQuestion;

    @FindBy(xpath = "//a[text()='Login']")
    public WebElement login;

    @FindBy(xpath = "//a[text()='Register']")
    public WebElement register;

    @FindBy(xpath = "//a[@onclick='resetData()']")
    public WebElement resetData;

    @FindBy(xpath = "//a[@onclick='defaultLogin()']")
    public WebElement defaultLogin;

    public void accessToTheRegisterSection() {
        register.click();
    }

    public void accessToTheAskQuestionSection() {
        askQuestion.click();
    }

    public void accessToTheQuestionsSection() {
        questions.click();
    }

    public void loginAsDefault() {
        defaultLogin.click();
    }
}
