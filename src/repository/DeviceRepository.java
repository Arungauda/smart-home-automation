package repository;

import device.Device;

import java.util.List;

public interface DeviceRepository {

    void save(Device device);
    Device findById(String id);
    List<Device> findAll();
}
