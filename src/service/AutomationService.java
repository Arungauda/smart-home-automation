package service;

import notification.AutomationExecutedEvent;
import notification.EventBus;
import repository.AutomationRuleRepository;
import rule.AutomationRule;

public class AutomationService {

    private final AutomationRuleRepository ruleRepository;
    private final DeviceService deviceService;
    private final EventBus eventBus;

    public AutomationService(AutomationRuleRepository ruleRepository,
                             DeviceService deviceService) {
        this.ruleRepository = ruleRepository;
        this.deviceService = deviceService;
        this.eventBus = EventBus.getInstance();
    }
    public void evaluateRules(String trigger) {
        for (AutomationRule rule : ruleRepository.findAll()) {
            if (rule.getTrigger().equals(trigger)) {
                executeRule(rule);
            }
        }
    }

    private void executeRule(AutomationRule rule) {
        if ("TURN_ON".equals(rule.getAction())) {
            deviceService.changeDeviceStatus(rule.getDeviceId(), "ON");
        }

        eventBus.publish(new AutomationExecutedEvent(rule.getName()));
    }
}
