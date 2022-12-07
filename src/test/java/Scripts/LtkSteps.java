package Scripts;

import Pages.CategoriesPage;
import Pages.DiscoverPage;
import Pages.MainPage;
import Pages.SignUpPage;
import Utils.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class LtkSteps {
    WebDriver driver;

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver = Driver.getDriver();
        driver.get(url);
    }

    @When("user clicks Sign Up button")
    public void userClicksSignUpButton() {
        driver = Driver.getDriver();
        new MainPage(driver).clickSignUpButton();
    }

    private String randomizeEmail(String email) {
        int randomInt = new Random().nextInt(1000);
        return randomInt + email;
    }

    @And("user signs up with email {string} and {string} as password")
    public void userSignsUpWithEmailAndAsPassword(String email, String password) {
        driver = Driver.getDriver();
        SignUpPage signUpPage = new SignUpPage(driver);
        // randomize email to lessen a possibility of a duplicate
        String randomizedEmail = this.randomizeEmail(email);
        signUpPage.enterEmail(randomizedEmail);
        signUpPage.clickContinue();
        signUpPage.enterPassword(password);
        signUpPage.clickSignUp();
    }

    @Then("user is redirected to the discover page")
    public void userIsRedirectedToTheDiscoverPage() throws InterruptedException {
        driver = Driver.getDriver();
        DiscoverPage discoverPage = new DiscoverPage(driver);
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(), discoverPage.getUrl());
    }

    @Given("user is signed up")
    public void userIsSignedUp() {
        driver = Driver.getDriver();
        boolean isLoggedIn = new DiscoverPage(driver).isUserLoggedIn();
        Assert.assertTrue(isLoggedIn);
    }

    @When("user selects the Shop navigation menu")
    public void userSelectsTheShopNavigationMenu() {
        driver = Driver.getDriver();
        new DiscoverPage(driver).clickShopButton();
    }

    @Then("user is presented with the styles categories")
    public void userIsPresentedWithTheStylesCategories() {
        driver = Driver.getDriver();
        CategoriesPage categoriesPage = new CategoriesPage(driver);
        List<WebElement> categoryList = categoriesPage.getCategoryList();
        Assert.assertEquals(26, categoryList.size());
    }
}
