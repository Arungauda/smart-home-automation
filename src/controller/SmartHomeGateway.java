package controller;

import service.DeviceService;
import device.Device;

public class SmartHomeGateway {

    private final DeviceService deviceService;

    public SmartHomeGateway(DeviceService deviceService) {
        this.deviceService = deviceService;
    }

    public void registerDevice(Device device) {
            if (!deviceService.healthCheck()) {
                System.out.println("Device Service is DOWN. Try later.");
                return;
            }
        deviceService.addDevice(device);
        System.out.println("Device Service is UP");
    }

    public void updateDeviceStatus(String id, String status) {
        deviceService.changeDeviceStatus(id, status);
    }
}
