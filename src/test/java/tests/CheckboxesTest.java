package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class CheckboxesTest {

    @Test
    public void checkboxesListTest() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.ironspider.ca/forms/checkradio.htm");

        Locator checkboxes = page.locator("[type='checkbox']");
        System.out.println("checkboxes: "+ checkboxes.count());
        for (int i = 0; i < checkboxes.count(); i++) {
            System.out.println("text: " + checkboxes.nth(i).innerText() + "  ;  url: " + checkboxes.nth(i).getAttribute("value"));
            checkboxes.nth(i).click();

        }

        sleep(5_000);

        page.close();

        browser.close();


    }



}
