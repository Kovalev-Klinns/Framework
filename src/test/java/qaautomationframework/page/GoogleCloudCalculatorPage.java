package qaautomationframework.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy(id = "myFrame")
    WebElement secondFrame;

    @FindBy(id = "input_56")
    WebElement instancesField;

    @FindBy(id = "select_value_label_49")
    WebElement operatingSystemBtn;

    @FindBy(id = "select_option_58")
    WebElement freeOperatingSystem;

    @FindBy(id = "select_value_label_50")
    WebElement machineClassBtn;

    @FindBy(id = "select_option_70")
    WebElement regularMachineClass;

    @FindBy(id = "select_value_label_53")
    WebElement machineType;

    @FindBy(id = "select_option_209")
    WebElement selectRightMachineType;

    @FindBy(xpath = "//*[@id='mainForm']/div[1]/div/md-card/md-card-content/div/div[1]/form/div[8]/div[1]/md-input-container/md-checkbox/div[1]")
    WebElement addGpusCheckbox;

    @FindBy(id = "select_value_label_327")
    WebElement numberOfGpusBtn;

    @FindBy(id = "select_option_334")
    WebElement necessaryGpus;

    @FindBy(id = "select_value_label_328")
    WebElement gpuTypeBtn;

    @FindBy(id = "select_option_341")
    WebElement necessaryGpuType;

    @FindBy(id = "select_value_label_167")
    WebElement localSsdBtn;

    @FindBy(id = "select_option_230")
    WebElement necessaryLocalSsd;

    @FindBy(id = "select_value_label_54")
    WebElement dataCenterLocationBtn;

    @FindBy(id = "select_option_178")
    WebElement necessaryCenterLocationBtn;

    @FindBy(id = "select_value_label_55")
    WebElement commitedUsageBtn;

    @FindBy(id = "select_option_88")
    WebElement necessaryCommitedUsage;

    @FindBy(xpath = "//*[@id='mainForm']/div[1]/div/md-card/md-card-content/div/div[1]/form/div[15]/button")
    WebElement addToEstimateBtn;

    @FindBy(id = "email_quote")
    WebElement emailEstimateBtn;

    @FindBy(id = "input_396")
    WebElement emailField;

    @FindBy(xpath = "//*[@id='dialogContent_402']/form/md-dialog-actions/button[2]")
    WebElement sendLetterToEmailBtn;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/h2/b")
    WebElement totalCost;


    public GoogleCloudCalculatorPage(WebDriver driver) {
       super(driver);
    }

    public GoogleCloudCalculatorPage switchFrame() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        return this;
    }


    public GoogleCloudCalculatorPage setInstances(String numberOfInstances) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(instancesField));
        instancesField.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudCalculatorPage setFreeOperatingSystem()  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", operatingSystemBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", freeOperatingSystem);
        return this;
    }

    public GoogleCloudCalculatorPage setRegularMachineClass() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineClassBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", regularMachineClass);
        return this;
    }

    public GoogleCloudCalculatorPage setMachineType() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineType);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectRightMachineType);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", freeOperatingSystem);
        return this;
    }

    public GoogleCloudCalculatorPage addGPUS() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addGpusCheckbox);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(numberOfGpusBtn));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", numberOfGpusBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", necessaryGpus);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", numberOfGpusBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", gpuTypeBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", necessaryGpuType);
        return this;
    }

    public GoogleCloudCalculatorPage setLocalSsd() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", localSsdBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", necessaryLocalSsd);
        return this;
    }

    public GoogleCloudCalculatorPage setDataCenterLocation() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dataCenterLocationBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", necessaryCenterLocationBtn);
        return this;
    }

    public GoogleCloudCalculatorPage setCommitedUsage() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", commitedUsageBtn);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", necessaryCommitedUsage);
        return this;
    }

    public GoogleCloudCalculatorPage addToEstimate() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToEstimateBtn);
        return this;
    }

    public GoogleCloudCalculatorPage emailEstimate() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailEstimateBtn);
        return this;
    }

    public GoogleCloudCalculatorPage pasteEmailAddressToField() {
        emailField.sendKeys(Keys.chord(Keys.CONTROL, "v"));
        return this;
    }

    public TenMinutesEmailPage sendLetterToEmail() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendLetterToEmailBtn);
        return new TenMinutesEmailPage(driver);
    }

    @Override
    public GoogleCloudCalculatorPage switchToPage() {
        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            break;
        }
        switchFrame();
        return this;
    }

    public String getTotalCost() {
        return totalCost.getText();
    }
}