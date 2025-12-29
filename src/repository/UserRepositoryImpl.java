package repository;

import user.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryImpl implements  UserRepository{

    private static final Map<String, User> USERS = new HashMap<>();
    @Override
    public void save(User user) {
        USERS.put(user.getId(), user);
    }

    @Override
    public User findById(String id) {
        return USERS.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(USERS.values());
    }
}
