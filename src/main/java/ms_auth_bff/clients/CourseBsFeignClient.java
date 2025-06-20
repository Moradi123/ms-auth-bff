package ms_auth_bff.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ms_auth_bff.model.dto.CourseDTO;

@FeignClient(name = "ms-course-bs", url = "http://localhost:8182/")
public interface CourseBsFeignClient {
    @GetMapping("courses/{id}")
    CourseDTO findCourseById(@PathVariable("id") Long id);
}
