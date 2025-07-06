package ms_auth_bff.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(description = "DTO para los datos de un usuario")
public class UserDTO {
    @Schema(description = "ID del usuario", example = "1")
    private long id;
    @Schema(description = "Nombre de usuario", example = "Marc.elo")
    private String username;
    @Schema(description = "Contraseña", example = "password123")
    private String password;
    @Schema(description = "Email del usuario", example = "Marc.elo@example.com")
    private String email;
    @Schema(description = "Nombre", example = "Marc")
    private String first_name;
    @Schema(description = "Apellido", example = "Elo")
    private String last_name;
    @Schema(description = "Rol del usuario", example = "STUDENT")
    private String role;
}