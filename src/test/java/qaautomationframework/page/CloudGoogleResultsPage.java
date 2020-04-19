package qaautomationframework.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CloudGoogleResultsPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"___gcse_0\"]/div/div/div/div[5]/div[2]/div/div/div[1]/div[1]/div[1]/div[1]/div/a")
    WebElement googleCloudCalculatorLink;

    public CloudGoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorPage openGoogleCloudCalculatorLink() {
        new WebDriverWait(driver, 35)
                .until(ExpectedConditions.visibilityOf(googleCloudCalculatorLink));
        googleCloudCalculatorLink.click();
        return new GoogleCloudCalculatorPage(driver);
    }
}
