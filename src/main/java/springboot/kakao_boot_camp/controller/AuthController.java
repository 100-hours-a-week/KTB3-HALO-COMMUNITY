package springboot.kakao_boot_camp.controller;


import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import springboot.kakao_boot_camp.dto.AuthDtos.*;
import springboot.kakao_boot_camp.dto.AuthResDto;
import springboot.kakao_boot_camp.global.api.ApiResponse;
import springboot.kakao_boot_camp.service.AuthService;

@RequiredArgsConstructor
@RestController("/api/auth")     // v1, v2 같은 버전은 추후 버전 관리를 위해 필요한 것인데 해당 프로젝트는 학습용 이므로 추후에 유지 보수 예정 X -> 따라서 버전 명 명시 안할 예정
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<SignRes>> signUp(@RequestBody @Valid SignReq req, HttpServletResponse servletRes) {

        SignRes res = authService.signUp(req);    //data 얻기

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(ApiResponse.ok("register_success",res));
                //.body(ApiReponse.ok(authResDto);
    }
}
