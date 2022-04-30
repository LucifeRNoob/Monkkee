package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class DeleteAllEntriesTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(DeleteAllEntriesTest.class.getName());

    @Test(priority = 2, retryAnalyzer = RetryAnalyzer.class)
    @Owner(value = "Andrey Kremenevskiy")
    @Description(value = "Creating new entries and deleting all")
    public void deleteAllEntriesTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Creating new entries with faker");
        entriesPage.newEntryFaker(entryTextFaker);
        entriesPage.newEntryFaker(entryTextFaker);
        entriesPage.newEntryFaker(entryTextFaker);
        LOGGER.info("Deleting all entries");
        entriesPage.deleteAllEntries();
        LOGGER.info("Verifying that the entries was deleted correctly");
        Assert.assertEquals(entriesPage.noEntriesOnPage(), "No entries found", "Entries are not deleted");
    }
}
