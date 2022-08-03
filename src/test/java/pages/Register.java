package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Register extends HomePage {

    public Register() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // The locators and methods are related to the Register section of the website

    @FindBy(id = "UserName")
    public WebElement registerUserName;

    @FindBy(id = "Password")
    public WebElement registerPassWord;

    @FindBy(xpath = "//input[@id='PasswordReEnter']")
    public WebElement registerReEnterPassWord;

    @FindBy(id = "RegisterButton")
    public WebElement registerButton;

    public void clickOnRegisterButton(){
        registerButton.click();
    }

    public void completeRegistrationProcess(String userName, String password, String password2){
        registerUserName.sendKeys(userName);
        registerPassWord.sendKeys(password);
        registerReEnterPassWord.sendKeys(password2);
    }
}
