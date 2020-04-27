package qaautomationframework.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import qaautomationframework.page.GoogleCloudCalculatorPage;
import qaautomationframework.service.MachineConfigurationCreator;

public class EstimateIsCreatedTest extends CommonConditions {

    @Test
    public void estimateIsCreatedTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        googleCloudCalculatorPage
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

