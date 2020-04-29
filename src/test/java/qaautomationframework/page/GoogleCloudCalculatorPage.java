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
        explicitWaitForElementVisibility(firstFrame, 35);
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        return this;
    }

    public String xpathTemplateForElement(String value) {
        return "//*[@value='" + value + "']";
    }

    public GoogleCloudCalculatorPage setMachineConfiguration(MachineConfiguration machineConfiguration) {
        instancesField.sendKeys(machineConfiguration.getNecessaryNumberOfInstances());
        clickElement(operatingSystemBtn);
        WebElement operatingSystemElement = driver.findElement(By.xpath(xpathTemplateForElement(machineConfiguration.getNecessaryOperatingSystem())));
        clickElement(operatingSystemElement);
        clickElement(machineClassBtn);
        WebElement machineClassElement = driver.findElement(By.xpath(xpathTemplateForElement(machineConfiguration.getNecessaryMachineClass())));
        clickElement(machineClassElement);
        clickElement(machineTypeBtn);
        WebElement machineTypeElement = driver.findElement(By.xpath(xpathTemplateForElement(machineConfiguration.getNecessaryMachineType())));
        clickElement(machineTypeElement);
        return this;
    }


    public GoogleCloudCalculatorPage addGPUS() {
        clickElement(addGpusCheckbox);
        explicitWaitForElementVisibility(numberOfGpusBtn, 30);
        clickElement(numberOfGpusBtn);
        clickElement(necessaryGpus);
        clickElement(numberOfGpusBtn);
        clickElement(gpuTypeBtn);
        clickElement(necessaryGpuType);
        return this;
    }

    public GoogleCloudCalculatorPage setLocalSsd() {
        clickElement(localSsdBtn);
        clickElement(necessaryLocalSsd);
        return this;
    }

    public GoogleCloudCalculatorPage setDataCenterLocation() {
        clickElement(dataCenterLocationBtn);
        clickElement(necessaryCenterLocationBtn);
        return this;
    }

    public GoogleCloudCalculatorPage setCommitedUsage() {
        clickElement(commitedUsageBtn);
        clickElement(necessaryCommitedUsage);
        return this;
    }

    public GoogleCloudCalculatorPage addToEstimate() {
        clickElement(addToEstimateBtn);
        return this;
    }

    public TenMinutesEmailPage emailEstimate() {
        clickElement(emailEstimateBtn);
        return new TenMinutesEmailPage(driver);
    }

    public GoogleCloudCalculatorPage pasteEmailAddressToField(String emailAddress) {
        emailField.sendKeys(emailAddress);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeContains(emailField, "value", emailAddress));
        return this;
    }

    public TenMinutesEmailPage sendLetterToEmail() {
        clickElement(sendLetterToEmailBtn);
        return new TenMinutesEmailPage(driver);
    }

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