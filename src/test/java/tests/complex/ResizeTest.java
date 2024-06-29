package tests.complex;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class ResizeTest {
    @Test
    public void resizeTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://jqueryui.com/resources/demos/resizable/default.html");

        Locator pointer = page.locator("//*[@id=\"resizable\"]/div[3]");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        page.mouse()
                .move(
                        pointer.boundingBox().x + pointer.boundingBox().width/2,
                        pointer.boundingBox().y+pointer.boundingBox().height/2);
        page.mouse().down();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.mouse().move(pointer.boundingBox().x + 500, pointer.boundingBox().y+250);
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.mouse().up();

        page.close();
        page.close();
        browser.close();
        playwright.close();
    }
}
