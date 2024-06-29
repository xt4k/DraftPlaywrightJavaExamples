package tests.upordownLoadfiles;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import java.nio.file.Paths;

public class TestDownloadFile {

    @Test
    public void downloadFileTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_a_download");


        Download file = page.waitForDownload(() -> {
            page.locator("#iframewrapper").frameLocator("#iframeResult").locator("body > p:nth-child(3) > a > img").click();
        });


        file.saveAs(Paths.get("src/test/java/tests/resources/files/download/w3school.jpg"));
    }
}
