package tests;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TabsAndPopupTest {
    @Test
    public void TabTest() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://sso.teachable.com/secure/673/identity/sign_up/routing");

       Page policyPage = page.waitForPopup(()-> page.locator("[aria-label=\"Way2Automation's Privacy Policy\"]").click());

        sleep(5_000);

        System.out.println("text on button: "+ policyPage.title() );
        System.out.println("title of text: "+ policyPage.locator("h2").innerText());

        policyPage.close();
        page.close();
        browser.close();
        playwright.close();


    }
}
