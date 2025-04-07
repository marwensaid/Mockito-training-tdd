package io.github.usermanagement.service;

import io.github.usermanagement.model.User;
import io.github.usermanagement.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User(1L, "John Doe", "john.doe@example.com");
    }

    @Test
    void testAddUser() {
        userService.addUser(user);
        verify(userRepository, times(1)).addUser(user);
    }

    @Test
    void testFindUserById() {
        when(userRepository.findUserById(1L)).thenReturn(Optional.of(user));

        User foundUser = userService.findUserById(1L);
        assertNotNull(foundUser);
        assertEquals("John Doe", foundUser.getName());
    }

    @Test
    void testRemoveUser() {
        userService.removeUser(1L);
        verify(userRepository, times(1)).removeUserById(1L);
    }

    @Test
    void testUpdateUser() {
        userService.updateUser(user);
        verify(userRepository, times(1)).updateUser(user);
    }
}