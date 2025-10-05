package springboot.kakao_boot_camp.domain.user.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.kakao_boot_camp.domain.user.dto.UserResDto;
import springboot.kakao_boot_camp.entity.User;
import springboot.kakao_boot_camp.domain.user.service.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<UserResDto> signUp(){

        List<User> users =userService.getUsers();

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("header 1","halo")  //  key : value
                .body(new UserResDto(users));

    }
}
