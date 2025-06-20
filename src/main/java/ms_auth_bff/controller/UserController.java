package ms_auth_bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ms_auth_bff.model.dto.CourseDTO;
import ms_auth_bff.service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> getCourseInfo(@PathVariable Long id) {
        CourseDTO course = userService.getCourseDetails(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

    /* @GetMapping("/users/{userId}/courses/{courseId}")
    public ResponseEntity<?> getCourseInfoForUser(@PathVariable Long userId, @PathVariable Long courseId) {
        try {
            CourseDTO courseDTO = userService.getCourseIfAuthorized(userId, courseId);
            return ResponseEntity.ok(courseDTO);
        } catch (RuntimeException e) {
          return ResponseEntity.status(403).body(e.getMessage());
        }
   }

public class UserController {
  @Autowired
    UserService userService;

   @GetMapping("/users")
    public List<UserDTO> selectAllUser(){
      return userService.selectAllUser();
  }
}*/
