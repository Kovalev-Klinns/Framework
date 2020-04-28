package qaautomationframework.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import qaautomationframework.model.MachineConfiguration;

import java.util.HashMap;
import java.util.Map;

public class GoogleCloudCalculatorPage extends AbstractPage {
    private Map<String, String> operatingSystem = new HashMap<>();
    private Map<String, String> machineClass = new HashMap<>();
    private Map<String, String> machineType = new HashMap<>();

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

    public GoogleCloudCalculatorPage setMachineConfiguration(MachineConfiguration machineConfiguration) {
        operatingSystem.put("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS", "select_option_60");
        operatingSystem.put("Paid: Windows Server 2008r2, Windows Server 2012r2, Windows Server 2016, Windows Core", "select_option_61");
        operatingSystem.put("Paid: Red Hat Enterprise Linux", "select_option_61");
        //etc..

        machineClass.put("Regular", "select_option_72");
        machineClass.put("Preemptible", "select_option_73");

        machineType.put("n1-standard-4 (vCPUs: 4, RAM: 15GB)", "select_option_211");
        machineType.put("n1-standard-8 (vCPUs: 8, RAM: 30GB)", "select_option_212");
        machineType.put("n1-standard-16 (vCPUs: 16, RAM: 60GB)", "select_option_213");
        //etc..

        instancesField.sendKeys(machineConfiguration.getNecessaryNumberOfInstances());
        clickElement(operatingSystemBtn);
        WebElement operatingSystemElement = driver.findElement(By.id(operatingSystem.get(machineConfiguration.getNecessaryOperatingSystem())));
        clickElement(operatingSystemElement);
        clickElement(machineClassBtn);
        WebElement machineClassElement = driver.findElement(By.id(machineClass.get(machineConfiguration.getNecessaryMachineClass())));
        clickElement(machineClassElement);
        clickElement(machineTypeBtn);
        WebElement machineTypeElement = driver.findElement(By.id(machineType.get(machineConfiguration.getNecessaryMachineType())));
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