package qaautomationframework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import qaautomationframework.driver.DriverSingleton;
import qaautomationframework.page.CloudGoogleHomePage;
import qaautomationframework.service.TestDataReader;
import qaautomationframework.util.TestListener;

import java.util.logging.LogManager;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    private String searchText = TestDataReader.getTestData("testdata.searching.text");
    private String necessaryNumberOfInstances = TestDataReader.getTestData("testdata.instances.number");

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = DriverSingleton.getDriver();
        CloudGoogleHomePage cloudGoogleHomePage = new CloudGoogleHomePage(driver);
        cloudGoogleHomePage
                .openPage()
                .toFind(searchText)
                .openGoogleCloudCalculatorLink()
                .switchFrame()
                .setInstances(necessaryNumberOfInstances)
                .setFreeOperatingSystem()
                .setRegularMachineClass()
                .setMachineType()
                .addGPUS()
                .setLocalSsd()
                .setDataCenterLocation()
                .setCommitedUsage()
                .addToEstimate();
    }

    @AfterMethod
    public void closeBrowser() {
        DriverSingleton.closeDriver();
    }
}
