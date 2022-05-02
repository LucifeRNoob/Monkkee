package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class ChangeLanguageToDeutschTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(ChangeLanguageToDeutschTest.class.getName());

    @Test(priority = 4, retryAnalyzer = RetryAnalyzer.class)
    @Owner(value = "Andrey Kremenevskiy")
    @Description(value = "Try to change language to Deutsch")
    public void ChangeLanguageToDeutschTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Try to open settings");
        entriesPage.openSettings();
        LOGGER.info("Change language to Deutsch");
        settingPage.setLanguage("de");
        LOGGER.info("Check that language changed");
        Assert.assertEquals(settingPage.changeLanguageToDeutsch(),"Deine Spracheinstellung wurde erfolgreich geändert","Language was not changed");
        }

    @AfterMethod(alwaysRun = true)
    public void backToEnglish(){
        settingPage.setLanguage("en");
    }
}
