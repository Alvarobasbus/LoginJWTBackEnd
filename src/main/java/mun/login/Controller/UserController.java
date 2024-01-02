package mun.login.Controller;

import lombok.RequiredArgsConstructor;
import mun.login.Model.User.UserDTO;
import mun.login.Model.User.UserRequest;
import mun.login.Model.User.UserResponse;
import mun.login.Services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin (origins = {"http://localhost:4200"})
public class UserController {

    private final UserService userService;

    @GetMapping(value = "{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Integer id){
        UserDTO userDTO= userService.getUser(id);
        if(userDTO==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping()
    public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.updateUser(userRequest));
    }

}
