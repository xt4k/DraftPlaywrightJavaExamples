package tests;

import com.microsoft.playwright.*;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class AlertsDialogueTest {

    @Test
    public void alertMsgTest() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        page.navigate("https://mail.rediff.com/cgi-bin/login.cgi");

        page.onDialog(dialog -> {
            System.out.println("alert msg: "+dialog.message());
            dialog.accept();
        });

        page.click(".signinbtn");
        sleep(5_000);
        System.out.println();


    }
}
