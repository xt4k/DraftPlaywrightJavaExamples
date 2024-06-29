package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.SelectOption;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;

public class DropDownListTest {

    @Test
    public void handlingDropDownTest() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://wikipedia.org/");

        page.selectOption("select", "Eesti");
        try {
            sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("selected 1: " + page.textContent("#jsLangLabel"));


        page.selectOption("select", "mk");
        try {
            sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("selected 2: " + page.textContent("#jsLangLabel"));


        page.selectOption("select", new SelectOption().setLabel("Esperanto"));
        try {
            sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("selected 3: " + page.textContent("#jsLangLabel"));

        page.selectOption("select", new SelectOption().setIndex(8));
        try {
            sleep(3_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("selected 4: " + page.textContent("#jsLangLabel"));

        Locator values = page.locator("select > option");

        System.out.println("languages count:"+values.count());

        for(int i =0 ; i<values.count();i++) {
            System.out.println(values.nth(i).innerText() + "~~~" +values.nth(i).getAttribute("lang"));
        }

    }

    @Test
    public void handlingDropDownTestQuery() throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://wikipedia.org/");

        List<ElementHandle> elements = page.querySelectorAll("select > option");
        for (ElementHandle element : elements) {
            System.out.println("el "+element.innerText() + " ~~~  "+element.getAttribute("lang"));
        }




    }



}
