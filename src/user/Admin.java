package user;

import java.util.Objects;

public class Admin extends User{


    public Admin(String id, String name) {
        super(id, name);
    }

    @Override
    public String getRole() {
        return "ADMIN";
    }

    @Override
    public int hashCode() {
        return name.hashCode() + id.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        User user = (User) obj;
        return Objects.equals(id , user.id) && Objects.equals(name , user.name);
    }
}
