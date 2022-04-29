package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class LogoutTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LogoutTest.class.getName());

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    public void logoutTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Click Logout link");
        entriesPage.clickLogoutLink();
        LOGGER.info("Check back to Login page");
        Assert.assertTrue(loginPage.loginButtonIsDisplayed(), "Login page is not opened");
    }
}
