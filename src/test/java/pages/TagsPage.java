package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TagsPage extends BasePage {

    public static final By TITLE_MANAGER_TAGS = By.xpath("//h1[.='Manage Tags']");
    public static final By EDIT_TAGS = By.xpath("//div[@id='main']//table[@class='spaced-table']//i[@class='icon-plus icon-white']");
    public static final By TITLE_EDIT_TAGS = By.xpath("//h1[.='Edit Tag']");
    public static final By INPUT_TAG_NAME = By.xpath("//input[@id='tag']");
    public static final By BUTTON_OK = By.xpath("//button[@class='btn btn-primary']");

    public TagsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Title manager tags should be visible")
    public boolean titleTagsShouldBeVisible() {
        return driver.findElement(TITLE_MANAGER_TAGS).isDisplayed();
    }

    @Step("Click on button for edit tags")
    public void buttonEditTags() {
        driver.findElement(EDIT_TAGS).click();
    }

    @Step("Title edit tags should be visible")
    public boolean titleEditTagsShouldBeVisible() {
        return driver.findElement(TITLE_EDIT_TAGS).isDisplayed();
    }

    @Step("Clear tag name")
    public void clearTagName() {
        driver.findElement(INPUT_TAG_NAME).clear();
    }

    @Step("Click on button submit setting page.")
    public void clickOnOkButton() {
        driver.findElement(BUTTON_OK).click();
    }
}
