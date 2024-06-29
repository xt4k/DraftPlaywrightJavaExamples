package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.List;

public class LinksTest {

    @Test
    public void getLinksTest() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://wikipedia.org/");


        Locator links = page.locator("a");

        for (int i = 0; i < links.count(); i++) {

            System.out.println("text: " + links.nth(i).innerText() + "  ;  url: " + links.nth(i).getAttribute("href"));

        }
    }

    @Test
    public void getLinksInBlockTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://wikipedia.org/");


        Locator links = page.locator(".other-projects").locator("a");

        System.out.println("links in block: "+ links.count());

        for (int i = 0; i < links.count(); i++) {

            System.out.println("text: " + links.nth(i).innerText() + "  ;  url: " + links.nth(i).getAttribute("href"));

        }
    }



}
