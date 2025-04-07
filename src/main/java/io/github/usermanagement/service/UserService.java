package io.github.usermanagement.service;


import io.github.usermanagement.model.User;

public interface UserService {
    void addUser(User user);
    User findUserById(Long id);
    void removeUser(Long id);
    void updateUser(User user);
}