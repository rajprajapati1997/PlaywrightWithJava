package pageobjects;

import com.microsoft.playwright.Page;

public class HomePage {
    private final Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    public void clickLoginLink() {
        page.click("a[href='/login']");
    }

    public void enterSearch(String query) {
        page.fill("input#small-searchterms", query);
    }

    public void clickSearchButton() {
        page.click("button[type='submit'][class*='search-box-button']");
    }

    public void selectMenu(String menu) {
        page.click(String.format("ul.top-menu a:has-text('%s')", menu));
    }
}
