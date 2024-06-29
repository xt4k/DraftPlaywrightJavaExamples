package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class NonIncognitoTest {


    @Test
    public void openEdgeBrowserWithArgumentsPlaywrightPageTest() {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        BrowserContext browserContext = playwright.chromium().launchPersistentContext(Paths.get(""),
                new BrowserType.LaunchPersistentContextOptions()
                        //.setChannel("msedge")
                        .setHeadless(false)
                        .setExecutablePath(Paths.get("C:\\Program Files\\Google\\Chrome\\Application\\new_chrome.exe"))
                        .setArgs(arguments)
        );

        Page page = browserContext.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.close();
        playwright.close();
    }



    @Test
    public void openChromeNavigationPlaywrightPageTest() {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setArgs(arguments)
                );

        Page page = browser.newPage();
        page.navigate("http://playwright.dev");
        customSleep();
        page.navigate("http://www.google.com");
        customSleep();
        page.goBack(new Page.GoBackOptions().setTimeout(5_000));
        customSleep();
        page.goForward(new Page.GoForwardOptions().setTimeout(5_000));
        customSleep();
        page.reload();
        System.out.println(page.title());

        customSleep();

        page.close();
        playwright.close();
    }

    private void customSleep() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
