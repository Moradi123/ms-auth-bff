package ms_auth_bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ms_auth_bff.model.dto.CourseDTO;
import ms_auth_bff.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/users")
@Tag(name = "Usuarios y Cursos - BFF", description = "Endpoints BFF que combinan información de usuarios y cursos")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Obtener información de un curso", 
               description = "Este endpoint del BFF obtiene los detalles de un curso específico.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Curso encontrado y devuelto"),
        @ApiResponse(responseCode = "404", description = "El curso no fue encontrado")
    })
    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseDTO> getCourseInfo(
            @Parameter(description = "ID del curso que se desea consultar", required = true, example = "1") 
            @PathVariable Long id) {
        CourseDTO course = userService.getCourseDetails(id);
        if (course != null) {
            return ResponseEntity.ok(course);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
