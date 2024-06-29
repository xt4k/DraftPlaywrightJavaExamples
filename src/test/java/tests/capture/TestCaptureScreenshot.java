package tests.capture;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static java.lang.Thread.sleep;

public class TestCaptureScreenshot {

    @Test
    public void testCaptureThreeScreenshots(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.wikipedia.org/");
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/1.jpg")));

        page.locator("div.central-textlogo").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/2.jpg")));

        page.locator("#searchInput").fill("playwright");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.keyboard().press("Enter");
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        page.locator("a.mw-logo").screenshot(new Locator.ScreenshotOptions().setPath(Paths.get("screenshots/3.jpg")));

        page.close();
        playwright.close();
    }
}
