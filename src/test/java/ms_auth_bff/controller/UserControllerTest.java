package ms_auth_bff.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import ms_auth_bff.model.dto.CourseDTO;
import ms_auth_bff.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    void testGetCourseInfo_Found() throws Exception {
        Long courseId = 5L;
        CourseDTO mockCourse = new CourseDTO(courseId, "Base de datos", "MySql con Mongo", 105L, 4000L);
        when(userService.getCourseDetails(courseId)).thenReturn(mockCourse);

        mockMvc.perform(get("/api/users/courses/{id}", courseId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.course_id").value(courseId))
                .andExpect(jsonPath("$.description").value("MySql con Mongo"));
    }

    @Test
    void testGetCourseInfo_NotFound() throws Exception {
        Long courseId = 99L;
        when(userService.getCourseDetails(courseId)).thenReturn(null);

        mockMvc.perform(get("/api/users/courses/{id}", courseId))
                .andExpect(status().isNotFound());
    }
}