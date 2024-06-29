package tests.complex;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class SlidersTest {
    @Test
    public void SliderTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();

        page.navigate("https://jqueryui.com/resources/demos/slider/default.html");



        Locator slider = page.locator("//*[@id=\"slider\"]/span");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        page.mouse().move(slider.boundingBox().x + slider.boundingBox().width/2, slider.boundingBox().y+slider.boundingBox().height/2);
        page.mouse().down();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        page.mouse().move(slider.boundingBox().x + 500, slider.boundingBox().y+slider.boundingBox().height/2);
        try {
            Thread.sleep(4000);
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
