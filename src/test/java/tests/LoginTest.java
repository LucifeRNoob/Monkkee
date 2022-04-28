package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test(priority = 1)
    @Description("Check login with valid user and password")
    public void loginTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Checking that entries page is opened");
        Assert.assertTrue(entriesPage.entriesButtonIsDisplayed(),"Entries page is not opened");
    }
}
