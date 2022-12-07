package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"email\" and @required=\"required\"]")
    public WebElement emailField;

    @FindBy(xpath = "//span[contains(text(), 'continue')]")
    public WebElement continueButton;

    @FindBy(xpath = "//input[@name=\"password\" and @required=\"required\"]")
    public WebElement passwordField;

    @FindBy(xpath = "//span[contains(text(), 'sign up to begin shopping')]")
    public WebElement signUpButton;

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignUp() {
        signUpButton.click();
    }
}
