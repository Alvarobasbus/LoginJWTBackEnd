package mun.login.Services;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import mun.login.Model.User.*;
import mun.login.Repositories.UserRepository;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public UserResponse updateUser(UserRequest userRequest){
        User user = User.builder()
                .id(userRequest.getId())
                .username(userRequest.getUsername())
                .firstname(userRequest.getFirstname())
                .lastname(userRequest.getLastname())
                .country(userRequest.getCountry())
                .role(Role.USER)
                .build();

        userRepository.updateUser(user.getId(), user.getFirstname(), user.getLastname(), user.getCountry());
        return new UserResponse("El usuario se registro satisfactoriamente");
    }

    public UserDTO getUser(Integer id){
        User user = userRepository.findById(id).orElse(null);
        if(user!=null){
            UserDTO userDTO = UserDTO.builder()
                    .id(user.getId())
                    .username(user.getUsername())
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .country(user.getCountry())
                    .build();
            return userDTO;
        }
        return  null;
    }
}
