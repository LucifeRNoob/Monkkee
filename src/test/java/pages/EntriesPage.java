package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntriesPage extends BasePage {

    private By CREATE_ENTRIES_BUTTON = By.id("create-entry");
    private By DELETE_ENTRIES_BUTTON = By.id("delete-entries");
    private By BACK_TO_ENTRIES_PAGE_BUTTON = By.id("back-to-overview");
    private By EDITABLE_FIELD = By.cssSelector(".contenteditable.cke_editable");
    private By NEW_ENTRY = By.xpath("//*[contains(text(), 'My first entry')]");
    private By NO_ENTRIES_FOUND = By.xpath("//div[@class='none centered']");
    private By SAVE_NEW_ENTRY_BUTTON = By.cssSelector(".cke_button");
    private By SELECT_ALL_CHECKBOXES = By.cssSelector("input[ng-model='model.allChecked']");
    private By LOGOUT_LINK = By.cssSelector("button[ng-click='logout($event)']");

    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Is there an entries button on the page")
    public boolean entriesButtonIsDisplayed() {
        return driver.findElement(CREATE_ENTRIES_BUTTON).isDisplayed();
    }

    @Step("Click Logout link")
    public void clickLogoutLink() {
        driver.findElement(LOGOUT_LINK).click();
    }

    @Step("Creating new entry with input text")
    public void createNewEntry(String text) {
        driver.findElement(CREATE_ENTRIES_BUTTON).click();
        driver.findElement(EDITABLE_FIELD).sendKeys(text);
        driver.findElement(SAVE_NEW_ENTRY_BUTTON).click();
        driver.findElement(BACK_TO_ENTRIES_PAGE_BUTTON).click();
    }

    @Step("Checking the creation of the entry and the entered text")
    public String entryShouldBe() {
        return driver.findElement(NEW_ENTRY).getText();
    }

    @Step("Creating new entry with input text from faker")
    public void newEntryFaker(String entryTextFaker) {
        driver.findElement(CREATE_ENTRIES_BUTTON).click();
        driver.findElement(EDITABLE_FIELD).sendKeys(entryTextFaker);
        driver.findElement(SAVE_NEW_ENTRY_BUTTON).click();
        driver.findElement(BACK_TO_ENTRIES_PAGE_BUTTON).click();
    }

    @Step("Deleting all creating entry")
    public void deleteAllEntries() {
        driver.findElement(SELECT_ALL_CHECKBOXES).click();
        driver.findElement(DELETE_ENTRIES_BUTTON).click();
        driver.switchTo().alert().accept();
    }

    @Step("Сheck that there are no entries on the page")
    public String noEntriesOnPage() {
        return driver.findElement(NO_ENTRIES_FOUND).getText();
    }


    }

