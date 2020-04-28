package qaautomationframework.test;

import qaautomationframework.page.CloudGoogleHomePage;
import qaautomationframework.page.GoogleCloudCalculatorPage;
import qaautomationframework.page.TenMinutesEmailPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import qaautomationframework.service.MachineConfigurationCreator;
import qaautomationframework.service.TestDataReader;

public class CloudGoogleTest extends CommonConditions {
    private String totalCostInLetter;
    private String emailAddress;
    private String searchText = TestDataReader.getTestData("testdata.searching.text");
    @Test
    public void cloudGoogleCalculatorEmailLetterTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        TenMinutesEmailPage tenMinutesEmailPage = new TenMinutesEmailPage(driver);
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
                .addToEstimate()
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
