package stepdefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pageobjects.HomePage;
import pageobjects.RegisterPage;
import utils.PlaywrightFactory;

public class RegisterSteps {
    private static Page page;
    private HomePage homePage;
    private RegisterPage registerPage;

    // Removed open_homepage step (now in CommonSteps)
    // Removed click_link step (now in CommonSteps)
    // Removed click_button step (now in CommonSteps)

    @When("I select gender {string}")
    public void select_gender(String gender) {
        registerPage.selectGender(gender);
    }

    @When("I enter first name {string} and last name {string}")
    public void enter_names(String first, String last) {
        registerPage.enterFirstName(first);
        registerPage.enterLastName(last);
    }

    @When("I enter email {string}")
    public void enter_email(String email) {
        registerPage.enterEmail(email);
    }

    @When("I enter password {string} and confirm password {string}")
    public void enter_passwords(String pwd, String confPwd) {
        registerPage.enterPassword(pwd);
        registerPage.enterConfirmPassword(confPwd);
    }

    @Then("I should see {string} message")
    public void should_see_message(String msg) {
        Assert.assertTrue(page.isVisible(".result:has-text('" + msg + "')"));
        PlaywrightFactory.close();
    }
}
