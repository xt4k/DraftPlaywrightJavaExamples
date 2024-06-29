package tests.assignments;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.IntStream;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
import static java.lang.System.*;


public class TestMyTripMake {

    @Test
    public void testFlyNyLonRoute() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://www.makemytrip.com/");

        page.locator("#fromCity").click();
        page.locator("//input[@placeholder='From']").fill("New York");
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");

        page.locator("#toCity").click();
        page.locator("//input[@placeholder='To']").fill("London");
        page.keyboard().press("ArrowDown");
        page.keyboard().press("Enter");


        page.locator("//div[@class='DayPicker']")
                .locator("//div[@class='DayPicker-Month'][2]")
                .locator("//div[@class='DayPicker-Week'][3]")
                .locator("//div[@class='DayPicker-Day'][4]")
                .click();

        page.locator("//p[@data-cy='submit']//a").click();
        assertThat(page.locator("div.fillingLoader")).isVisible();
        assertThat(page.locator("div.fillingLoader")).isHidden();

        Locator flights = page.locator("div[class^='listingCard']")
                .locator("div[class='makeFlex spaceBetween ']");

        List<String> airLineNames = flights.locator("p[class='boldFont blackText airlineName']").allInnerTexts();
        List<String> flyCodes = flights.locator("p.fliCode").allInnerTexts();
        List<String> flyPrices = flights.locator("div[class$='clusterViewPrice']")
                .locator("span")
                .allInnerTexts();

        for (int i = 0; i < flyPrices.size(); i++)
            out.printf("airLine: `%s`; flights: `%s`, price: `%s`;%n", airLineNames.get(i), flyCodes.get(i), flyPrices.get(i));
    }
}
