package springboot.kakao_boot_camp.controller;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.kakao_boot_camp.dto.AuthReqDto;
import springboot.kakao_boot_camp.dto.AuthResDto;
import springboot.kakao_boot_camp.dto.UserResDto;
import springboot.kakao_boot_camp.entity.User;
import springboot.kakao_boot_camp.service.UserService;

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
