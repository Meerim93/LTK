package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DiscoverPage {

    @FindBy(xpath = "//a/span[contains(text(), 'Shop')]")
    public WebElement shopButton;

    @FindBy(xpath = "//button[@aria-label='menu']")
    public WebElement userMenuButton;

    @FindBy(xpath = "//a[@href='/logout']")
    public WebElement logOutButton;

    private WebDriver driver;
    private final static String URL = "https://www.shopltk.com/home/for-you";

    public DiscoverPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrl() {
        return URL;
    }

    public void clickShopButton() {
        shopButton.click();
    }

    public boolean isUserLoggedIn() {
        Actions action = new Actions(driver);
        // Hover over the user menu button
        action.moveToElement(userMenuButton).perform();
        return logOutButton.isDisplayed();
    }
}
