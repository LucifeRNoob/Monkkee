package tests;

import factorydriver.DriverFactory;
import factorydriver.DriverManager;
import factorydriver.DriverType;
import models.EntryFaker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.EntriesPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SettingPage;
import utilities.PropertiesManager;
import utilities.TestListener;

import java.net.MalformedURLException;

@Listeners(TestListener.class)
public class BaseTest {

    PropertiesManager propertiesManager = new PropertiesManager();
    String user = System.getenv().getOrDefault("MONKKEE_USER", propertiesManager.get("monkkee.user"));
    String password = System.getenv().getOrDefault("MONKKEE_USER", propertiesManager.get("monkkee.password"));

    WebDriver driver;
    DriverManager driverManager;
    LoginPage loginPage;
    EntriesPage entriesPage;
    SettingPage settingPage;
    HomePage homePage;
    EntryFaker faker = new EntryFaker();
    String entryTextFaker = faker.RandomEntryText();

    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser) throws MalformedURLException {
        DriverFactory factory = new DriverFactory();
        DriverType driverType = null;
        if(browser.equals("chrome")) {
            driverType = DriverType.CHROME;
        }
        else if(browser.equals("firefox")){
            driverType = DriverType.MOZILLA;
        }
        driverManager = factory.getManager(driverType);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
        loginPage = new LoginPage(driver);
        entriesPage = new EntriesPage(driver);
        settingPage = new SettingPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void closeDriver() {
        driverManager.quitDriver();
    }
}
