package device;

public class Device {
    private final String id;
    private final String name;
    private String status;
    private DeviceDetails details;


    public Device(String id, String name) {
        this.id = id;
        this.name = name;
        this.status = "OFF";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ✅ Lazy Loading Pattern
    public DeviceDetails getDetails() {
        if (details == null) {
            details = new DeviceDetails("Default Manufacturer", "v1.0");
        }
        return details;
    }




}
