package qaautomationframework.model;


public class MachineConfiguration {
    private String necessaryNumberOfInstances;
    private String necessaryOperatingSystem;
    private String necessaryMachineClass;
    private String necessaryMachineType;

    public MachineConfiguration(String necessaryNumberOfInstances, String necessaryOperatingSystem, String necessaryMachineClass, String necessaryMachineType) {
        this.necessaryNumberOfInstances = necessaryNumberOfInstances;
        this.necessaryOperatingSystem = necessaryOperatingSystem;
        this.necessaryMachineClass = necessaryMachineClass;
        this.necessaryMachineType = necessaryMachineType;
    }

    public String getNecessaryOperatingSystem() {
        return necessaryOperatingSystem;
    }

    public void setNecessaryOperatingSystem(String necessaryOperatingSystem) {
        this.necessaryOperatingSystem = necessaryOperatingSystem;
    }

    public String getNecessaryMachineClass() {
        return necessaryMachineClass;
    }

    public void setNecessaryMachineClass(String necessaryMachineClass) {
        this.necessaryMachineClass = necessaryMachineClass;
    }

    public String getNecessaryMachineType() {
        return necessaryMachineType;
    }

    public void setNecessaryMachineType(String necessaryMachineType) {
        this.necessaryMachineType = necessaryMachineType;
    }

    public String getNecessaryNumberOfInstances() {
        return necessaryNumberOfInstances;
    }

    public void setNecessaryNumberOfInstances(String necessaryNumberOfInstances) {
        this.necessaryNumberOfInstances = necessaryNumberOfInstances;
    }
}
