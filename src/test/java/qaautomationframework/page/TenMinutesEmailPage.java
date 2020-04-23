package qaautomationframework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TenMinutesEmailPage extends AbstractPage {

    @FindBy(id = "mail")
    WebElement emailAddress;

    @FindBy(xpath = "/html/body/main/div[1]/div/div[2]/div[2]/div/div[1]/div/div[4]/ul/li[2]/div[2]/span/a")
    WebElement messageBtn;

    @FindBy(xpath = "//*[@id='mobilepadding']/td/table/tbody/tr[2]/td[2]/h3")
    WebElement totalCostInLetter;

    public TenMinutesEmailPage(WebDriver driver) {
        super(driver);
    }

    public TenMinutesEmailPage openPageInNewWindow() {
        ((JavascriptExecutor) driver).executeScript("window.open('https://10minemail.com/ru/')");

        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return this;
    }

    public String getEmailAddress() {
        return emailAddress.getAttribute("value");
    }

    public GoogleCloudCalculatorPage expandMessage() {
        new WebDriverWait(driver, 180)
                .until(ExpectedConditions.visibilityOf(messageBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", messageBtn);
        return new GoogleCloudCalculatorPage(driver);
    }
    @Override
    public TenMinutesEmailPage switchToPage() {
        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return this;
    }

    public String getTotalCostInLetterText() {
       return totalCostInLetter.getText();
    }
}
