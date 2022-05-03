package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.RetryAnalyzer;

public class AddImageTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(AddImageTest.class.getName());

    @Test(priority = 3, retryAnalyzer = RetryAnalyzer.class)
    @Owner(value = "Andrey Kremenevskiy")
    @Description(value = "Add image into entry")
    public void addImageTest() {
        LOGGER.info("Opening login page");
        loginPage.openLoginPage();
        LOGGER.info("Authorization with user and password");
        loginPage.login(user, password);
        loginPage.checkDonationAlert();
        LOGGER.info("Click on 'Create entry' button");
        entriesPage.clickCreateEntry();
        LOGGER.info("Click on button for add new image");
        entriesPage.clickImgButton();
        LOGGER.info("Input image");
        entriesPage.inputImage();
        LOGGER.info("IMG align center");
        entriesPage.choiceImgAlignCenter();
        LOGGER.info("Click 'OK' button img properties");
        entriesPage.submitImgProperties();
        LOGGER.info("Check image should present on page");
        Assert.assertTrue(entriesPage.imagePresent(),"Image is not shown");
    }
}
