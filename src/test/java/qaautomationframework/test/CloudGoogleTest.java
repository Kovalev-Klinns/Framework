package qaautomationframework.test;

import qaautomationframework.page.GoogleCloudCalculatorPage;
import qaautomationframework.page.TenMinutesEmailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CloudGoogleTest extends CommonConditions {
    private String totalCostInLetter;

    @Test
    public void cloudGoogleCalculatorEmailLetterTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        TenMinutesEmailPage tenMinutesEmailPage = new TenMinutesEmailPage(driver);
        tenMinutesEmailPage
                .openPageInNewWindow()
                .copyEmailAddress()
                .switchToPage()
                .emailEstimate()
                .pasteEmailAddressToField()
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
