package tests;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.lang.Thread.sleep;


public class OpenBrowserTest {

    @Test
    public void openBrowsersOnPlaywrightPageTest() {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch();
            Page page = browser.newPage();
            page.navigate("http://playwright.dev");
            System.out.println(page.title());
            page.close();
        }
    }

    @Test
    public void openChromeOnPlaywrightPageTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(false)
                );

        BrowserContext browserContext= browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));

        Page page = browserContext.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }

    @Test
    public void openChromeMaximizingOnPlaywrightPageTest() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();

        System.out.println(width+"---"+height);

        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium()
                .launch(
                        new BrowserType.LaunchOptions()
                                .setHeadless(false)
                );

        BrowserContext browserContext= browser.newContext(
                new Browser.NewContextOptions()
                        .setViewportSize((int)width, (int)height)
        );

        Page page = browserContext.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }


    @Test
    public void openChromeWithArgumentsPlaywrightPageTest() {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
                arguments.add("--start-maximized");

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setChannel("chrome")
                        .setHeadless(false)
                        .setArgs(arguments)
                );

        BrowserContext browserContext= browser.newContext( new Browser.NewContextOptions().setViewportSize((null)));

        Page page = browserContext.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }

    @Test
    public void openFirefoxWithArgumentsPlaywrightPageTest() {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Browser browser = playwright.firefox()
                .launch(new BrowserType.LaunchOptions()
                        .setChannel("firefox")
                        .setHeadless(false)
                        .setArgs(arguments)
                );

        BrowserContext browserContext= browser.newContext( new Browser.NewContextOptions().setViewportSize((null)));

        Page page = browserContext.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());
        page.close();
        playwright.close();
    }

    @Test
    public void openCustomBrowserWithArgumentsPlaywrightPageTest() {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setChannel("explorer")
                        .setHeadless(false)
                        .setExecutablePath(Paths.get(
                                "C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe"))
                              //  "C:\\Program Files\\Google\\Chrome\\Application\\new_chrome.exe"))
                                //"\"C:\\Program Files\\Internet Explorer\\iexplore.exe\""))
                        .setArgs(arguments)
                );

        BrowserContext browserContext= browser.newContext( new Browser.NewContextOptions().setViewportSize((null)));

        Page page = browserContext.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.close();
        playwright.close();
    }


    @Test
    public void openEdgeBrowserWithArgumentsPlaywrightPageTest() {
        Playwright playwright = Playwright.create();
        ArrayList<String> arguments = new ArrayList<>();
        arguments.add("--start-maximized");

        Browser browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions()
                        .setChannel("msedge")
                        .setHeadless(false)
                        .setArgs(arguments)
                );

        BrowserContext browserContext= browser.newContext( new Browser.NewContextOptions().setViewportSize((null)));

        Page page = browserContext.newPage();
        page.navigate("http://playwright.dev");
        System.out.println(page.title());

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        page.close();
        playwright.close();
    }

    @AfterClass
    void tearDown(){

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
