package qaautomationframework.service;

import org.openqa.selenium.WebDriver;
import qaautomationframework.driver.DriverSingleton;
import qaautomationframework.model.MachineConfiguration;

public class MachineConfigurationCreator {
    private static WebDriver driver = DriverSingleton.getDriver();
    public static final String NECESSARY_OPERATING_SYSTEM = TestDataReader.getTestData("testdata.operating.system.id");
    public static final String NECESSARY_MACHINE_CLASS = TestDataReader.getTestData("testdata.machine.class.id");
    public static final String NECESSARY_MACHINE_TYPE = TestDataReader.getTestData("testdata.machine.type.id");

    public static MachineConfiguration withCredentialsFromProperty() {
        return new MachineConfiguration(NECESSARY_OPERATING_SYSTEM, NECESSARY_MACHINE_CLASS, NECESSARY_MACHINE_TYPE);
    }
}
