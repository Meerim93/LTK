package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoriesPage {

    @FindBy(xpath = "//h2[contains(text(), 'LTK Categories')]/following-sibling::div/div/div/div")
    public List<WebElement> categoryList;

    public CategoriesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getCategoryList() {
        return categoryList;
    }
}
