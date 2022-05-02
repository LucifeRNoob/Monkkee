package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import staticdata.WebUrls;


public class LoginPage extends BasePage {

    private By USER_FIELD = By.id("login");
    private By PASSWORD_FIELD = By.id("password");
    private By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    private By REMINDER_LINK = By.xpath("//*[contains(text(), 'Send password reminder')]");
    private By REGISTER_LINK = By.xpath("//*[contains(text(), 'Register')]");
    private By MANDATORY_ERROR = By.xpath("//*[contains(text(), 'Mandatory field')]");
    private By HOMEPAGE_LINK = By.xpath("//a[@href='https://www.monkkee.com/en/']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Opening login page")
    public void openLoginPage() {
        driver.get(WebUrls.MONKKEE_URL);
    }

    @Step("Authorization with login and password")
    public void login(String user, String password) {
        driver.findElement(USER_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    @Step("Showing error message if user field is empty")
    public String emptyUser() {
        return driver.findElement(MANDATORY_ERROR).getText();
    }

    @Step("Showing error message if password field is empty")
    public String emptyPassword() {
        return driver.findElement(MANDATORY_ERROR).getText();
    }

    @Step("Login button is displayed")
    public boolean loginButtonIsDisplayed() {
        return driver.findElement(USER_FIELD).isDisplayed();
    }

    @Step("Click Homepage link")
    public void clickHomepage() {
        driver.findElement(REMINDER_LINK).click();
    }

    @Step("Check donation alert and press 'Cancel' button")
    public void checkDonationAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 7);
            WebElement cancelButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Cancel']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cancelButton);
            cancelButton.click();
        } catch (NoSuchElementException | TimeoutException exception) {
        }
    }
}
