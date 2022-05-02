package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By TITLE_HOME_PAGE = By.xpath("//section[@id='monkkee-safest-place-thoughts']//p[.='monkkee – the safest place for your thoughts']");
    private By BUTTON_SIGNUP = By.xpath("//section[@id='buttons']//a[@href='https://my.monkkee.com/account/registration?language=en']");
    private By BUTTON_TO_MY_ACCOUNT = By.xpath("//section[@id='buttons']//a[@href='https://my.monkkee.com/?language=en']");
    private By FEATURES_TITLE = By.xpath("//section[@id='features']//h1");
    private By SECURITY_TITLE = By.xpath("//section[@id='security']//h1");
    private By DONATIONS_TITLE = By.xpath("//section[@id='business-model-donations']//h1");
    private By TEAM_TITLE = By.xpath("//section[@id='team']//h1");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Title home page should be visible")
    public boolean titleHomePageVisible() {
        return driver.findElement(TITLE_HOME_PAGE).isDisplayed();
    }

    @Step("Button signup should be visible")
    public boolean buttonSignUpVisible() {
        return driver.findElement(BUTTON_SIGNUP).isDisplayed();
    }

    @Step("Button to my account should be visible")
    public boolean buttonToMyAccountVisible() {
        return driver.findElement(BUTTON_TO_MY_ACCOUNT).isDisplayed();
    }

    @Step("Click on button signup")
    public void buttonSignUpClick() {
        driver.findElement(BUTTON_SIGNUP).click();
    }

    @Step("Click on button to my account")
    public void buttonToMyAccountClick() {
        driver.findElement(BUTTON_TO_MY_ACCOUNT).click();
    }

    @Step("Title features should be visible")
    public boolean titleFeaturesVisible() {
        return driver.findElement(FEATURES_TITLE).isDisplayed();
    }

    @Step("Title Security should be visible")
    public boolean titleSecurityVisible() {
        return driver.findElement(SECURITY_TITLE).isDisplayed();
    }

    @Step("Title donations should be visible")
    public boolean titleDonationsVisible() {
        return driver.findElement(DONATIONS_TITLE).isDisplayed();
    }

    @Step("Title team should be visible")
    public boolean titleTeamVisible() {
        return driver.findElement(TEAM_TITLE).isDisplayed();
    }

}


