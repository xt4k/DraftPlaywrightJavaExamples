package tests.pw_assertions;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class TestPwAssertions {

    @Test
    public void testPwAssertions() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("http://www.tizag.com/htmlT/htmlcheckboxes.php");


        assertThat(page).hasURL("http://www.tizag.com/htmlT/htmlcheckboxes.php");

        assertThat(page).hasTitle("HTML Tutorial - Checkboxes");

        assertThat(page.locator("#menu > a:nth-child(29)")).hasText("HTML - Tags");

        assertThat(page.locator("//div[@class='display'][2]//input[1]")).isChecked();
        assertThat(page.locator("//div[@class='display'][2]//input[1]")).isVisible();
        assertThat(page.locator("//div[@class='display'][2]//input[2]")).hasAttribute("value","football");
        page.close();
        browser.close();
        playwright.close();

    }
}
