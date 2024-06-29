package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

public class HandlingKeyBoardEventsTest {


    @Test
    public void keyboardEventsTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://login.yahoo.com/");


        page.locator("#login-username").type("trainer@way2automation", new Locator.TypeOptions().setDelay(300));

        page.keyboard().press("Enter");

    }
}
