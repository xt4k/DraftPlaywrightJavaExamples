package tests;

import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class TestLocators {

    @Test
    public void locatorsTest(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.locator("#identifierId").type("abc@ase.com");

    }

    @Test
    public void locatorsTest2(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.locator("[id='identifierId']").type("abc2@asjkj.cmm");

    }

    @Test
    public void locatorsTest3(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.type("[id='identifierId']","abc2@asjkj.cmm");

    }


    @Test
    public void locatorsTest4(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.type("[id='identifierId']","abc2@asjkj.cmm", new Page.TypeOptions().setDelay(200));

    }

    @Test
    public void locatorsTest5(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.type("id=identifierId","abc2@asjkj.cmm", new Page.TypeOptions().setDelay(200));

    }

    @Test
    public void locatorsTest6(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.type("type=email","abc2@asjkj.cmm", new Page.TypeOptions().setDelay(200));

    }

    @Test
    public void locatorsTest7(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.type("[type=email]","abc2@asjkj.cmm", new Page.TypeOptions().setDelay(200));
        page.click("text=Next");

    }

    @Test
    public void locatorsTest8(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.type("[type=email]","abc2@asjkj.cmm", new Page.TypeOptions().setDelay(200));
        page.click("button:has-text('Next')");

    }

    @Test
    public void locatorsTest9(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.type("[type=email]","vasyalogvinov777@gmail.com", new Page.TypeOptions().setDelay(100));
        page.click("button:has-text('Next')");
        page.type("[type=password]","wrong_password_1221");
        String errorText = page.locator("span.jsslot").innerText();

        System.out.println("erorr_text: "+errorText);


      //  page.click("[aria-label='Try again']");


 /*       try {
            sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

    }

    @Test
    public void locatorsTest10(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://gmail.com");

        page.type("[type=email]","vasyalogvinov777@gmail.com", new Page.TypeOptions().setDelay(50));
        page.click("button:has-text('Next')");
        page.type("[name=Passwd]","wrong_password_1221");
        page.click("button:has-text('Next')");
        String errorText = page.locator("span[jsslot]").innerText();

        System.out.println("erorr_text: "+errorText);


        //  page.click("[aria-label='Try again']");


 /*       try {
            sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

    }

    @Test
    public void locatorsTest11(){
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

        Page page = browser.newPage();
        page.navigate("https://ukr.net");

        page.frameLocator("iframe[name=\"mail widget\"]").getByLabel("Ім’я скриньки").fill("vasayivanov777@ukr.net");
        page.frameLocator("iframe[name=\"mail widget\"]").getByLabel("Ім’я скриньки").press("Enter");
        page.frameLocator("iframe[name=\"mail widget\"]").getByLabel("Пароль").click();
        page.frameLocator("iframe[name=\"mail widget\"]").getByLabel("Пароль").fill("456456");
        page.frameLocator("iframe[name=\"mail widget\"]").getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Увійти")).click();
        page.frameLocator("iframe[name=\"a-fnackfdjx772\"]").getByLabel("Я не робот").click();
        page.frameLocator("iframe[name=\"mail widget\"]").getByText("Неправильні дані").click();

     /*   page.frameLocator("iframe[name='mail widget']").get.getBy.type("input[name=login]","vasayivanov777@ukr.net");
        page.type("[name=password]","wrong_password11221122", new Page.TypeOptions().setDelay(50));
        page.click("button[type=submit]");
       page.click("#recaptcha-anchor");*/
        String errorText =  page.frameLocator("iframe[name=\"mail widget\"]").getByText("Неправильні дані").innerText();

        System.out.println("erorr_text: "+errorText);


        //  page.click("[aria-label='Try again']");


 /*       try {
            sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

    }
}
