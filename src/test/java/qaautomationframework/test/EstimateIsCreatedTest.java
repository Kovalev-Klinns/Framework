package qaautomationframework.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import qaautomationframework.page.CloudGoogleHomePage;
import qaautomationframework.page.GoogleCloudCalculatorPage;
import qaautomationframework.service.MachineConfigurationCreator;
import qaautomationframework.service.TestDataReader;

public class EstimateIsCreatedTest extends CommonConditions {
    private String searchText = TestDataReader.getTestData("testdata.searching.text");

    @Test
    public void estimateIsCreatedTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        CloudGoogleHomePage cloudGoogleHomePage = new CloudGoogleHomePage(driver);
        cloudGoogleHomePage
                .openPage()//
                .toFind(searchText)
                .openGoogleCloudCalculatorLink()
                .switchFrame()
                .setMachineConfiguration(MachineConfigurationCreator.withCredentialsFromProperty())
                .addGPUS()
                .setLocalSsd()
                .setDataCenterLocation()
                .setCommitedUsage()
                .addToEstimate();
        Assert.assertTrue(googleCloudCalculatorPage.emailEstimateBtnIsDisplayed());
    }
}

