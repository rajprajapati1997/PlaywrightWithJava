package utils;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private static Playwright playwright;
    private static Browser browser;

    public static Page getPage() {
        if (playwright == null) {
            playwright = Playwright.create();
        }
        if (browser == null) {
            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        }
        return browser.newPage();
    }

    public static void close() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        browser = null;
        playwright = null;
    }
}
