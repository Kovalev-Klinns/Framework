package qaautomationframework.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CloudGoogleHomePage extends AbstractPage {
    private static final String HOME_URL = "https://cloud.google.com";

    @FindBy(xpath = "//input[@placeholder='Результаты поиска']")
    WebElement searchingField;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOME_URL);
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(searchingField));
        return this;
    }

    public CloudGoogleResultsPage toFind(String input) {
        searchingField.sendKeys(input + Keys.ENTER);
        return new CloudGoogleResultsPage(driver);
    }
}
