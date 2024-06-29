package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

public class TestJavaScriptEvaluate {

    @Test
    public void jsEvaluateTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("http://google.com");


        System.out.println(page.evaluate("document.location.href"));


        page.evaluate("() => {"
                + "const textarea = document.createElement('textarea');"
                + "document.body.append(textarea);"
                + "textarea.focus();"
                +"}");

        String text = "Hello World !!";
        page.keyboard().type(text);

    }
}
