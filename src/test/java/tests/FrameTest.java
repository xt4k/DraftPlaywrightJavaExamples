package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

public class FrameTest {
    @Test
    public void alertMsgTest() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_submit_get");

        System.out.println("text on button: " + page.frameLocator("#iframeResult").locator("#demo").innerText());

        page.frameLocator("#iframeResult").locator("body > button").click();

        String text = page.frameLocator("#iframeResult").locator("#demo").innerText();

        System.out.println("text on button: " + text);


    }
}
