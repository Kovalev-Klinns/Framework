package qaautomationframework.test;

import qaautomationframework.page.GoogleCloudCalculatorPage;
import qaautomationframework.page.TenMinutesEmailPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import qaautomationframework.service.MachineConfigurationCreator;

public class CloudGoogleTest extends CommonConditions {
    private String totalCostInLetter;
    private String emailAddress;

    @Test
    public void cloudGoogleCalculatorEmailLetterTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        TenMinutesEmailPage tenMinutesEmailPage = new TenMinutesEmailPage(driver);
        googleCloudCalculatorPage
                .switchFrame()
                .setMachineConfiguration(MachineConfigurationCreator.withCredentialsFromProperty())
                .addGPUS()
                .setLocalSsd()
                .setDataCenterLocation()
                .setCommitedUsage()
                .addToEstimate();
        googleCloudCalculatorPage
                .emailEstimate()
                .openPageInNewWindow();
        emailAddress = tenMinutesEmailPage.getEmailAddress();
        googleCloudCalculatorPage
                .switchToPage()
                .pasteEmailAddressToField(emailAddress)
                .sendLetterToEmail()
                .switchToPage()
                .expandMessage();
        totalCostInLetter = tenMinutesEmailPage.getTotalCostInLetterText();
                googleCloudCalculatorPage
                .switchToPage()
                .getTotalCost();
        Assert.assertTrue(googleCloudCalculatorPage.getTotalCost().contains(totalCostInLetter));
    }
}
