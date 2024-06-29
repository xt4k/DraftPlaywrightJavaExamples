package tests.complex;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class MouseOverTest {
    @Test
    public void TabTest() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.way2automation.com");

        page.locator("//*[@id=\"menu-item-27580\"]/a/span[2]").hover();
        page.locator("//*[@id=\"menu-item-27592\"]/a").click();

        sleep(5_000);

        page.close();
        page.close();
        browser.close();
        playwright.close();


    }
}
