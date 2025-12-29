package rule;

public class AutomationRule {

    private final String id;
    private final String name;
    private final String deviceId;
    private final String trigger;
    private final String action;


    public AutomationRule(String id, String name, String deviceId, String trigger, String action) {
        this.id = id;
        this.name = name;
        this.deviceId = deviceId;
        this.trigger = trigger;
        this.action = action;
    }

    public String getName() {
        return name;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public String getTrigger() {
        return trigger;
    }

    public String getAction() {
        return action;
    }
}
