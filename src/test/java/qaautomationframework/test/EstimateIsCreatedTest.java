package qaautomationframework.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import qaautomationframework.page.GoogleCloudCalculatorPage;

public class EstimateIsCreatedTest extends CommonConditions {

    @Test
    public void estimateIsCreatedTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        Assert.assertTrue(googleCloudCalculatorPage.emailEstimateBtnIsDisplayed());
    }
}
