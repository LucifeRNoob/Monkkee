package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class LogoutTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LogoutTest.class.getName());

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    @Owner(value = "Andrey Kremenevskiy")
    @Description(value = "Logout performance")
    public void logoutTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Click Logout link");
        entriesPage.clickLogoutLink();
        entriesPage.checkDonationAlert();
        LOGGER.info("Check back to Login page");
        Assert.assertTrue(loginPage.loginButtonIsDisplayed(), "Login page is not opened");
    }
}
