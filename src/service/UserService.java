package service;

import exception.SmartHomeErrors;
import user.Admin;
import user.HomeOwner;
import user.User;

public class UserService {

    public static User createUser(String role, String id, String name) {
        switch (role.toUpperCase()) {
            case  "ADMIN":
                return new Admin(id, name);
            case "HOMEOWNER":
                return new HomeOwner(id, name);
            default:
                throw new SmartHomeErrors.SmartHomeException("Invalid user role");
        }
    }
}
