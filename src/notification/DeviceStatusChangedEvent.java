package notification;

public class DeviceStatusChangedEvent extends Event {

    public DeviceStatusChangedEvent(String deviceName) {
        super("Device status changed: " + deviceName);
    }
}