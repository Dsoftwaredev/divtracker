package controllertest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.dmwlabs.DividendTracker.DividendTrackerApplication;
import com.fasterxml.jackson.databind.ObjectMapper;
import controllers.UsersController;
import entities.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import repositories.UsersRepository;

import java.util.List;
import java.util.Optional;


@AutoConfigureMockMvc
@ActiveProfiles("test")
@SpringBootTest(classes = {UsersController.class, UsersRepository.class, DividendTrackerApplication.class})
public class UserControllerTest {


    @Autowired
    private UsersController controller;

    @MockBean
    private UsersRepository repo;


    @Autowired
    private MockMvc mock;



    @Autowired
    private ObjectMapper jsonifier;



    private final Integer TEST_ID = 1;
    private final Users TEST_USER = new Users(null, "Daniel", 2000, "danielw288@icloud.com");

    @Test
    public void create() {

        Users expected = TEST_USER;
        expected.setId(TEST_ID);

        try {

            mock.perform(get("/users").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                            .content(this.jsonifier.writeValueAsString(TEST_USER)))

            .andExpect(status().isOk())
                    .andExpect(content().json(this.jsonifier.writeValueAsString(expected)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }




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

    @Test
    void testReadById() {
        final Users TEST_USER = new Users("Daniel", 2600, "danielw288@icloud.com");
        final Users TEST_SAVED_USER = new Users(1, "Daniel", 2600, "danielw288@icloud.com");
        Mockito.when(this.repo.save(TEST_USER)).thenReturn(TEST_SAVED_USER);
        Assertions.assertThat(this.controller.getUserById(1)).isEqualTo(TEST_SAVED_USER);
        Mockito.verify(this.repo, Mockito.times(1)).findById(1);
    }

    @Test
    void testReadAll() {
        final Users TEST_USER = new Users("Daniel", 2600, "danielw288@icloud.com");
        final Users TEST_SAVED_USER = new Users(1, "Daniel", 2600, "danielw288@icloud.com");
        Mockito.when(this.repo.save(TEST_USER)).thenReturn(TEST_SAVED_USER);
        Assertions.assertThat(this.controller.getAllUsers()).isEqualTo(TEST_SAVED_USER);
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    void testUpdate() {
    }

    @Test
    void testDelete() {
    }

}