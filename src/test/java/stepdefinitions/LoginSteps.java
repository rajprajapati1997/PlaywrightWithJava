package stepdefinitions;

import com.microsoft.playwright.*;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pageobjects.HomePage;
import utils.PlaywrightFactory;

import static stepdefinitions.CommonSteps.page;
import static stepdefinitions.CommonSteps.homePage;

public class LoginSteps {

    @When("I enter email {string} and password {string}")
    public void enter_credentials(String email, String password) {
        page.fill("input#Email", email);
        page.fill("input#Password", password);
    }

    @Then("I should see {string} in the header")
    public void should_see_in_header(String text) {
        Assert.assertTrue(page.isVisible("a:has-text('" + text + "')"));
    }

    @When("I enter {string} in the search box")
    public void enter_search(String query) {
        homePage.enterSearch(query);
    }

    @Then("I should see search results for {string}")
    public void should_see_search_results(String query) {
        page.waitForSelector(".search-results");
        String resultsText = page.textContent(".search-results");
        Assert.assertTrue(resultsText != null && resultsText.toLowerCase().contains(query.toLowerCase()));
    }

    @When("I select {string} from the top menu")
    public void select_menu(String menu) {
        homePage.selectMenu(menu);
    }

    @When("I sort products by {string}")
    public void sort_products(String sortOption) {
        page.selectOption("select#products-orderby", new String[]{sortOption});
    }

    @When("I add the first book to the cart")
    public void add_first_book_to_cart() {
        page.click(".product-item .product-box-add-to-cart-button");
    }

    @Then("the shopping cart should have {int} item")
    public void cart_should_have_items(int count) {
        String cartQty = page.textContent("span.cart-qty").replaceAll("[^0-9]", "");
        Assert.assertEquals(Integer.parseInt(cartQty), count);
        PlaywrightFactory.close();
    }
}
