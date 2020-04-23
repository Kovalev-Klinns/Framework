package qaautomationframework.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaautomationframework.model.MachineConfiguration;

public class GoogleCloudCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy(id = "myFrame")
    WebElement secondFrame;

    @FindBy(id = "input_58")
    WebElement instancesField;

    @FindBy(id = "select_value_label_51")
    WebElement operatingSystemBtn;

    @FindBy(id = "select_value_label_52")
    WebElement machineClassBtn;

    @FindBy(id = "select_value_label_55")
    WebElement machineTypeBtn;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGpusCheckbox;

    @FindBy(id = "select_value_label_332")
    WebElement numberOfGpusBtn;

    @FindBy(id = "select_option_341")
    WebElement necessaryGpus;

    @FindBy(id = "select_value_label_333")
    WebElement gpuTypeBtn;

    @FindBy(id = "select_option_346")
    WebElement necessaryGpuType;

    @FindBy(id = "select_value_label_169")
    WebElement localSsdBtn;

    @FindBy(id = "select_option_233")
    WebElement necessaryLocalSsd;

    @FindBy(id = "select_value_label_56")
    WebElement dataCenterLocationBtn;

    @FindBy(id = "select_option_181")
    WebElement necessaryCenterLocationBtn;

    @FindBy(id = "select_value_label_57")
    WebElement commitedUsageBtn;

    @FindBy(id = "select_option_90")
    WebElement necessaryCommitedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    WebElement addToEstimateBtn;

    @FindBy(id = "email_quote")
    WebElement emailEstimateBtn;

    @FindBy(id = "input_401")
    WebElement emailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement sendLetterToEmailBtn;

    @FindBy(xpath = "//*[@id='resultBlock']//h2/b")
    WebElement totalCost;

    public GoogleCloudCalculatorPage(WebDriver driver) {
       super(driver);
    }

    public GoogleCloudCalculatorPage switchFrame() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        return this;
    }

    public GoogleCloudCalculatorPage setInstances(String numberOfInstances) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOf(instancesField));
        instancesField.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudCalculatorPage setMachineConfiguration(MachineConfiguration machineConfiguration) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", operatingSystemBtn);
        WebElement operatingSystem = driver.findElement(By.id(machineConfiguration.getNecessaryOperatingSystem()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", operatingSystem);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineClassBtn);
        WebElement machineClass = driver.findElement(By.id(machineConfiguration.getNecessaryMachineClass()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineClass);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineTypeBtn);
        WebElement machineType = driver.findElement(By.id(machineConfiguration.getNecessaryMachineType()));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineType);
        return this;
    }

    public GoogleCloudCalculatorPage addGPUS() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addGpusCheckbox);
        new WebDriverWait(driver, 30)
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

    public GoogleCloudCalculatorPage pasteEmailAddressToField(String emailAddress) {
        emailField.sendKeys(emailAddress);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeContains(emailField, "value", emailAddress));
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

    public boolean emailEstimateBtnIsDisplayed() {
        if (emailEstimateBtn.isDisplayed()) {
            return true;
        }
        else {
            return false;
        }
    }

    public String getTotalCost() {
        return totalCost.getText();
    }
}