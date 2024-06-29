package tests.capture;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TestTraceViewer {

    @Test
    public void testTraceViewer() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext();

        context.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));

        Page page = context.newPage();
        page.navigate("http://gmail.com");
        page.locator("[type=email]").type("trainer@way2automation.com");
        page.click("button:has-text('Next')");
        page.locator("[type=password]").fill("sdfsdfdsf");
        page.click("button:has-text('Next')");

        // Stop tracing and export it into a zip archive.
        context.tracing().stop(new Tracing.StopOptions()
                .setPath(Paths.get("Tracing/trace.zip")));

        page.close();
        context.close();
        playwright.close();
    }
}
