package qaautomationframework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import qaautomationframework.driver.DriverSingleton;
import qaautomationframework.page.CloudGoogleHomePage;
import qaautomationframework.service.TestDataReader;
import qaautomationframework.util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}
