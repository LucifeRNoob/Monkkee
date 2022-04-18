package factorydriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MozillaDriverManger extends DriverManager {

    @Override
    public void createDriver() {

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }
}
