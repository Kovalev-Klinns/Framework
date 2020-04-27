package qaautomationframework.service;

import org.openqa.selenium.WebDriver;
import qaautomationframework.driver.DriverSingleton;
import qaautomationframework.model.MachineConfiguration;

public class MachineConfigurationCreator {
    private static WebDriver driver = DriverSingleton.getDriver();
    public static final String NECESSARY_INSTANCES_NUMBER = TestDataReader.getTestData("testdata.instances.number");
    public static final String NECESSARY_OPERATING_SYSTEM = TestDataReader.getTestData("testdata.operating.system");
    public static final String NECESSARY_MACHINE_CLASS = TestDataReader.getTestData("testdata.machine.class");
    public static final String NECESSARY_MACHINE_TYPE = TestDataReader.getTestData("testdata.machine.type");

    public static MachineConfiguration withCredentialsFromProperty() {
        return new MachineConfiguration(NECESSARY_INSTANCES_NUMBER, NECESSARY_OPERATING_SYSTEM, NECESSARY_MACHINE_CLASS, NECESSARY_MACHINE_TYPE);
    }
}
