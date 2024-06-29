package tests.complex;

import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ShadowDomTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private Locator locator;

    @BeforeMethod
    public void precondition(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
    }

    @Test
    public void shadowDomTest1() throws InterruptedException {
        page.navigate("https://books-pwakit.appspot.com/explore?q=");
        page.locator("#input").type("Java");
        page.press("#input", "Enter");
        Thread.sleep(5_000);
    }

    @Test
    public void shadowDomTest2() throws InterruptedException {
        page.navigate("chrome://downloads/");
        page.locator("#searchInput").type("Java");
        Thread.sleep(5_000);
    }

    @AfterClass
    public void tearDown() {
        page.close();
        page.close();
        browser.close();
        playwright.close();
    }
}
