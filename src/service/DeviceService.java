package service;

import config.CircuitBreaker;
import config.HealthCheck;
import repository.DeviceRepository;
import device.Device;
import notification.DeviceStatusChangedEvent;
import notification.EventBus;

public class DeviceService implements HealthCheck {

    private final DeviceRepository deviceRepository;
    private final EventBus eventBus;
    private final CircuitBreaker circuitBreaker;


    public DeviceService(DeviceRepository deviceRepository) {
        this.deviceRepository = deviceRepository;
        this.eventBus = EventBus.getInstance();
        this.circuitBreaker = new CircuitBreaker();
    }

    public void addDevice(Device device) {
        circuitBreaker.check();
        deviceRepository.save(device);
        eventBus.publish(new DeviceStatusChangedEvent(device.getName()));
    }

    public void changeDeviceStatus(String deviceId, String status) {
        circuitBreaker.check();
        Device device = deviceRepository.findById(deviceId);
        if (device == null) {
            circuitBreaker.trip();
            throw new RuntimeException("Device not found");
        }
        device.setStatus(status);
        eventBus.publish(new DeviceStatusChangedEvent(device.getName()));
    }

    @Override
    public boolean healthCheck() {
        return !circuitBreaker.isOpen();
    }

}
