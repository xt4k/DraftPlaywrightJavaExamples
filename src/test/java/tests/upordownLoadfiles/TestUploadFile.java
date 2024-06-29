package tests.upordownLoadfiles;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TestUploadFile {

    @Test
    public void uploadFileTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.way2automation.com/way2auto_jquery/registration.php#load_box");

        page.locator("#register_form > fieldset:nth-child(9) > input[type=file]").setInputFiles(Paths.get("src/test/java/tests/resources/files/tiger.jpg"));


    }
}
