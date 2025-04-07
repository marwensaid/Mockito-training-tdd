package io.github.usermanagement.regression;

import io.github.usermanagement.model.User;
import io.github.usermanagement.repository.UserRepository;
import io.github.usermanagement.service.UserService;
import io.github.usermanagement.service.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegressionTest {

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
    void testAddUserRegression() {
        userService.addUser(user);
        User foundUser = userService.findUserById(1L);

        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    void testRemoveUserRegression() {
        userService.addUser(user);
        userService.removeUser(1L);

        User foundUser = userService.findUserById(1L);
        assertNull(foundUser);
    }

    @Test
    void testUpdateUserRegression() {
        userService.addUser(user);
        user.setName("Jane Doe");
        userService.updateUser(user);

        User updatedUser = userService.findUserById(1L);
        assertEquals("Jane Doe", updatedUser.getName());
    }
}