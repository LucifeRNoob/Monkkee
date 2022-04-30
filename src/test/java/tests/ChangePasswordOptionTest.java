package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class ChangePasswordOptionTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(ChangePasswordOptionTest.class.getName());

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    @Owner(value = "Andrey Kremenevskiy")
    @Description(value = "Check change password option")
    public void changePasswordOption() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Try to open settings");
        entriesPage.openSettings();
        LOGGER.info("Click on password");
        settingPage.openChangePasswordOption();
        LOGGER.info("Try to change password");
        settingPage.changePasswordOption(password);
        LOGGER.info("Check that the password has been changed");
        Assert.assertEquals(settingPage.getMessageAboutChangingPassword(),
                "Your password has been changed successfully","Message is not shown");
    }
}
