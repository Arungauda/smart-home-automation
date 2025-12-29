package service;

import repository.AutomationRuleRepository;
import repository.DeviceRepository;

public class ReportService {

    private final DeviceRepository deviceRepository;
    private final AutomationRuleRepository ruleRepository;

    public ReportService(DeviceRepository deviceRepository,
                         AutomationRuleRepository ruleRepository) {
        this.deviceRepository = deviceRepository;
        this.ruleRepository = ruleRepository;
    }


    public void generateDeviceReport() {
        System.out.println("---- Device Report ----");
        deviceRepository.findAll()
                .forEach(d -> System.out.println(d.getName() + " : " + d.getStatus()));
    }

    public void generateAutomationReport() {
        System.out.println("---- Automation Rules ----");
        ruleRepository.findAll()
                .forEach(r -> System.out.println(r.getName()));
    }
}
