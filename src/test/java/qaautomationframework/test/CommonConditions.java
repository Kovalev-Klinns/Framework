package qaautomationframework.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import qaautomationframework.driver.DriverSingleton;
import qaautomationframework.page.CloudGoogleHomePage;
import qaautomationframework.page.GoogleCloudCalculatorPage;
import qaautomationframework.service.MachineConfigurationCreator;
import qaautomationframework.service.TestDataReader;
import qaautomationframework.util.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;
    private String searchText = TestDataReader.getTestData("testdata.searching.text");
    private String necessaryNumberOfInstances = TestDataReader.getTestData("testdata.instances.number");

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        driver = DriverSingleton.getDriver();
        CloudGoogleHomePage cloudGoogleHomePage = new CloudGoogleHomePage(driver);
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        cloudGoogleHomePage
                .openPage()
                .toFind(searchText)
                .openGoogleCloudCalculatorLink()
                .switchFrame()
                .setInstances(necessaryNumberOfInstances)
                .setMachineConfiguration(MachineConfigurationCreator.withCredentialsFromProperty())
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
