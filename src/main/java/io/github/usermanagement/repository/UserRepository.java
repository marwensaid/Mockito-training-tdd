package io.github.usermanagement.repository;


import io.github.usermanagement.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {
    private Map<Long, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public Optional<User> findUserById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public void removeUserById(Long id) {
        users.remove(id);
    }

    public void updateUser(User user) {
        users.put(user.getId(), user);
    }
}