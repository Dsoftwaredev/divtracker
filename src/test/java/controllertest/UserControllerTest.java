package controllertest;

import controllers.UsersController;
import entities.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import repositories.UsersRepository;

import java.util.*;

@SpringBootTest(classes = {UsersController.class, UsersRepository.class})
public class UserControllerTest {


    @Autowired
    private UsersController controller;

    @MockBean
    private UsersRepository repo;

    @Test
    void testCreate() {
        final Users TEST_USER = new Users("Daniel", 2600, "danielw288@icloud.com");
        final Users TEST_SAVED_USER = new Users(1, "Daniel", 2600, "danielw288@icloud.com");

        // WHEN
        Mockito.when(this.repo.save(TEST_USER)).thenReturn(TEST_SAVED_USER);

        // THEN
        Assertions.assertThat(this.controller.createNewUser(TEST_USER)).isEqualTo(TEST_SAVED_USER);

        // verify that our repo was accessed exactly once
        Mockito.verify(this.repo, Mockito.times(1)).save(TEST_USER);
    }

}