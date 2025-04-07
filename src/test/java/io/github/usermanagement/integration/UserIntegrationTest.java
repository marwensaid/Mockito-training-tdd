package io.github.usermanagement.integration;

import io.github.usermanagement.model.User;
import io.github.usermanagement.repository.UserRepository;
import io.github.usermanagement.service.UserService;
import io.github.usermanagement.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserIntegrationTest {

    private UserRepository userRepository;
    private UserService userService;
    private User user;

    @BeforeEach
    void setUp() {
        userRepository = new UserRepository();
        userService = new UserServiceImpl(userRepository);
        user = new User(1L, "John Doe", "john.doe@example.com");
    }

    @Test
    void testAddAndFindUser() {
        userService.addUser(user);
        User foundUser = userService.findUserById(1L);

        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    void testRemoveUser() {
        userService.addUser(user);
        userService.removeUser(1L);

        User foundUser = userService.findUserById(1L);
        assertNotNull(foundUser);
    }

    @Test
    void testUpdateUser() {
        userService.addUser(user);
        user.setName("Jane Doe");
        userService.updateUser(user);

        User updatedUser = userService.findUserById(1L);
        assertEquals("Jane Doe", updatedUser.getName());
    }
}