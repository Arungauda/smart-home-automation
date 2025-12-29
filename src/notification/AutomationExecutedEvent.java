package notification;

public class AutomationExecutedEvent extends Event {

    public AutomationExecutedEvent(String ruleName) {
        super("Automation rule executed: " + ruleName);
    }
}