package tests;

import factorydriver.DriverFactory;
import factorydriver.DriverManager;
import factorydriver.DriverType;
import models.EntryFaker;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.EntriesPage;
import pages.LoginPage;
import utilities.PropertiesManager;
import utilities.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    PropertiesManager propertiesManager = new PropertiesManager();
    String user = System.getenv().getOrDefault("MONKKEE_USER", propertiesManager.get("monkkee.user"));
    String password = System.getenv().getOrDefault("MONKKEE_USER", propertiesManager.get("monkkee.password"));

    WebDriver driver;
    DriverManager driverManager;
    LoginPage loginPage;
    EntriesPage entriesPage;
    EntryFaker faker = new EntryFaker();
    String entryTextFaker = faker.RandomEntryText();

    @BeforeClass
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
        loginPage = new LoginPage(driver);
        entriesPage = new EntriesPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass
    public void closeDriver() {
        driverManager.quitDriver();
    }
}
