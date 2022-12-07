package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(), 'Sign up')]")
    public WebElement signUpButton;

    public void clickSignUpButton() {
        signUpButton.click();
    }
}
