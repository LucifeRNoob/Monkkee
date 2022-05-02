package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class LoginOnlyWithPasswordTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(LoginOnlyWithPasswordTest.class.getName());

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    @Owner(value = "Andrey Kremenevskiy")
    @Description(value = "Сheck the error message when entering only the password")
    public void loginOnlyWithPasswordTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization attempt with only password");
        loginPage.login("", password);
        LOGGER.info("Checking that error message is shown");
        Assert.assertEquals(loginPage.emptyPassword(),"Mandatory field","Message is not shown");
    }
}
