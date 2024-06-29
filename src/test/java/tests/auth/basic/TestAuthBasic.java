package tests.auth.basic;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TestAuthBasic {

    @Test
    public void testBasicAuth(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext context = browser.newContext(new Browser.NewContextOptions().setHttpCredentials("admin", "admin"));
        Page page = context.newPage();
        page.navigate("http://the-internet.herokuapp.com/basic_auth");
    }
}
