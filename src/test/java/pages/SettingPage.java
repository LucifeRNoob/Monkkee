package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SettingPage extends BasePage {

    private By DROPDOWN = By.name("selectLocale");
    private By EN = By.xpath("//*[contains(text(), 'Language selection')]");
    private By MENU_PASS = By.cssSelector("[ng-class=\"cssClass('password')\"]");
    private By OLD_PASS = By.id("old-password");
    private By NEW_PASS = By.id("password");
    private By NEW_CONF = By.id("password-confirmation");
    private By NEW_HINT = By.id("password-hint");
    private By PASS_CHANGED = By.xpath("//*[contains(text(), 'Your password has been changed successfully')]");
    private By CONFIRM = By.cssSelector(".alert");
    private By OK_BUTTON = By.xpath("//div[@class='btn-text-content']");


    public SettingPage(WebDriver driver) {
        super(driver);
    }

    @Step("Checking that the settings page should open")
    public boolean settingsPageShouldBeWorking() {
        return  driver.findElement(EN).isDisplayed();
    }

    @Step("Changing language settings")
    public void setLanguage(String lang) {
        Select select = new Select(driver.findElement(DROPDOWN));
        select.selectByValue(lang);
        driver.findElement(DROPDOWN).submit();
    }

    @Step("Сheck that the language has changed")
    public String changeLanguageToDeutsch() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(CONFIRM)).getText();
    }

    @Step("Open Change password in settings")
    public void openChangePasswordOption() {
        driver.findElement(MENU_PASS).click();
    }

    @Step("Changing the password to a new one")
    public void changePasswordOption(String password) {
        driver.findElement(OLD_PASS).sendKeys(password);
        driver.findElement(NEW_PASS).sendKeys(password);
        driver.findElement(NEW_CONF).sendKeys(password);
        driver.findElement(OK_BUTTON).click();
    }

    @Step("Сheck if you received a password change message")
    public String getMessageAboutChangingPassword() {
        return driver.findElement(PASS_CHANGED).getText();
    }
}
