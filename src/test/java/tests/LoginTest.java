package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test()
    @Description("Check login with valid user and password")
    public void loginTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        LOGGER.info("Checking that entries page is opened");
        Assert.assertTrue(entriesPage.entriesButtonIsDisplayed(),"Entries page is not opened");
    }

    @Test
    @Description("Сheck the error message when entering only the user")
    public void loginOnlyWithUserTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization attempt with only user");
        loginPage.login(user, "");
        LOGGER.info("Checking that error message is shown");
        Assert.assertEquals(loginPage.emptyUser(),"Mandatory field","Message is not shown");
    }

    @Test
    @Description("Сheck the error message when entering only the password")
    public void loginOnlyWithPasswordTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization attempt with only password");
        loginPage.login("", password);
        LOGGER.info("Checking that error message is shown");
        Assert.assertEquals(loginPage.emptyPassword(),"Mandatory field","Message is not shown");
    }
}
