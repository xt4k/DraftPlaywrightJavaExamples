package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestWebTable {

    @Test
    public void testWebTable(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://money.rediff.com/indices/nse/NIFTY-50?src=moneyhome_nseIndices");

        System.out.println(page.locator(".dataTable > tbody").locator("tr").count());
        System.out.println(page.locator(".dataTable > tbody").locator("tr:first-child").locator("td").count());

        assertThat(page.locator(".dataTable > tbody").locator("tr:first-child").locator("td:nth-child(2)")).hasText("Nifty");
        page.locator(".dataTable > tbody").allInnerTexts().forEach(text -> System.out.println(text));

    }
}
