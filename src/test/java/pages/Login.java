package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Login extends HomePage {

    public Login() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // The locators and methods are related to the Login section of the website

    @FindBy(id = "name")
    public WebElement loginUserName;

    @FindBy(id = "Password")
    public WebElement loginPassWord;

    @FindBy(id = "LoginButton")
    public WebElement loginButton;

    @FindBy(id = "LoggedInUser")
    public WebElement logName;

    @FindBy(xpath = "//h2[text()='Login']")
    public WebElement loginTitle;

}
