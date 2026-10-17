package tests;

import api.RoomApi;
import base.BaseTest;
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.LoadState;
import config.TestConfig;
import data.RoomExistingData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginFunctionality;

public class TestRoomApi{
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext browserContext;
    protected Page page;

    @BeforeMethod
    public void setup()
    {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions());
        page = browserContext.newPage();
        page.navigate(TestConfig.BASE_URL+"/admin");
        page.waitForLoadState();
    }

    @AfterMethod
    public void teardown()
    {
        if(browserContext!=null) browserContext.close();
        if(browser!=null) browser.close();
        if(playwright!=null) playwright.close();
    }
    @Test
    public void createdRoomCanBeFoundDeleted()
    {
        RoomExistingData roomExistingData = new RoomExistingData();

        LoginFunctionality loginPage = new LoginFunctionality(page);
        loginPage.performLogin("admin","password");
//        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
//        LOAD => DOMCONTENTLOADED => NETWORKIDLE;
        RoomApi roomApi = new RoomApi(page);
        APIResponse created = roomApi.createRoom(roomExistingData);
        Assert.assertEquals(created.status(), 200);
        Assert.assertEquals(created.statusText(), "OK");
        Assert.assertTrue(created.ok());
        Assert.assertTrue(created.text().toLowerCase().contains("success"));
    }
}
