package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import staticdata.WebUrls;


public class LoginPage extends BasePage {

    private By USER_FIELD = By.id("login");
    private By PASSWORD_FIELD = By.id("password");
    private By LOGIN_BUTTON = By.xpath("//button[@type='submit']");
    private By REMINDER_LINK = By.xpath("//*[contains(text(), 'Send password reminder')]");
    private By REGISTER_LINK = By.xpath("//*[contains(text(), 'Register')]");
    private By MANDATORY_ERROR = By.xpath("//*[contains(text(), 'Mandatory field')]");


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
        return driver.findElement(LOGIN_BUTTON).isDisplayed();
    }

}
