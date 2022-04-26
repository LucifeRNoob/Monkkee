package tests;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LogoutTest.class.getName());

    @Test
    public void logoutTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        LOGGER.info("Click Logout link");
        entriesPage.clickLogoutLink();
        LOGGER.info("Check back to Login page");
        Assert.assertTrue(loginPage.loginButtonIsDisplayed(), "Login page is not opened");
    }
}
