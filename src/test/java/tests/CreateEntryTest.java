package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEntryTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(CreateEntryTest.class.getName());

    @Test(priority = 1)
    @Description("Creating a new entry")
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
