package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class CreateEntryTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(CreateEntryTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Owner(value = "Andrey Kremenevskiy")
    @Description(value = "Creating a new entry")
    public void createNewEntryTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Creating new entry");
        entriesPage.createNewEntry("My first entry");
        LOGGER.info("Verifying that the entry was created correctly");
        Assert.assertEquals(entriesPage.entryShouldBe(), "My first entry", "Entry has not been added");
    }
}
