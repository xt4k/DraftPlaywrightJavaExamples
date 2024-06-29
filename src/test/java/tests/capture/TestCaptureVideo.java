package tests.capture;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.List;

import static java.lang.Thread.sleep;

public class TestCaptureVideo {

    @Test
    public void testCaptureVideo(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("videos/")));
        Page page = context.newPage();
        page.navigate("https://www.wikipedia.org/");


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


        page.close();
        context.close();
        playwright.close();
    }
}
