package tests.upordownLoadfiles;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.Test;

import java.nio.file.Path;
import java.nio.file.Paths;

public class TestUploadManyFiles {

    @Test
    public void uploadManyFileTest() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_multiple");

        page.frameLocator("#iframeResult").locator("#myFile").setInputFiles(new Path[]{
                Paths.get("src/test/java/tests/resources/files/tiger.jpg"),
                Paths.get("src/test/java/tests/resources/files/minions.jpg")
        });


    }

}

