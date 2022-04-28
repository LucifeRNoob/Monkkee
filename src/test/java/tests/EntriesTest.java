package tests;

import io.qameta.allure.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EntriesTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(EntriesTest.class.getName());

    @Test
    @Description("Creating a new entry")
    public void createNewEntryTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        LOGGER.info("Creating new entry");
        entriesPage.createNewEntry("My first entry");
        LOGGER.info("Verifying that the entry was created correctly");
        Assert.assertEquals(entriesPage.entryShouldBe(), "My first entry", "Entry has not been added");
        entriesPage.clickLogoutLink();
    }

    @Test
    @Description("Creating a new entry with faker and deleting")
    public void createNewEntryAndDeletingTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        LOGGER.info("Creating new entry with faker");
        entriesPage.createNewEntry(entryTextFaker);
        LOGGER.info("Deleting entry");
        entriesPage.deleteAllEntries();
        LOGGER.info("Verifying that the entry was deleted correctly");
        Assert.assertEquals(entriesPage.noEntriesOnPage(), "No entries found", "Entry is not deleted");
        entriesPage.clickLogoutLink();
    }

    @Test
    @Description("Creating new entries and deleting all")
    public void deleteAllEntriesTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        LOGGER.info("Creating new entries with faker");
        entriesPage.createNewEntry(entryTextFaker);
        entriesPage.createNewEntry(entryTextFaker);
        entriesPage.createNewEntry(entryTextFaker);
        LOGGER.info("Deleting all entries");
        entriesPage.deleteAllEntries();
        LOGGER.info("Verifying that the entries was deleted correctly");
        Assert.assertEquals(entriesPage.noEntriesOnPage(), "No entries found", "Entries are not deleted");
        entriesPage.clickLogoutLink();
    }
}
