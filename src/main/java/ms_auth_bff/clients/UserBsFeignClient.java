package ms_auth_bff.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import ms_auth_bff.model.dto.UserDTO;

@FeignClient(name ="ms-auth-bs", url= "http://localhost:8081/")
public interface UserBsFeignClient {
    @GetMapping("users/{id}")
    UserDTO findUserById(@PathVariable("id") Long id);

    static boolean validateUserPermission(Long userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validateUserPermission'");
    }
}
