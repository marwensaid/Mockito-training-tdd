package io.github.usermanagement.service;


import io.github.usermanagement.model.User;
import io.github.usermanagement.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user);
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findUserById(id).orElse(null);
    }

    @Override
    public void removeUser(Long id) {
        userRepository.removeUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }
}