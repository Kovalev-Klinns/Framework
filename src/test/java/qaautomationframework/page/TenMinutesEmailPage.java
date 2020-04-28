package qaautomationframework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenMinutesEmailPage extends AbstractPage {

    @FindBy(id = "mail")
    WebElement emailAddress;

    @FindBy(linkText = "Google Cloud Platform Price Estimate")
    WebElement messageBtn;

    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]/h3")
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
        explicitWaitForElementVisibility(messageBtn, 180);
        clickElement(messageBtn);
        return new GoogleCloudCalculatorPage(driver);
    }

    public TenMinutesEmailPage switchToPage() {
        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return this;
    }

    public String getTotalCostInLetterText() {
        explicitWaitForElementVisibility(totalCostInLetter, 35);
       return totalCostInLetter.getText();
    }
}
