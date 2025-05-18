package stepdefinitions;

import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageobjects.HomePage;
import utils.PlaywrightFactory;

public class CommonSteps {
    public static Page page;
    public static HomePage homePage;

    @Given("I open the nopCommerce demo homepage")
    public void open_homepage() {
        page = PlaywrightFactory.getPage();
        page.navigate("https://demo.nopcommerce.com/");
        homePage = new HomePage(page);
    }

    @When("I click on the {string} link")
    public void click_link(String link) {
        page.click("a:has-text('" + link + "')");
    }

    @When("I click the {string} button")
    public void click_button(String button) {
        page.click("button:has-text('" + button + "')");
    }
}
