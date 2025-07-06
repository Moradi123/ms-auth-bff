package ms_auth_bff.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import ms_auth_bff.clients.CourseBsFeignClient;
import ms_auth_bff.model.dto.CourseDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private CourseBsFeignClient courseFeignClient;

    @InjectMocks
    private UserService userService;

    @Test
    void testGetCourseDetails() {
        Long courseId = 5L;
        CourseDTO mockCourse = new CourseDTO(courseId, "base de datos", "MySQL y MongoDB", 105L, 60000L);
        when(courseFeignClient.findCourseById(courseId)).thenReturn(mockCourse);
        CourseDTO result = userService.getCourseDetails(courseId);

        assertNotNull(result);
        assertEquals("base de datos", result.getTitle());
        verify(courseFeignClient).findCourseById(courseId);
    }
    
    @Test
    void testGetCourseDetails_ClientError() {
        Long courseId = 5L;
        when(courseFeignClient.findCourseById(courseId)).thenThrow(new RuntimeException("Error de conexión"));
        CourseDTO result = userService.getCourseDetails(courseId);

        assertNull(result);
        verify(courseFeignClient).findCourseById(courseId);
    }
}