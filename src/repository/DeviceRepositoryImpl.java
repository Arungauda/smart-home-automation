package repository;

import device.Device;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceRepositoryImpl implements DeviceRepository{

    private static final Map<String, Device> DEVICES = new HashMap<>();

    @Override
    public void save(Device device) {
        DEVICES.put(device.getId(), device);
    }

    @Override
    public Device findById(String id) {
        return DEVICES.get(id);
    }

    @Override
    public List<Device> findAll() {
        return new ArrayList<>(DEVICES.values());
    }
}
