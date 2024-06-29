package tests.complex;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class DropDownTest {
    @Test
    public void dropDownTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://jqueryui.com/resources/demos/droppable/default.html");

        Locator drag = page.locator("#draggable");
        Locator drop = page.locator("#droppable");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        page.mouse()
                .move(
                        drag.boundingBox().x + drag.boundingBox().width/2,
                        drag.boundingBox().y + drag.boundingBox().height/2);
        page.mouse().down();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.mouse()
                .move(
                        drop.boundingBox().x + drop.boundingBox().width/2,
                        drop.boundingBox().y + drop.boundingBox().height/2);
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
