package ms_auth_bff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ms_auth_bff.clients.CourseBsFeignClient;
//import ms_auth_bff.clients.UserBsFeignClient;
import ms_auth_bff.model.dto.CourseDTO;

@Service
public class UserService {

    //@Autowired
    //UserBsFeignClient authBsFeignClient;
    @Autowired
    CourseBsFeignClient courseFeignClient;
     public CourseDTO getCourseDetails(Long courseId) {
        try {
            return courseFeignClient.findCourseById(courseId);
        } catch (Exception e) {
            System.err.println("Error al llamar a ms-courses-bs: " + e.getMessage());
            return null;
        }
    }
}


