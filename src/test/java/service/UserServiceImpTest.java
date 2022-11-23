package service;

import dto.UserRegistrationRequest;
import dto.UserRegistrationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes={UserServiceImpl.class, UserService.class})
class UserServiceImpTest {
    @Autowired
    private UserService userService;
    private UserRegistrationRequest userRegistrationRequest;

    @BeforeEach
    void setUp(){
         userRegistrationRequest = UserRegistrationRequest.builder()
                .firstName("John")
                .lastName("Nkwachi")
                .email("john@gmail.com")
                .password("johnny").build();


    }
    @Test
    void register() {
        var firstUser = userService.register(userRegistrationRequest);
        assertNotNull(firstUser);
        assertEquals("successful", firstUser.getMessage());


    }
    @Disabled
    @Test
    void login() {
    }
    @Disabled
    @Test
    void delete() {
    }
}