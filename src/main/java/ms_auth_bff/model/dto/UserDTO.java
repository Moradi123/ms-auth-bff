package ms_auth_bff.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {
    private long id;
    private String username;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private String role;


}