package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class LoginOnlyWithUserTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginOnlyWithUserTest.class.getName());

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    @Description("Сheck the error message when entering only the user")
    public void loginOnlyWithUserTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization attempt with only user");
        loginPage.login(user, "");
        loginPage.checkDonationAlert();
        LOGGER.info("Checking that error message is shown");
        Assert.assertEquals(loginPage.emptyUser(), "Mandatory field", "Message is not shown");
    }
}
