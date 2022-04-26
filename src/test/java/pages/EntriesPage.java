package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntriesPage extends BasePage{

    private By CREATE_ENTRIES_BUTTON = By.id("create-entry");
    private By LOGOUT_LINK = By.cssSelector("button[ng-click='logout($event)']");


    public EntriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Is there an enries button on the page")
    public boolean entriesButtonIsDisplayed(){
        return driver.findElement(CREATE_ENTRIES_BUTTON).isDisplayed();
    }

    @Step("Click Logout link")
    public void clickLogoutLink() {
        driver.findElement(LOGOUT_LINK).click();
    }
}
