package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EntriesPage extends BasePage {

    private By CREATE_ENTRIES_BUTTON = By.id("create-entry");
    private By DELETE_ENTRIES_BUTTON = By.id("delete-entries");
    private By BACK_TO_ENTRIES_PAGE_BUTTON = By.id("back-to-overview");
    private By EDITABLE_FIELD = By.cssSelector(".contenteditable.cke_editable");
    private By NEW_ENTRY = By.xpath("//*[contains(text(), 'My first entry')]");
    private By NO_ENTRIES_FOUND = By.xpath("//div[@class='none centered']");
    private By SAVE_NEW_ENTRY_BUTTON = By.cssSelector(".cke_button_icon");
    private By SELECT_ALL_CHECKBOXES = By.cssSelector("input[ng-model='model.allChecked']");
    private By LOGOUT_LINK = By.cssSelector("button[ng-click='logout($event)']");
    private By SETTINGS_LINK = By.cssSelector(".icon-cog.icon-light");
    private By ADD_IMG = By.xpath("//div[@class='cke_inner']//*[@class='cke_button_icon cke_button__image_icon']");
    private By IMG_PROPERTIES_INPUT_URL_IMG = By.xpath(" //div[@role='presentation']//input[@class='cke_dialog_ui_input_text']");
    private By IMG_PROPERTIES = By.xpath("//div[@class='cke_dialog_body']");
    private By IMG_ALIGN_CENTER = By.xpath("//div[@role='radiogroup']//table[@role='presentation']//label[.='Center']");
    private By CLICK_BUTTON_OK_IMG_PROPERTIES = By.xpath("//div[@class='cke_dialog_body']//span[text()='OK']");
    private By IMAGE_VISIBILITY = By.xpath("//img[@src='https://img-host.su/MW6Sm.png']");
    private By HOME_BUTTON = By.xpath("//i[@class='icon-home']");
    private By BUTTON_MANAGER_TAGS = By.xpath("//section[@id='tags']//a[text()='Manage tags']");
    private By INPUT_TAG_NAME = By.xpath("//input[@id='new-tag']");

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

    @Step("Open settings")
    public void openSettings() {
        driver.findElement(SETTINGS_LINK).click();
    }

    @Step("Check donation alert and press 'Logout' button")
    public void checkDonationAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 7);
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Log out']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelButton);
            cancelButton.click();
        } catch (NoSuchElementException | TimeoutException exception) {
        }
    }

    @Step("Click on button for add new image")
    public void clickImgButton() {
        driver.findElement(ADD_IMG).click();
    }

    @Step("Input image")
    public void inputImage() {
        driver.findElement(IMG_PROPERTIES_INPUT_URL_IMG).sendKeys("https://img-host.su/MW6Sm.png");
    }

    @Step("IMG align center")
    public void choiceImgAlignCenter() {
        driver.findElement(IMG_ALIGN_CENTER).click();
    }

    @Step("Click 'OK' button img properties")
    public void submitImgProperties() {
        driver.findElement(CLICK_BUTTON_OK_IMG_PROPERTIES).click();
    }

    @Step("Properties should be visible.")
    public boolean propertiesCheckVisible() {
        return driver.findElement(IMG_PROPERTIES).isDisplayed();
    }

    @Step("Image should present on page")
    public boolean imagePresent() {
        return driver.findElement(IMAGE_VISIBILITY).isDisplayed();
    }

    @Step("Click on 'Create entry' button")
    public void clickCreateEntry(){
        driver.findElement(CREATE_ENTRIES_BUTTON).click();
    }

    @Step("Click 'Home' button")
    public void clickHomeButton() {
        driver.findElement(HOME_BUTTON).click();
    }

    @Step("Click on button manager tags and open setting tags.")
    public void clickOnButtonManagerTags() {
        driver.findElement(BUTTON_MANAGER_TAGS).click();
    }
}

