package pageobjects;

import com.microsoft.playwright.Page;

public class RegisterPage {
    private final Page page;

    public RegisterPage(Page page) {
        this.page = page;
    }

    public void selectGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            page.check("input#gender-male");
        } else {
            page.check("input#gender-female");
        }
    }

    public void enterFirstName(String firstName) {
        page.fill("input#FirstName", firstName);
    }

    public void enterLastName(String lastName) {
        page.fill("input#LastName", lastName);
    }

    public void enterEmail(String email) {
        page.fill("input#Email", email);
    }

    public void enterPassword(String password) {
        page.fill("input#Password", password);
    }

    public void enterConfirmPassword(String password) {
        page.fill("input#ConfirmPassword", password);
    }

    public void clickRegisterButton() {
        page.click("button#register-button");
    }

    public boolean isRegistrationSuccess() {
        return page.isVisible(".result:has-text('Your registration completed')");
    }
}
