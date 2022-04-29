package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class CreateNewEntryAndDeletingTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(CreateNewEntryAndDeletingTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Description("Creating a new entry with faker and deleting")
    public void createNewEntryAndDeletingTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Creating new entry with faker");
        entriesPage.newEntryFaker(entryTextFaker);
        LOGGER.info("Deleting entry");
        entriesPage.deleteAllEntries();
        LOGGER.info("Verifying that the entry was deleted correctly");
        Assert.assertEquals(entriesPage.noEntriesOnPage(), "No entries found", "Entry is not deleted");
    }
}
