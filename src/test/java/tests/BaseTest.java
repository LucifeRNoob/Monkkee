package tests;

import factorydriver.DriverFactory;
import factorydriver.DriverManager;
import factorydriver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.LoginPage;
import utilities.PropertiesManager;

public class BaseTest {

    PropertiesManager propertiesManager = new PropertiesManager();
    String user = System.getenv().getOrDefault("MONKKEE_USER", propertiesManager.get("monkkee.user"));
    String password = System.getenv().getOrDefault("MONKKEE_USER", propertiesManager.get("monkkee.password"));

    WebDriver driver;
    DriverManager driverManager;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.CHROME);
        driverManager.createDriver();
        driver = driverManager.getDriver();
        driverManager.maximize();
        driverManager.setTimeout();
        loginPage = new LoginPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterMethod
    public void closeDriver() {
        driverManager.quitDriver();
    }
}
