import controller.SmartHomeGateway;
import device.Device;
import interceptor.LoggingInterceptor;
import notification.EventBus;
import notification.NotificationService;
import repository.DeviceRepository;
import repository.DeviceRepositoryImpl;
import repository.UserRepository;
import repository.UserRepositoryImpl;
import service.DeviceService;
import service.UserService;
import user.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== SMART HOME AUTOMATION SYSTEM =====");

        // Setup infrastructure
        EventBus eventBus = EventBus.getInstance();
        eventBus.subscribe(new NotificationService());

        UserRepository userRepository = new UserRepositoryImpl();
        DeviceRepository deviceRepository = new DeviceRepositoryImpl();

        UserService userService = new UserService();
        DeviceService deviceService = new DeviceService(deviceRepository);

        SmartHomeGateway gateway = new SmartHomeGateway(deviceService);

        LoggingInterceptor interceptor = new LoggingInterceptor();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Create User");
            System.out.println("2. Add Device");
            System.out.println("3. Change Device Status");
            System.out.println("4. View Users");
            System.out.println("5. View Devices");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {

                case 1:
                    interceptor.preHandle("Create User");

                    System.out.print("Enter Role (ADMIN/HOMEOWNER): ");
                    String role = scanner.nextLine();

                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    User user = userService.createUser(role, userId, name);
                    userRepository.save(user);

                    interceptor.postHandler("User created successfully");
                    break;

                case 2:
                    System.out.print("Enter Device ID: ");
                    String deviceId = scanner.nextLine();

                    System.out.print("Enter Device Name: ");
                    String deviceName = scanner.nextLine();

                    Device device = new Device(deviceId, deviceName);
                    gateway.registerDevice(device);
                    break;

                case 3:
                    System.out.print("Enter Device ID: ");
                    String dId = scanner.nextLine();

                    System.out.print("Enter Status (ON/OFF): ");
                    String status = scanner.nextLine();

                    gateway.updateDeviceStatus(dId, status);
                    break;

                case 4:
                    System.out.println("---- Users ----");
                    userRepository.findAll()
                            .forEach(u -> System.out.println(u.getId() + " - " + u.getName() + " (" + u.getRole() + ")"));
                    break;

                case 5:
                    System.out.println("---- Devices ----");
                    deviceRepository.findAll()
                            .forEach(d ->
                                    System.out.println(d.getId() + " - " + d.getName()));
                    break;

                case 6:
                    running = false;
                    System.out.println("Exiting Smart Home System...");
                    break;

                default:
                    System.out.println("Invalid option");
            }
        }
        scanner.close();
    }
}
